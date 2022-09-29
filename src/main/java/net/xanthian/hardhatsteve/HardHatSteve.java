package net.xanthian.hardhatsteve;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.xanthian.hardhatsteve.common.item.HardHatSteveItems;
import net.xanthian.hardhatsteve.common.sound.HardHatSteveSoundEvents;
import net.xanthian.hardhatsteve.config.HHSConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HardHatSteve implements ModInitializer {
    public static final String MOD_ID = "hard_hat_steve";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final ItemGroup HARD_HAT_STEVE = FabricItemGroupBuilder.build(new Identifier(HardHatSteve.MOD_ID, "hard_hat_steve"),
            () -> new ItemStack(HardHatSteveItems.HARD_HAT));

    @Override
    public void onInitialize() {
        HHSConfig.registerConfigs();
        HardHatSteveSoundEvents.init();
        HardHatSteveItems.init();
    }
}
