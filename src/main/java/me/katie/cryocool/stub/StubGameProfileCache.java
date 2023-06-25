package me.katie.cryocool.stub;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.players.GameProfileCache;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/**
 * {@link GameProfileCache} subclass that always returns nothing and ignores writes.
 */
public class StubGameProfileCache extends GameProfileCache {
    public StubGameProfileCache() {
        super(null, null);
    }

    @Override
    public void add(@NotNull GameProfile gameProfile) {

    }

    @Override
    public @NotNull Optional<GameProfile> get(@NotNull String name) {
        return Optional.empty();
    }

    @Override
    public void getAsync(@NotNull String name, Consumer<Optional<GameProfile>> consumer) {
        consumer.accept(Optional.empty());
    }

    @Override
    public @NotNull Optional<GameProfile> get(@NotNull UUID uuid) {
        return Optional.empty();
    }

    @Override
    public void setExecutor(@NotNull Executor executor) {

    }

    @Override
    public void clearExecutor() {

    }

    @Override
    public @NotNull List<GameProfileCache.GameProfileInfo> load() {
        return Collections.emptyList();
    }

    @Override
    public void save() {
        
    }
}
