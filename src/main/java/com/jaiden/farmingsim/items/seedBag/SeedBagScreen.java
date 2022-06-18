package com.jaiden.farmingsim.items.seedBag;

import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.items.SeedType;
import com.jaiden.farmingsim.util.entisy.Button;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SeedBagScreen extends ContainerScreen<SeedBagContainer> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(FarmingSim.MODID, "textures/item/seed_bag/gui.png");
    private SeedBagItem seedBag;

    public SeedBagScreen(SeedBagContainer container, PlayerInventory inv, ITextComponent title) {
        super(container, inv, title);
        seedBag = (SeedBagItem) inv.player.getMainHandItem().getItem();
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

        addButton("Wheat", 11, 11, SeedType.WHEAT);
        addButton("Sunflower", 35, 11, SeedType.SUNFLOWER);
        addButton("Soy", 59, 11, SeedType.SOY);
        addButton("Potato", 83, 11, SeedType.POTATO);
        addButton("Oat", 107, 11, SeedType.OAT);

        addButton("Cotton", 11, 35, SeedType.COTTON);
        addButton("Corn", 35, 35, SeedType.CORN);
        addButton("Carrot", 59, 35, SeedType.CARROT);
        addButton("Canola", 83, 35, SeedType.CANOLA);
        addButton("Barley", 107, 35, SeedType.BARLEY);
    }

    private void addButton(String title, int startX, int startY, SeedType type) {
        int x = (this.width - this.getXSize()) / 2;
        int y = (this.height - this.getYSize()) / 2;

        addButton(new Button(x + startX, y + startY, 18, 18, new StringTextComponent(title), this::doStuff, type));
    }

    private void doStuff(net.minecraft.client.gui.widget.button.Button button) {
        Button b = (Button) button;
        seedBag.setType(b.getType());
        System.out.println(seedBag.getType().getIdentifier());
    }
}
