package me.katie.cryocool.mixin;

import net.minecraft.client.multiplayer.AccountProfileKeyPairManager;
import net.minecraft.world.entity.player.ProfileKeyPair;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Optional;

@Mixin(AccountProfileKeyPairManager.class)
public class AccountProfileKeyPairManagerMixin {
    /**
     * @author Katie
     * @reason We have nowhere to cache keypairs, just skip it.
     */
    @Overwrite
    private Optional<ProfileKeyPair> readProfileKeyPair() {
        return Optional.empty();
    }

    /**
     * @author Katie
     * @reason We have nowhere to cache keypairs, just skip it.
     */
    @Overwrite
    private void writeProfileKeyPair(@Nullable ProfileKeyPair profileKeyPair) {

    }
}
