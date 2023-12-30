package de.chloedev.kianalibfabric.ui.widget.option;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.SimpleOption;
import org.jetbrains.annotations.Nullable;

public class OptionListWidget extends net.minecraft.client.gui.widget.OptionListWidget {

    private boolean withShadows;

    public OptionListWidget(int x, int y, int width, int height, int itemHeight) {
        super(MinecraftClient.getInstance(), 0, 0, 0, itemHeight);
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
        this.setRenderHeader(false, 0);
        this.setRenderBackground(false);
        this.withShadows = false;
    }

    public OptionListWidget withHeader(int height) {
        this.setRenderHeader(true, height);
        return this;
    }

    public OptionListWidget withBackground() {
        this.setRenderBackground(true);
        return this;
    }

    public OptionListWidget withShadows() {
        this.withShadows = true;
        return this;
    }

    @Override
    public int addSingleOptionEntry(SimpleOption<?> option) {
        return this.addEntry(new WidgetEntry(ImmutableMap.of(option, option.createWidget(this.client.options, OptionListWidget.this.getX() + 4, 0, OptionListWidget.this.width - 14))));
    }

    @Override
    public void addOptionEntry(SimpleOption<?> firstOption, @Nullable SimpleOption<?> secondOption) {
        throw new UnsupportedOperationException("Not Supported...");
    }

    @Override
    protected int getScrollbarPositionX() {
        return (this.getX() + this.width) - 6;
    }

    @Override
    public int getRowWidth() {
        return this.width;
    }
}