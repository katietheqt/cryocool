package me.katie.cryocool.mixin;

import net.minecraft.client.gui.screens.worldselection.WorldSelectionList;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WorldSelectionList.class)
public class WorldSelectionListMixin {
    @Redirect(
            method = "loadLevels",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/slf4j/Logger;error(Ljava/lang/String;Ljava/lang/Throwable;)V",
                    remap = false
            )
    )
    private void cryocool_removeUselessLog(Logger instance, String s, Throwable throwable) {

    }
}
