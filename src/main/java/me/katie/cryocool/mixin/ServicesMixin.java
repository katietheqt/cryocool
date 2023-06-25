package me.katie.cryocool.mixin;

import com.mojang.authlib.GameProfileRepository;
import me.katie.cryocool.stub.StubGameProfileCache;
import net.minecraft.server.Services;
import net.minecraft.server.players.GameProfileCache;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.io.File;

@Mixin(Services.class)
public class ServicesMixin {
    @Redirect(
            method = "create",
            at = @At(
                    value = "NEW",
                    target = "(Lcom/mojang/authlib/GameProfileRepository;Ljava/io/File;)Lnet/minecraft/server/players/GameProfileCache;"
            )
    )
    private static GameProfileCache cryocool_stubGameProfileCache(GameProfileRepository gameProfileRepository, File file) {
        return new StubGameProfileCache();
    }
}
