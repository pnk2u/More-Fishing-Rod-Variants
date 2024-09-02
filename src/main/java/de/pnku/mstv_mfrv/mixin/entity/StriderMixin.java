package de.pnku.mstv_mfrv.mixin.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static de.pnku.mstv_mfrv.item.MoreFishingRodVariantItems.more_carrot_on_a_stick_variants;
import static de.pnku.mstv_mfrv.item.MoreFishingRodVariantItems.more_warped_fungus_on_a_stick_variants;

@Mixin(Strider.class)
public class StriderMixin extends PathfinderMob {

    protected StriderMixin(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "registerGoals", at = @At("TAIL"))
    protected void injectedTemptGoalInit (CallbackInfo ci) {
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2, (itemStack) -> {
            return more_warped_fungus_on_a_stick_variants.contains(itemStack.getItem());
        }, false));
    }

    @Redirect(method = "getControllingPassenger", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;isHolding(Lnet/minecraft/world/item/Item;)Z"))
    public boolean redirectedPlayerIsHolding(Player player, Item item) {
        return more_warped_fungus_on_a_stick_variants.contains(player.getOffhandItem().getItem()) || (more_warped_fungus_on_a_stick_variants.contains(player.getMainHandItem().getItem())) || player.isHolding(Items.WARPED_FUNGUS_ON_A_STICK);
    }
}
