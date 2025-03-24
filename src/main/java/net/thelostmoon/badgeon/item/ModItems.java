package net.thelostmoon.badgeon.item;

import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.thelostmoon.badgeon.Badgeon;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Badgeon.MODID);

    public static final DeferredItem<Item> DarkBadge = ITEMS.register("darkbadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ElecBadge = ITEMS.register("elecbadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FireBadge = ITEMS.register("firebadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FairyBadge = ITEMS.register("fairybadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SteelBadge = ITEMS.register("steelbadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WaterBadge = ITEMS.register("waterbadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FightBadge = ITEMS.register("fightbadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FlyBadge = ITEMS.register("flybadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BugBadge = ITEMS.register("bugbadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GroundBadge = ITEMS.register("groundbadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PoisonBadge = ITEMS.register("poisonbadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RockBadge = ITEMS.register("rockbadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GhostBadge = ITEMS.register("ghostbadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GrassBadge = ITEMS.register("grassbadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PsychicBadge = ITEMS.register("psychicbadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IceBadge = ITEMS.register("icebadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DragonBadge = ITEMS.register("dragonbadge",() -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NormalBadge = ITEMS.register("normalbadge",() -> new Item(new Item.Properties()));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}

