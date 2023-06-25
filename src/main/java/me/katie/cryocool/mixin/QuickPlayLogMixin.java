package me.katie.cryocool.mixin;

import net.minecraft.client.quickplay.QuickPlayLog;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(QuickPlayLog.class)
public class QuickPlayLogMixin {
    @Shadow @Final private static QuickPlayLog INACTIVE;

    /**
     * @author Katie
     * @reason we never want to generate quick play logs
     */
    @Overwrite
    public static QuickPlayLog of(@Nullable String string) {
        return INACTIVE;
    }
}
