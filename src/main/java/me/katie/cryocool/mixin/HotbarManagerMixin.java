package me.katie.cryocool.mixin;

import com.mojang.datafixers.DataFixer;
import net.minecraft.client.HotbarManager;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;

@Mixin(HotbarManager.class)
public class HotbarManagerMixin {
    @Mutable
    @Shadow @Final private File optionsFile;

    @Inject(
            method = "<init>",
            at = @At("TAIL")
    )
    private void cryocool_nullOutPath(File file, DataFixer dataFixer, CallbackInfo ci) {
        this.optionsFile = null;
    }

    /**
     * @author Katie
     * @reason We don't want to save or load hotbars and this is cleaner than an inject-cancel.
     */
    @Overwrite
    private void load() {

    }

    /**
     * @author Katie
     * @reason We don't want to save or load hotbars and this is cleaner than an inject-cancel.
     */
    @Overwrite
    public void save() {

    }
}
