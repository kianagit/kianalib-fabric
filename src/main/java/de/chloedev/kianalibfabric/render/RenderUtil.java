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

    public void drawText(ScreenPos pos, Text text) {
        this.context.getMatrices().push();
        this.context.drawTextWithShadow(MinecraftClient.getInstance().textRenderer, text, pos.getX(), pos.getY(), text.getStyle().getColor() != null ? text.getStyle().getColor().getRgb() : 0xFFFFFF);
        this.context.getMatrices().pop();
    }
}