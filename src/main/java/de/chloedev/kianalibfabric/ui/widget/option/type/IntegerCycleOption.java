package de.chloedev.kianalibfabric.ui.widget.option.type;

import de.chloedev.kianalibfabric.ui.widget.option.CycleOption;
import de.chloedev.kianalibfabric.ui.widget.option.ValueHolder;
import net.minecraft.text.Text;

import java.util.function.Consumer;

/**
 * Provided for Convenience
 */
public class IntegerCycleOption extends CycleOption<Integer> {

    public IntegerCycleOption(Text text, ValueHolder<Integer> values, Consumer<Integer> changeCallback) {
        super(text, values, changeCallback);
    }
}
