package dev.igalaxy.takeitslow.mixin;

import dev.igalaxy.takeitslow.TakeItSlow;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @ModifyVariable(method = "setSprinting(Z)V", at = @At("HEAD"))
    private boolean modifySetSprinting(boolean bl) {
        if (((Object) this) instanceof LocalPlayer) {
            LocalPlayer player = (LocalPlayer) (Object) this;

            GameType localPlayerMode = ((LocalPlayerAccessor)player).getMinecraft().gameMode.getPlayerMode();

            boolean allowSwimming = TakeItSlow.getConfig().allowSwimming;
            boolean allowCreative = TakeItSlow.getConfig().allowCreative;

            boolean isUnderwater = player.isUnderWater();
            boolean isCreative = localPlayerMode == GameType.CREATIVE;
            boolean isSpectator = localPlayerMode == GameType.SPECTATOR;

            return (isUnderwater && bl && allowSwimming) || (isCreative && bl && allowCreative) || (isSpectator && bl && allowCreative);
        }
        return bl;
    }
}
