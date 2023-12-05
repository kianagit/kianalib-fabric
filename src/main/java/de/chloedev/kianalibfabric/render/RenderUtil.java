package de.chloedev.kianalibfabric.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class RenderUtil {

    public static RenderUtil INSTANCE = new RenderUtil();
    private final DrawContext context;

    public RenderUtil() {
        this.context = new DrawContext(MinecraftClient.getInstance(), MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers());
    }

    public void drawText(int x, int y, Text text, int color, float scale) {
        this.context.getMatrices().push();
        this.context.getMatrices().scale(scale, scale, scale);
        this.context.getMatrices().translate(-(x / scale), -(y / scale), -1.0f);
        this.context.drawTextWithShadow(MinecraftClient.getInstance().textRenderer, text, x, y, color);
        this.context.getMatrices().scale(-scale, -scale, -scale);
        this.context.getMatrices().translate(1.0f, 1.0f, 1.0f);
        this.context.getMatrices().pop();
    }
}