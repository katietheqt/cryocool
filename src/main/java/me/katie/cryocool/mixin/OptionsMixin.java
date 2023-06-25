package me.katie.cryocool.mixin;

import net.minecraft.client.Options;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.io.File;

@Mixin(Options.class)
public class OptionsMixin {
    @Mutable
    @Shadow @Final private File optionsFile;

    @Redirect(
            method = "<init>",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/client/Options;optionsFile:Ljava/io/File;",
                    opcode = Opcodes.PUTFIELD
            )
    )
    private void cryocool_removeOptionsFile(Options instance, File value) {
        this.optionsFile = null;
    }

    /**
     * @author Katie
     * @reason We don't want to save or load options and this is cleaner than an inject-cancel.
     */
    @Overwrite
    public void load() {

    }

    /**
     * @author Katie
     * @reason We don't want to save or load options and this is cleaner than an inject-cancel.
     */
    @Overwrite
    public void save() {

    }
}
