package de.chloedev.kianalibfabric.ui.widget.option;

import java.util.List;

/**
 * Holds Values, and makes it easy to cycle between them.
 *
 * @param <T>
 */
public class ValueHolder<T> {

    private final List<T> valuesOrdered;
    private int currentValueIndex;

    @SafeVarargs
    public ValueHolder(T... values) {
        this.valuesOrdered = List.of(values);
        this.currentValueIndex = 0;
    }

    public List<T> getValuesOrdered() {
        return valuesOrdered;
    }

    public T getCurrentValue() {
        return this.valuesOrdered.get(this.currentValueIndex);
    }

    public void setCurrentValue(int index) {
        this.currentValueIndex = index;
    }

    public void nextValue() {
        if (this.currentValueIndex == this.valuesOrdered.size() - 1) {
            this.currentValueIndex = 0;
            return;
        }
        this.currentValueIndex++;
    }

    public void prevValue() {
        if (this.currentValueIndex == 0) {
            this.currentValueIndex = this.valuesOrdered.size() - 1;
            return;
        }
        this.currentValueIndex--;
    }
}
