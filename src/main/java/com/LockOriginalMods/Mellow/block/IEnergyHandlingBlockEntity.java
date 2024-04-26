package com.LockOriginalMods.Mellow.block;

import net.minecraftforge.energy.IEnergyStorage;

public interface IEnergyHandlingBlockEntity {
    void setEnergyLevel(int energyLevel);
    IEnergyStorage getEnergyStorage();
}