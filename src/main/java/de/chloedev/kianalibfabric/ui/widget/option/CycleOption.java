package de.chloedev.kianalibfabric.ui.widget.option;

import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class CycleOption<T> extends Option<T> {

    public CycleOption(Text text, ValueHolder<T> values, Consumer<T> changeCallback) {
        this(text, values, new PotentialValuesBasedCallbacks<>(values.getValuesOrdered(), null) {
            @Override
            public Function<SimpleOption<T>, ClickableWidget> getWidgetCreator(TooltipFactory<T> tooltipFactory, GameOptions gameOptions, int x, int y, int width, Consumer<T> changeCallback) {
                return o -> ButtonWidget.builder(text.copy().append(": " + o.getValue().toString()), button -> {
                    values.nextValue();
                    o.setValue(values.getCurrentValue());
                    button.setMessage(text.copy().append(": " + o.getValue().toString()));
                    changeCallback.accept(o.getValue());
                }).dimensions(x, y, width, 20).build();
            }

            @Override
            public Optional<T> validate(T value) {
                return Optional.of(value);
            }
        }, changeCallback);
    }

    public CycleOption(Text text, ValueHolder<T> values, Callbacks<T> callbacks, Consumer<T> changeCallback) {
        super(text, null, null, null, changeCallback);
        this.defaultValue = values.getCurrentValue();
        this.value = this.defaultValue;
        this.callbacks = callbacks;
    }
}
