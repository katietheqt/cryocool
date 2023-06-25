package me.katie.cryocool.mixin;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.storage.LevelStorageException;
import net.minecraft.world.level.storage.LevelStorageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.nio.file.LinkOption;
import java.nio.file.Path;

@Mixin(LevelStorageSource.class)
public class LevelStorageSourceMixin {
    @Redirect(
            method = "parseValidator",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/nio/file/Files;exists(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z"
            )
    )
    private static boolean cryocool_skipSymlinkValidatorLoad(Path provider, LinkOption[] x) {
        return false;
    }

    @Redirect(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/FileUtil;createDirectoriesSafe(Ljava/nio/file/Path;)V"
            )
    )
    private void cryocool_dontCreateDirectories(Path path) {

    }

    @Inject(
            method = "findLevelCandidates",
            at = @At("HEAD")
    )
    private void cryocool_forceThrowError(CallbackInfoReturnable<LevelStorageSource.LevelCandidates> cir) {
        throw new LevelStorageException(Component.literal("level reading disabled (cryocool installed)"));
    }

    /**
     * @author Katie
     * @reason we don't want to ever access or create levels
     */
    @Overwrite
    public boolean levelExists(String string) {
        return false;
    }

    /**
     * @author Katie
     * @reason we don't want to ever access or create levels
     */
    @Overwrite
    public boolean isNewLevelIdAcceptable(String string) {
        return true;
    }
}
