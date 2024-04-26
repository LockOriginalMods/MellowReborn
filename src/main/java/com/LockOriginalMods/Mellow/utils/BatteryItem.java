package com.LockOriginalMods.Mellow.utils;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class BatteryItem extends EnergyItem {
    private final Tier tier;

    public BatteryItem(Tier tier) {
        super(new Item.Properties().stacksTo(1), () -> new ReceiveAndExtractEnergyStorage(0, tier.getCapacity(), tier.getMaxTransfer()));

        this.tier = tier;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, components, tooltipFlag);

        if(Screen.hasShiftDown()) {
            components.add(Component.translatable("tooltip.mellow.battery.txt.shift.1",
                    EnergyUtils.getEnergyWithPrefix(tier.getMaxTransfer())).withStyle(ChatFormatting.GRAY));
        }else {
            components.add(Component.translatable("tooltip.mellow.shift_details.txt").withStyle(ChatFormatting.YELLOW));
        }
    }

    public enum Tier {
        BATTERY_1("battery_1", 256, 2);

        private final String resourceId;
        private final int capacity;
        private final int maxTransfer;

        Tier(String resourceId, int capacity, int maxTransfer) {
            this.resourceId = resourceId;
            this.capacity = capacity;
            this.maxTransfer = maxTransfer;
        }

        public String getResourceId() {
            return resourceId;
        }

        public int getCapacity() {
            return capacity;
        }

        public int getMaxTransfer() {
            return maxTransfer;
        }
    }
}