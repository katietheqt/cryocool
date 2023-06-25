package me.katie.cryocool.mixin;

import net.minecraft.client.telemetry.ClientTelemetryManager;
import net.minecraft.client.telemetry.TelemetryLogManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Mixin(ClientTelemetryManager.class)
public class ClientTelemetryManagerMixin {
    @Mutable
    @Shadow @Final private Path logDirectory;

    @Redirect(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/telemetry/TelemetryLogManager;open(Ljava/nio/file/Path;)Ljava/util/concurrent/CompletableFuture;"
            )
    )
    private CompletableFuture<Optional<TelemetryLogManager>> cryocool_removeTelemetryLogs(Path path) {
        this.logDirectory = null;
        return CompletableFuture.completedFuture(Optional.empty());
    }
}
