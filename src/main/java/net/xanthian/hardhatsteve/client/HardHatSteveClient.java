package net.xanthian.hardhatsteve.client;

import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.item.DyeableItem;
import net.xanthian.hardhatsteve.common.item.HardHatSteveItems;

public class HardHatSteveClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.ITEM.register(
            (stack, colorIndex) -> (colorIndex > 0 ? 0xFFFFFFFF : ((DyeableItem)stack.getItem()).getColor(stack)),
            HardHatSteveItems.HARD_HAT, HardHatSteveItems.SAFETY_VEST, HardHatSteveItems.CONTRACTOR_PANTS, HardHatSteveItems.STEEL_TOED_BOOTS
        );
    }
}
