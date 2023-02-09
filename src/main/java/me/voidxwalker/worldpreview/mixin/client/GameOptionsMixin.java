package me.voidxwalker.worldpreview.mixin.client;

import me.voidxwalker.worldpreview.KeyBindingHelper;
import me.voidxwalker.worldpreview.WorldPreview;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;

@Mixin(GameOptions.class)
public class GameOptionsMixin {
        @Mutable @Final
        @Shadow public KeyBinding[] allKeys;

        @Inject(at = @At("HEAD"), method = "load()V")
        public void loadHook(CallbackInfo info) {
                allKeys = KeyBindingHelper.process(allKeys);
        }

}
