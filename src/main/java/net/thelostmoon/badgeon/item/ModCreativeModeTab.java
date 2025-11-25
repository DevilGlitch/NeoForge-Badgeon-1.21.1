package net.thelostmoon.badgeon.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.thelostmoon.badgeon.Badgeon;

import java.util.function.Supplier;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Badgeon.MODID);

    public static final Supplier<CreativeModeTab> BADGEON_ITEMS_TAB = CREATIVE_MODE_TAB.register("badgeon_items_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DarkBadge.get()))
            // .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Badgeon.MODID, ">Previous tab name"))
            .title(Component.translatable("creativetab.badgeon.badgeon_items"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.BadgeHolder.get());
                output.accept(ModItems.DarkBadge.get());
                output.accept(ModItems.ElecBadge.get());
                output.accept(ModItems.FairyBadge.get());
                output.accept(ModItems.FightBadge.get());
                output.accept(ModItems.FireBadge.get());
                output.accept(ModItems.FlyBadge.get());
                output.accept(ModItems.SteelBadge.get());
                output.accept(ModItems.WaterBadge.get());
                output.accept(ModItems.BugBadge.get());
                output.accept(ModItems.GroundBadge.get());
                output.accept(ModItems.PoisonBadge.get());
                output.accept(ModItems.RockBadge.get());
                output.accept(ModItems.GhostBadge.get());
                output.accept(ModItems.GrassBadge.get());
                output.accept(ModItems.PsychicBadge.get());
                output.accept(ModItems.IceBadge.get());
                output.accept(ModItems.DragonBadge.get());
                output.accept(ModItems.NormalBadge.get());

        }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
