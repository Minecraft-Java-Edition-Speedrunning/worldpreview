package me.voidxwalker.worldpreview.mixin.server;

import me.voidxwalker.worldpreview.WorldPreview;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin{

    @Redirect(method = "moveToSpawn", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
    private int worldpreview_setSpawnPos(Random defaultRandom, int k){
        if(WorldPreview.spawnPos != null){
            int value = WorldPreview.playerSpawn;
            WorldPreview.spawnPos=null;
            return value;
        }
        return defaultRandom.nextInt(k);
    }
}