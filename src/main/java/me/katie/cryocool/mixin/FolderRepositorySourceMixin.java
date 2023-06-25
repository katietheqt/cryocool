package me.katie.cryocool.mixin;

import net.minecraft.server.packs.repository.FolderRepositorySource;
import net.minecraft.server.packs.repository.Pack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.function.Consumer;

@Mixin(FolderRepositorySource.class)
public class FolderRepositorySourceMixin {
    /**
     * @author Katie
     * @reason we don't want to load resource packs (they will never exist)
     */
    @Overwrite
    public void loadPacks(Consumer<Pack> consumer) {

    }
}
