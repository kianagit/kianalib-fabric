package de.chloedev.kianalibfabric.ui.widget.option.type;

import com.mojang.serialization.Codec;
import de.chloedev.kianalibfabric.ui.widget.option.Option;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Just for Convenience - The value is just a dummy, it isn't being used. Use this Class for adding Buttons to Lists.
 */
public class ClickableOption extends Option<Object> {

    public ClickableOption(Text text, ClickAction clickAction) {
        this(text, new Callbacks<>() {
            @Override
            public Function<SimpleOption<Object>, ClickableWidget> getWidgetCreator(TooltipFactory<Object> tooltipFactory, GameOptions gameOptions, int x, int y, int width, Consumer<Object> changeCallback) {
                return o -> ButtonWidget.builder(text, button -> clickAction.onClick()).dimensions(x, y, width, 20).build();
            }

            @Override
            public Optional<Object> validate(Object value) {
                return Optional.empty();
            }

            @Override
            public Codec<Object> codec() {
                return null;
            }
        }, clickAction);
    }

    public ClickableOption(Text text, Callbacks<Object> callbacks, ClickAction changeCallback) {
        super(text, null, null, null, dummy -> changeCallback.onClick());
        this.defaultValue = null;
        this.value = null;
        this.callbacks = callbacks;
    }

    public interface ClickAction {
        void onClick();
    }

    @Deprecated
    @Override
    public Object getValue() {
        return null;
    }

    @Deprecated
    @Override
    public void setValue(Object value) {
    }
}
