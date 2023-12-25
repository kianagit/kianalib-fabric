package de.chloedev.kianalibfabric.ui.widget.option.type;

import com.mojang.serialization.Codec;
import de.chloedev.kianalibfabric.ui.widget.option.Option;
import de.chloedev.kianalibfabric.util.ActionUtil;
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
 * Acts as a placeholder, that can for example be used to keep space between options.
 */
public class PlaceholderOption extends Option<Object> {

    public PlaceholderOption() {
        super(Text.empty(), null, null, null, ActionUtil::doNothing);
        this.defaultValue = null;
        this.value = null;
        this.callbacks = new Callbacks<>() {
            @Override
            public Function<SimpleOption<Object>, ClickableWidget> getWidgetCreator(TooltipFactory<Object> tooltipFactory, GameOptions gameOptions, int x, int y, int width, Consumer<Object> changeCallback) {
                return o -> {
                    ButtonWidget b = ButtonWidget.builder(Text.empty(), ActionUtil::doNothing).dimensions(x, y, width, 20).build();
                    b.visible = false;
                    //b.active = false;
                    return b;
                };
            }

            @Override
            public Optional<Object> validate(Object value) {
                return Optional.empty();
            }

            @Override
            public Codec<Object> codec() {
                return null;
            }
        };
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
