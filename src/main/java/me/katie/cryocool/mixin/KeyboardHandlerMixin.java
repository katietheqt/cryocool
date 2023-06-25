package me.katie.cryocool.mixin;

import com.mojang.blaze3d.pipeline.RenderTarget;
import me.katie.cryocool.Cryocool;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.File;
import java.util.function.Consumer;

@Mixin(KeyboardHandler.class)
public class KeyboardHandlerMixin {
    @Inject(
            method = "handleDebugKeys",
            cancellable = true,
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/nio/file/Path;toAbsolutePath()Ljava/nio/file/Path;",
                    shift = At.Shift.BEFORE
            )
    )
    private void cryocool_skipTextureDump(int i, CallbackInfoReturnable<Boolean> cir) {
        Cryocool.LOGGER.info("A texture dump (debug keys) was attempted");
        cir.setReturnValue(true);
    }

    @Redirect(
            method = "keyPress",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/Screenshot;grab(Ljava/io/File;Lcom/mojang/blaze3d/pipeline/RenderTarget;Ljava/util/function/Consumer;)V"
            )
    )
    private void cryocool_skipScreenshot(File file, RenderTarget renderTarget, Consumer<Component> consumer) {
        Cryocool.LOGGER.info("A screenshot was attempted");
    }
}
