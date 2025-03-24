package net.thelostmoon.badgeon.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties DarkBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties ElecBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties FireBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties FairyBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties SteelBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties WaterBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties FightBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties FlyBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties BugBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties GroundBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties PoisonBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties RockBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties GhostBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties GrassBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties PsychicBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties IceBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties DragonBadge = new FoodProperties.Builder().alwaysEdible().fast().build();
    public static final FoodProperties NormalBadge = new FoodProperties.Builder().alwaysEdible().fast().build();

    private static void addBadgeNBT(LivingEntity entity, String badgeName) {
        if (entity == null) return;
        CompoundTag nbt = entity.getPersistentData();
        nbt.putBoolean("badge_" + badgeName, true);
    }

    public static boolean hasBadge(LivingEntity entity, String badgeName) {
        if (entity == null) return false;
        CompoundTag nbt = entity.getPersistentData();
        return nbt.getBoolean("badge_" + badgeName);
    }

}
