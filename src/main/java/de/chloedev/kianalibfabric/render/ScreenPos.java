package de.chloedev.kianalibfabric.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;

public class ScreenPos {

    private float x;
    private float y;

    ScreenPos(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static ScreenPos relative(float relX, float relY) {
        return new ScreenPos(relX, relY);
    }

    public static ScreenPos absolute(float absX, float absY) {
        Window window = MinecraftClient.getInstance().getWindow();
        return new ScreenPos((100 * absX) / window.getScaledWidth(), (100 * absY) / window.getScaledHeight());
    }

    public int getX() {
        return (int) (MinecraftClient.getInstance().getWindow().getScaledWidth() / (100 / this.x));
    }

    public int getY() {
        return (int) (MinecraftClient.getInstance().getWindow().getScaledHeight() / (100 / this.y));
    }

    @Override
    public String toString() {
        return "x=" + this.x + ",y=" + this.y;
    }
}
