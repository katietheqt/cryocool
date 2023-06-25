package me.katie.cryocool.mixin;

import me.katie.cryocool.Cryocool;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.telemetry.TelemetryInfoScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(TelemetryInfoScreen.class)
public class TelemetryInfoScreenMixin {
    /**
     * @author Katie
     * @reason This tries to open a folder that doesn't exist.
     */
    @Overwrite
    private void openDataFolder(Button button) {
        Cryocool.LOGGER.warn("Tried to open telemetry data folder");
    }
}
