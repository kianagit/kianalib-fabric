package de.chloedev.kianalibfabric.ui.widget.option;

import com.mojang.serialization.Codec;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;

import java.util.function.Consumer;

public class Option<T> extends SimpleOption<T> {

    public Option(Text text, SimpleOption.Callbacks<T> callbacks, Codec<T> codec, T defaultValue, Consumer<T> changeCallback) {
        super(text.getString(), emptyTooltip(), (optionText, value) -> Text.empty(), callbacks, codec, defaultValue, changeCallback);
    }
}