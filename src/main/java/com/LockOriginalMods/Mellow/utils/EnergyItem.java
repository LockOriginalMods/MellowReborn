package com.LockOriginalMods.Mellow.utils;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class EnergyItem extends Item {
    private final Supplier<MellowEnergyStorage> energyStorageProvider;
    protected static int getEnergy(ItemStack itemStack) {
        return itemStack.getCapability(ForgeCapabilities.ENERGY).orElse(null).getEnergyStored();
    }
    protected static void setEnergy(ItemStack itemStack, int energy) {
        ((ItemCapabilityEnergy)itemStack.getCapability(ForgeCapabilities.ENERGY).orElse(null)).setEnergy(energy);
    }
    protected static int getCapacity(ItemStack itemStack) {
        return itemStack.getCapability(ForgeCapabilities.ENERGY).orElse(null).getMaxEnergyStored();
    }

    public EnergyItem(Properties props, Supplier<MellowEnergyStorage> energyStorageProvider) {
        super(props);

        this.energyStorageProvider = energyStorageProvider;
    }

    public boolean isBarVisible(ItemStack stack) {
        return true;
    }

    public int getBarWidth(ItemStack stack) {
        return Math.round(getEnergy(stack) * 13.f / getCapacity(stack));
    }

    public int getBarColor(ItemStack stack) {
        float f = Math.max(0.f, getEnergy(stack) / (float)getCapacity(stack));
        return Mth.hsvToRgb(f * .33f, 1.f, 1.f);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.translatable("tooltip.mellow.energy_meter.content.txt",
                        EnergyUtils.getEnergyWithPrefix(getEnergy(itemStack)), EnergyUtils.getEnergyWithPrefix(getCapacity(itemStack))).
                withStyle(ChatFormatting.GRAY));
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new ItemCapabilityEnergy(stack, stack.getTag(), energyStorageProvider.get());
    }
}