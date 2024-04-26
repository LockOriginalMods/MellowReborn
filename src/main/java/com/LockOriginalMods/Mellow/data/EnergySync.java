package com.LockOriginalMods.Mellow.data;

import com.LockOriginalMods.Mellow.block.IEnergyHandlingBlockEntity;
import com.LockOriginalMods.Mellow.block.furnace.ElectricFurnaceBlockEntity;
import com.LockOriginalMods.Mellow.block.furnace.ElectricFurnaceMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class EnergySync {
    private final int energy;
    private final BlockPos pos;

    public EnergySync(int energy, BlockPos pos) {
        this.energy = energy;
        this.pos = pos;
    }

    public EnergySync(FriendlyByteBuf buf) {
        this.energy = buf.readInt();
        this.pos = buf.readBlockPos();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(energy);
        buf.writeBlockPos(pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE CLIENT YES
            if(Minecraft.getInstance().level.getBlockEntity(pos) instanceof ElectricFurnaceBlockEntity blockEntity) {
                blockEntity.setEnergyLevel(energy);

                if(Minecraft.getInstance().player.containerMenu instanceof IEnergyMenu menu &&
                        menu.getBlockEntity().getBlockPos().equals(pos)) {
                    blockEntity.setEnergyLevel(energy);
                }
            }
        });
        return true;
    }
}