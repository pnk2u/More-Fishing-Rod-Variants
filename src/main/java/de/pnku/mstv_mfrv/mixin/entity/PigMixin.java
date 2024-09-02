package de.pnku.mstv_mfrv.mixin.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static de.pnku.mstv_mfrv.item.MoreFishingRodVariantItems.*;

@Mixin(Pig.class)
public class PigMixin extends PathfinderMob {

    protected PigMixin(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "registerGoals", at = @At("TAIL"))
    protected void injectedTemptGoalInit (CallbackInfo ci) {
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2, (itemStack) -> {
            return more_carrot_on_a_stick_variants.contains(itemStack.getItem());
        }, false));
    }

    @Redirect(method = "getControllingPassenger", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;isHolding(Lnet/minecraft/world/item/Item;)Z"))
    public boolean redirectedPlayerIsHolding(Player player, Item item) {
        return more_carrot_on_a_stick_variants.contains(player.getOffhandItem().getItem()) || (more_carrot_on_a_stick_variants.contains(player.getMainHandItem().getItem())) || player.isHolding(Items.CARROT_ON_A_STICK);
    }
}
