package net.xanthian.hardhatsteve.common.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.util.NbtType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.xanthian.hardhatsteve.HardHatSteve;
import net.xanthian.hardhatsteve.config.HHSConfig;

import java.util.UUID;

public class BuildersApparelItem extends DyeableArmorItem {
    private static final UUID[] MODIFIERS = new UUID[]{
        UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"),
        UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"),
        UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"),
        UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")
    };
    private final int defaultColor;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public BuildersApparelItem(ArmorMaterial armorMaterial_1, EquipmentSlot equipmentSlot_1, int defaultColor) {
        super(armorMaterial_1, equipmentSlot_1,new FabricItemSettings().group(HardHatSteve.HARD_HAT_STEVE));
        this.defaultColor = defaultColor;
        this.attributeModifiers = ImmutableMultimap.of(ReachEntityAttributes.REACH, new EntityAttributeModifier(MODIFIERS[slot.getEntitySlotId()],
                "Reach modifier", HHSConfig.reach, EntityAttributeModifier.Operation.ADDITION));
    }

    @Override
    public int getColor(ItemStack stack) {
        NbtCompound compoundTag_1 = stack.getOrCreateSubNbt("display");
        return compoundTag_1 != null && compoundTag_1.contains("color", NbtType.NUMBER) ? compoundTag_1.getInt("color") : defaultColor;
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == this.slot ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }
}
