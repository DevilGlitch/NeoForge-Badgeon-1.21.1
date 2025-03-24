package net.thelostmoon.badgeon.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.nbt.CompoundTag;

import java.util.ArrayList;
import java.util.List;

public class BadgeCommands {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("badge")
                .requires(source -> source.hasPermission(2))
                .then(Commands.literal("view")
                        .then(Commands.argument("player", EntityArgument.player())
                                .executes(context -> viewBadges(context.getSource(), EntityArgument.getPlayer(context, "player")))))
                .then(Commands.literal("reset")
                        .then(Commands.argument("player", EntityArgument.player())
                                .executes(context -> resetBadges(context.getSource(), EntityArgument.getPlayer(context, "player")))))
                .then(Commands.literal("remove")
                        .then(Commands.argument("player", EntityArgument.player())
                                .then(Commands.argument("badgeName", StringArgumentType.word())
                                        .executes(context -> removeBadge(context.getSource(), EntityArgument.getPlayer(context, "player"), StringArgumentType.getString(context, "badgeName")))))));
    }

    private static int viewBadges(CommandSourceStack source, ServerPlayer player) {
        CompoundTag nbt = player.getPersistentData();
        StringBuilder messageBuilder = new StringBuilder("Badges for " + player.getName().getString() + ":\n");
        boolean hasBadges = false;

        for (String key : nbt.getAllKeys()) {
            if (key.startsWith("badge_") && nbt.getBoolean(key)) {
                String badgeName = key.substring(6); // Remove "badge_" prefix
                messageBuilder.append(badgeName).append(": true\n");
                hasBadges = true;
            }
        }
        if (!hasBadges) {
            messageBuilder.append("None");
        }

        Component finalMessage = Component.literal(messageBuilder.toString());
        source.sendSuccess(() -> finalMessage, true);
        return 1;
    }


    private static int resetBadges(CommandSourceStack source, ServerPlayer player) {
        CompoundTag nbt = player.getPersistentData();

        // Collect the keys to remove in a list
        List<String> keysToRemove = new ArrayList<>();

        // Iterate over the keys and collect the ones that start with "badge_"
        for (String key : nbt.getAllKeys()) {
            if (key.startsWith("badge_")) {
                keysToRemove.add(key);
            }
        }

        // Now remove the collected keys outside the iteration
        for (String key : keysToRemove) {
            nbt.remove(key);
        }

        source.sendSuccess(() -> Component.literal("Badges reset for " + player.getName().getString()), true);
        return 1;
    }


    private static int removeBadge(CommandSourceStack source, ServerPlayer player, String badgeName) {
        CompoundTag nbt = player.getPersistentData();
        String badgeKey = "badge_" + badgeName;

        if (nbt.contains(badgeKey)) {
            nbt.remove(badgeKey);
            source.sendSuccess(() -> Component.literal(badgeName + " badge removed from " + player.getName().getString()), true);
        } else {
            source.sendFailure(Component.literal(player.getName().getString() + " does not have the " + badgeName + " badge."));
        }
        return 1;
    }
}