package rmc.mixins.mahou_tsukai_newmagic.inject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.block.Block;
import stepsword.mahoutsukai.block.spells.Mahoujin;
import stepsword.mahoutsukai.util.EffectUtil;

/**
 * Developed by RMC Team, 2021
 * @author KR33PY
 */
@Mixin(value = Mahoujin.class)
public abstract class MahoujinMixin {

    @Redirect(method = "Lstepsword/mahoutsukai/block/spells/Mahoujin;transformToSpell(Lstepsword/mahoutsukai/tile/MahoujinTileEntity;Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/math/BlockPos;)V",
              remap = false,
              at = @At(value = "INVOKE",
                       target = "Lstepsword/mahoutsukai/util/EffectUtil;inBlockBlacklist(Lnet/minecraft/block/Block;Ljava/util/List;)Z"))
    private boolean disableBannedSpells(Block block, List<? extends String> list) {
        ArrayList<String> combined = new ArrayList<>(Arrays.asList(
            "mahoutsukai:mahoujin_familiars_garden",
            "mahoutsukai:mahoujin_fallen_down",
            "mahoutsukai:mahoujin_displacement_barrier",
            "mahoutsukai:mahoujin_raise_enclosure",
            "mahoutsukai:mahoujin_tangible_barrier",
            "mahoutsukai:mahoujin_gravity_barrier",
            "mahoutsukai:mahoujin_drain_life_barrier",
            "mahoutsukai:mahoujin_ascension",
            "mahoutsukai:mahoujin_projectile_displacement",
            "mahoutsukai:mahoujin_mental_displacement",
            "mahoutsukai:mahoujin_scrying",
            "mahoutsukai:mahoujin_strengthening",
            "mahoutsukai:mahoujin_projection",
            "mahoutsukai:mahoujin_proximity_projection",
            "mahoutsukai:mahoujin_reality_marble",
            "mahoutsukai:mahoujin_treasury_projection",
            "mahoutsukai:mahoujin_damage_replication",
            "mahoutsukai:mahoujin_rho_aias",
            "mahoutsukai:mahoujin_borrowed_authority",
            "mahoutsukai:mahoujin_mystic_eyes",
            "mahoutsukai:mahoujin_black_flame",
            "mahoutsukai:mahoujin_cup_of_heaven",
            "mahoutsukai:mahoujin_death_collection",
            "mahoutsukai:mahoujin_insight",
            "mahoutsukai:mahoujin_butterfly_effect",
            "mahoutsukai:mahoujin_possess_entity",
            "mahoutsukai:mahoujin_immunity_exchange",
            "mahoutsukai:mahoujin_alchemical_exchange",
            "mahoutsukai:mahoujin_presence_concealment",
            "mahoutsukai:mahoujin_gandr"
        ));
        combined.addAll(list);
        return EffectUtil.inBlockBlacklist(block, combined);
    }

}