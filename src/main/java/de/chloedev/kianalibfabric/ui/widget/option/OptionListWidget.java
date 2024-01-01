package de.chloedev.kianalibfabric.ui.widget.option;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.option.SimpleOption;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

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
        return this.addEntry(new WidgetEntry(ImmutableMap.of(option, option.createWidget(this.client.options, this.getX() + 4, 0, this.getWidth() - 14))));
    }

    @Override
    public void addOptionEntry(SimpleOption<?> option, @Nullable SimpleOption<?> option1) {
        Map<SimpleOption<?>, ClickableWidget> map = new HashMap<>();
        map.put(option, option.createWidget(this.client.options, this.getX() + 4, 0, ((this.getWidth() - 14) / 2) - 4));
        if (option1 != null) {
            map.put(option1, option1.createWidget(this.client.options, this.getX() + ((this.getWidth() - 14) / 2) + 8, 0, ((this.getWidth() - 14) / 2) - 4));
        }
        this.addEntry(new WidgetEntry(map));
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