package com.jaiden.farmingsim.items.seedBag;

import com.jaiden.farmingsim.FarmingSim;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
public class SeedBagScreen extends ContainerScreen<SeedBagContainer> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(FarmingSim.MODID, "textures/item/seed_bag/gui.png");
    @SuppressWarnings("unused")
    private final SeedBagContainer container;

    public SeedBagScreen(SeedBagContainer container, PlayerInventory inv, ITextComponent title) {
        super(container, inv, title);
        this.container = container;
        leftPos = 0;
        topPos = 0;
        width = 136;
        height = 64;
        imageWidth = 136;
        imageHeight = 64;
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);

        assert minecraft != null;
        minecraft.getTextureManager().bind(TEXTURE);

        int x = (this.width - this.getXSize()) / 2;
        int y = (this.height - this.getYSize()) / 2;

        this.blit(matrixStack, x, y, 0, 0, getXSize(), getYSize());
    }
}
