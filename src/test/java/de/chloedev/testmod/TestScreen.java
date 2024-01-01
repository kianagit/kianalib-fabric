package de.chloedev.testmod;

import de.chloedev.kianalibfabric.ui.widget.option.OptionListWidget;
import de.chloedev.kianalibfabric.ui.widget.option.ValueHolder;
import de.chloedev.kianalibfabric.ui.widget.option.type.*;
import de.chloedev.kianalibfabric.util.ActionUtil;
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
        list.addSingleOptionEntry(new InfoTextOption(Text.literal("--- Custom Options ---")));
        list.addSingleOptionEntry(new StringCycleOption(Text.literal("String-Cycle-Option"), new ValueHolder<>("val0", "val1", "val2", "val3", "val4", "val5"), ActionUtil::doNothing));
        list.addSingleOptionEntry(new IntegerCycleOption(Text.literal("Int-Cycle-Option"), new ValueHolder<>(0, 1, 2), ActionUtil::doNothing));
        list.addSingleOptionEntry(new PlaceholderOption());
        list.addSingleOptionEntry(new ClickableOption(Text.literal("Clickable-Option"), ActionUtil::doNothing));
        list.addSingleOptionEntry(new BooleanCycleOption(Text.literal("Boolean-Option"), ActionUtil::doNothing));
        list.addOptionEntry(
                new BooleanCycleOption(Text.literal("Boolean-Option 1"), ActionUtil::doNothing),
                new BooleanCycleOption(Text.literal("Boolean-Option 2"), ActionUtil::doNothing)
        );
        this.addDrawableChild(list);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
    }
}
