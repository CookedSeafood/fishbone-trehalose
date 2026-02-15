package net.hederamc.fishbonetrehalose.mixin;

import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import java.util.ArrayList;
import java.util.List;
import net.hederamc.fishbonetrehalose.api.LivingEntityApi;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.scores.ScoreHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin implements LivingEntityApi {
    @Shadow private boolean dead;
    @Shadow private float yBodyRot;
    @Shadow private float yBodyRotO;
    @Shadow private float yHeadRot;
    @Shadow private float yHeadRotO;

    @Override
    public List<Entry<Holder<Enchantment>>> getEnchantments(ResourceKey<Enchantment> key) {
        List<Entry<Holder<Enchantment>>> enchantments = new ArrayList<>();
        this.getEnchantments().stream().filter(entry -> entry.getKey().is(key)).forEach(entry -> enchantments.add(entry));
        return enchantments;
    }

    @Override
    public List<Entry<Holder<Enchantment>>> getEnchantments() {
        List<Entry<Holder<Enchantment>>> entityEnchantments = new ArrayList<>();
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            ItemStack stack = this.getItemBySlot(slot);
            if (stack.isEmpty()) {
                continue;
            }

            ItemEnchantments enchantments = stack.getEnchantments();
            if (enchantments.isEmpty()) {
                continue;
            }

            enchantments.entrySet().stream().filter(entry -> entry.getKey().value().matchingSlot(slot)).forEach(entry -> entityEnchantments.add(entry));
        }

        return entityEnchantments;
    }

    @Override
    public boolean isDead() {
        return this.dead;
    }

    @Override
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    @Override
    public float getYBodyRot(float partialTickTime) {
        return Mth.lerp(partialTickTime, this.yBodyRotO, this.yBodyRot);
    }

    @Override
    public float getYHeadRot(float partialTickTime) {
        return Mth.lerp(partialTickTime, this.yHeadRotO, this.yHeadRot);
    }

    @Override
    public ScoreHolder getScoreHolder() {
        return ScoreHolder.forNameOnly(((LivingEntity)(Object)this).getStringUUID());
    }

    @Shadow
    public abstract ItemStack getItemBySlot(EquipmentSlot slot);
}
