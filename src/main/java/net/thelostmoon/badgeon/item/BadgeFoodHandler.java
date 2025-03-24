package net.thelostmoon.badgeon.item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;


public class BadgeFoodHandler {
    public static void handleBadgeConsumption(ItemStack stack, Level level, LivingEntity entity) {
        if (level.isClientSide) return;

        Item item = stack.getItem();
        String itemName = item.getDescriptionId();

        String badgeName = getBadgeName(item);
        if (badgeName != null) {
            addBadgeNBT(entity, badgeName);
        }
    }


    private static String getBadgeName(Item item) {
        String itemName = item.getDescriptionId();
        String badgeKey = itemName.substring(itemName.lastIndexOf('.') + 1).replace('.', '_').toLowerCase();
        switch (badgeKey) {
            case "darkbadge": return "DarkBadge";
            case "elecbadge": return "ElecBadge";
            case "firebadge": return "FireBadge";
            case "fairybadge": return "FairyBadge";
            case "steelbadge": return "SteelBadge";
            case "waterbadge": return "WaterBadge";
            case "fightbadge": return "FightBadge";
            case "flybadge": return "FlyBadge";
            case "bugbadge": return "BugBadge";
            case "groundbadge": return "GroundBadge";
            case "poisonbadge": return "PoisonBadge";
            case "rockbadge": return "RockBadge";
            case "ghostbadge": return "GhostBadge";
            case "grassbadge": return "GrassBadge";
            case "psychicbadge": return "PsychicBadge";
            case "icebadge": return "IceBadge";
            case "dragonbadge": return "DragonBadge";
            case "normalbadge": return "NormalBadge";
            default:
                return null;
        }
    }


    private static void addBadgeNBT(LivingEntity entity, String badgeName) {
        if (entity == null) return;
        CompoundTag nbt = entity.getPersistentData();
        nbt.putBoolean("badge_" + badgeName, true);
        System.out.println("Added badge NBT: badge_" + badgeName);
    }

    public static boolean hasBadge(LivingEntity entity, String badgeName) {
        if (entity == null) return false;
        CompoundTag nbt = entity.getPersistentData();
        return nbt.getBoolean("badge_" + badgeName);
    }
}