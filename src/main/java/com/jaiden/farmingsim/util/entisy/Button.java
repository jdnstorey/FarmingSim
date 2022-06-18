package com.jaiden.farmingsim.util.entisy;

import com.jaiden.farmingsim.items.SeedType;
import net.minecraft.util.text.ITextComponent;

public class Button extends net.minecraft.client.gui.widget.button.Button {
    private final SeedType type;

    public Button(int posX, int posY, int width, int height, ITextComponent title, IPressable callable, SeedType type) {
        super(posX, posY, width, height, title, callable);
        this.type = type;
    }

    public SeedType getType() {
        return type;
    }
}
