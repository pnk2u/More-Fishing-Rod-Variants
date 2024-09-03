package de.pnku.mstv_mfrv.mixin.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
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

    @Unique
    private static Ingredient C_STICK_VARIANTS = Ingredient.of(new ItemLike[]{CARROT_ON_AN_ACACIA_STICK, CARROT_ON_A_BAMBOO_STICK, CARROT_ON_A_BAMBOO_STICK, CARROT_ON_A_BIRCH_STICK, CARROT_ON_A_CHERRY_STICK, CARROT_ON_A_CRIMSON_STICK, CARROT_ON_A_DARK_OAK_STICK, CARROT_ON_A_JUNGLE_STICK, CARROT_ON_A_MANGROVE_STICK, CARROT_ON_A_SPRUCE_STICK, CARROT_ON_A_WARPED_STICK});

    @Inject(method = "registerGoals", at = @At("TAIL"))
    protected void injectedTemptGoalInit (CallbackInfo ci) {
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2, C_STICK_VARIANTS, false));
    }

    @Redirect(method = "getControllingPassenger", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    public boolean redirectedPlayerIsHolding(ItemStack stack, Item item) {
        return more_carrot_on_a_stick_variants.contains(stack.getItem()) || stack.is(Items.CARROT_ON_A_STICK);
    }
}