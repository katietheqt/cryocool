package me.katie.cryocool.mixin;

import net.minecraft.FileUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.nio.file.Path;

@Mixin(FileUtil.class)
public class FileUtilMixin {
    /**
     * @author Katie
     * @reason This is used to determine good locations for files, but since we always say they don't exist whatever
     * the provided name is works fine.
     */
    @Overwrite
    public static String findAvailableName(Path path, String string, String string2) {
        return string;
    }
}
