package me.katie.cryocool.mixin;

import net.minecraft.client.resources.DownloadedPackSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.net.URL;
import java.util.concurrent.CompletableFuture;

@Mixin(DownloadedPackSource.class)
public class DownloadedPackSourceMixin {
    /**
     * @author Katie
     * @reason we never want to actually download resource packs (we just lie that we did to please the server)
     */
    @Overwrite
    public CompletableFuture<?> downloadAndSelectResourcePack(URL uRL, String string, boolean bl) {
        return CompletableFuture.completedFuture(null);
    }
}
