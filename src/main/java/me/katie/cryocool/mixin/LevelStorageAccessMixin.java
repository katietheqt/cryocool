package me.katie.cryocool.mixin;

import net.minecraft.world.level.storage.LevelStorageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;
import java.nio.file.Path;

@Mixin(LevelStorageSource.LevelStorageAccess.class)
public class LevelStorageAccessMixin {
    /**
     * @author Katie
     * @reason we don't want to ever access or create levels
     */
    @Overwrite
    public long makeWorldBackup() throws IOException {
        throw new IOException("cryocool: cannot create backups");
    }

    @Inject(
            method = "<init>",
            at = @At("HEAD")
    )
    private static void cryocool_neverOpenLevels(LevelStorageSource levelStorageSource, String string, Path path, CallbackInfo ci) throws IOException {
        throw new IOException("cyrocool: cannot open level");
    }
}
