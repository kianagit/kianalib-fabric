package de.chloedev.kianalibfabric.ui.widget.option.type;

import de.chloedev.kianalibfabric.ui.widget.option.CycleOption;
import de.chloedev.kianalibfabric.ui.widget.option.ValueHolder;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Provided for Convenience
 */
public class BooleanCycleOption extends CycleOption<Boolean> {

    public BooleanCycleOption(Text text, Consumer<Boolean> changeCallback) {
        this(text, new ValueHolder<>(true, false), changeCallback);
    }

    protected BooleanCycleOption(Text text, ValueHolder<Boolean> values, Consumer<Boolean> changeCallback) {
        super(text, values, new PotentialValuesBasedCallbacks<>(values.getValuesOrdered(), null) {
            @Override
            public Function<SimpleOption<Boolean>, ClickableWidget> getWidgetCreator(TooltipFactory<Boolean> tooltipFactory, GameOptions gameOptions, int x, int y, int width, Consumer<Boolean> changeCallback) {
                return o -> ButtonWidget.builder(text.copy().append(": " + (o.getValue() ? "On" : "Off")), button -> {
                    values.nextValue();
                    o.setValue(values.getCurrentValue());
                    button.setMessage(text.copy().append(": " + (o.getValue() ? "On" : "Off")));
                    changeCallback.accept(o.getValue());
                }).dimensions(x, y, width, 20).build();
            }

            @Override
            public Optional<Boolean> validate(Boolean value) {
                return Optional.of(value);
            }
        }, changeCallback);
    }
}
