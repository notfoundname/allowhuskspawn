package com.notfoundname.allowhuskspawn.mixins;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(net.minecraft.world.entity.SpawnPlacements.class)
public class SpawnPlacementsMixin {

    @Definition(id = "register", method = "Lnet/minecraft/world/entity/SpawnPlacements;register(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/entity/SpawnPlacementType;Lnet/minecraft/world/level/levelgen/Heightmap$Types;Lnet/minecraft/world/entity/SpawnPlacements$SpawnPredicate;)V")
    @Definition(id = "HUSK", field = "Lnet/minecraft/world/entity/EntityType;HUSK:Lnet/minecraft/world/entity/EntityType;")
    @Expression("register(HUSK, ?, ?, ?)")
    @ModifyArg(
            method = "<clinit>",
            at = @At("MIXINEXTRAS:EXPRESSION")
    )
    private static SpawnPlacements.SpawnPredicate<Mob> spawnPredicate(SpawnPlacements.SpawnPredicate<Mob> original) {
        return Monster::checkMonsterSpawnRules;
    }
}
