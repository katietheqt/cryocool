package me.katie.cryocool.mixin;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(ServerList.class)
public class ServerListMixin {
    @Shadow @Final private List<ServerData> serverList;

    @Shadow @Final private List<ServerData> hiddenServerList;

    /**
     * @author Katie
     * @reason We don't want to save or load the server list and this is cleaner than an inject-cancel.
     */
    @Overwrite
    public void load() {
        this.serverList.clear();
        this.hiddenServerList.clear();
    }


    /**
     * @author Katie
     * @reason We don't want to save or load the server list and this is cleaner than an inject-cancel.
     */
    @Overwrite
    public void save() {

    }
}
