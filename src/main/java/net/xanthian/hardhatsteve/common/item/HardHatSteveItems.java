package net.xanthian.hardhatsteve.common.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.xanthian.hardhatsteve.common.sound.HardHatSteveSoundEvents;

public class HardHatSteveItems {
    public static final ArmorMaterial BUILDERS_APPAREL = new SimpleArmorMaterial(
        "builders_apparel",
        0, new int[] { 0, 0, 0, 0 }, 0, HardHatSteveSoundEvents.ITEM_ARMOR_EQUIP_BUILDERS_APPAREL, 0.0F, 0.0F, () -> Ingredient.EMPTY
    );

    public static final Item HARD_HAT = register("hard_hat", new BuildersApparelItem(BUILDERS_APPAREL, EquipmentSlot.HEAD, 0xFFC000));
    public static final Item SAFETY_VEST = register("safety_vest", new BuildersApparelItem(BUILDERS_APPAREL, EquipmentSlot.CHEST, 0xFFDF00));
    public static final Item CONTRACTOR_PANTS = register("contractor_pants", new BuildersApparelItem(BUILDERS_APPAREL, EquipmentSlot.LEGS, 0x303030));
    public static final Item STEEL_TOED_BOOTS = register("steel_toed_boots", new BuildersApparelItem(BUILDERS_APPAREL, EquipmentSlot.FEET, 0x404040));

    private static Item register(String id, Item item) {
        return register(new Identifier("hard-hat-steve", id), item);
    }

    private static Item register(Identifier id, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registry.ITEM, id, item);
    }

    public static void init() { }
}
