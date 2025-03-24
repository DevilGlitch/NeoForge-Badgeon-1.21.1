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

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}

