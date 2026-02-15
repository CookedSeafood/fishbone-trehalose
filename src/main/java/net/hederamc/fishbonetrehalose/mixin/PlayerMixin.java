package net.hederamc.fishbonetrehalose.mixin;

import com.mojang.authlib.GameProfile;
import net.hederamc.fishbonetrehalose.api.PlayerApi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.scores.ScoreHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Player.class)
public abstract class PlayerMixin implements PlayerApi {
    @Shadow private GameProfile gameProfile;

    @Override
    public ScoreHolder getScoreHolder() {
        return ScoreHolder.fromGameProfile(this.gameProfile);
    }
}
