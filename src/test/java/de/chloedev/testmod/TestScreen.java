package de.chloedev.testmod;

import de.chloedev.kianalibfabric.ui.widget.option.OptionListWidget;
import de.chloedev.kianalibfabric.ui.widget.option.ValueHolder;
import de.chloedev.kianalibfabric.ui.widget.option.type.*;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class TestScreen extends Screen {

    public TestScreen() {
        super(Text.empty());
    }

    @Override
    protected void init() {
        OptionListWidget list = new OptionListWidget(0, 0, this.width, this.height, 24);
        list.addSingleOptionEntry(new StringCycleOption(Text.literal("String-Cycle-Option"), new ValueHolder<>("val0", "val1", "val2", "val3", "val4", "val5"), System.out::println));
        list.addSingleOptionEntry(new IntegerCycleOption(Text.literal("Int-Cycle-Option"), new ValueHolder<>(0, 1, 2), System.out::println));
        list.addSingleOptionEntry(new PlaceholderOption());
        list.addSingleOptionEntry(new ClickableOption(Text.literal("Clickable-Option"), () -> System.out.println("CLICKED!")));
        list.addSingleOptionEntry(new BooleanCycleOption(Text.literal("Boolean-Option"), System.out::println));
        this.addDrawableChild(list);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
    }
}
