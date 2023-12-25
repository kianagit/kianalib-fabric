package de.chloedev.kianalibfabric.ui.widget.option.type;

import de.chloedev.kianalibfabric.ui.widget.option.CycleOption;
import de.chloedev.kianalibfabric.ui.widget.option.ValueHolder;
import net.minecraft.text.Text;

import java.util.function.Consumer;

/**
 * Provided for Convenience
 */
public class StringCycleOption extends CycleOption<String> {

    public StringCycleOption(Text text, ValueHolder<String> values, Consumer<String> changeCallback) {
        super(text, values, changeCallback);
    }
}
