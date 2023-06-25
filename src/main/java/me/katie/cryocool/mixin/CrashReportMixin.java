package me.katie.cryocool.mixin;

import net.minecraft.CrashReport;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.io.File;

@Mixin(CrashReport.class)
public class CrashReportMixin {
    /**
     * @author Katie
     * @reason we don't want to save crash reports
     */
    @Overwrite
    public boolean saveToFile(File file) {
        return false;
    }
}
