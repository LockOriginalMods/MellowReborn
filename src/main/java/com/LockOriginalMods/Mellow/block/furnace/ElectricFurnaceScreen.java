package com.LockOriginalMods.Mellow.block.furnace;

import com.LockOriginalMods.Mellow.data.renderer.EnergyInfoArea;
import com.LockOriginalMods.Mellow.utils.MouseUtil;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.Optional;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class ElectricFurnaceScreen extends AbstractContainerScreen<ElectricFurnaceMenu> {
    private EnergyInfoArea energyInfoArea;

    private static final Component TITLE =
            Component.translatable("gui." + MOD_ID + ".electric_furnace_gui");
    private static final ResourceLocation GUI = new ResourceLocation(MOD_ID, "textures/gui/electric_furnace_gui.png");

    public ElectricFurnaceScreen(ElectricFurnaceMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);


    }




    @Override
    protected void init() {
        super.init();
        assignEnergyInfoArea();
    }

    private void assignEnergyInfoArea() {
        energyInfoArea = new EnergyInfoArea(((width - imageWidth) / 2) +  156,
                ((height - imageHeight) / 2) + 13, menu.blockEntity.getEnergyStorage());
    }
    @Override
    protected void renderBg(GuiGraphics graphics, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.blit(GUI, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(graphics, x, y);
        energyInfoArea.draw(graphics);
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        renderEnergyAreaTooltips(graphics, pMouseX, pMouseY, x, y);
    }

    private void renderEnergyAreaTooltips(GuiGraphics graphics, int pMouseX, int pMouseY, int x, int y) {
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, 156, 13, 8, 64)) {
            graphics.renderTooltip(this.font, Component.literal(menu.blockEntity.getEnergyStorage() + " RF"), pMouseX, pMouseY);
        }
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting())
            guiGraphics.blit(GUI, x + 105, y + 33, 176, 0, 8, menu.getScaledProgress());
    }



    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, delta);
        renderTooltip(graphics, mouseX, mouseY);
    }
    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, int width, int height) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, width, height);
    }

}

