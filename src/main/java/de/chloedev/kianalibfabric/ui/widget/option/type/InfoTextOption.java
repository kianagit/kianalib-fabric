package de.chloedev.kianalibfabric.ui.widget.option.type;

import com.mojang.serialization.Codec;
import de.chloedev.kianalibfabric.ui.widget.option.Option;
import de.chloedev.kianalibfabric.util.ActionUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class InfoTextOption extends Option<Object> {

    public InfoTextOption(Text text) {
        this(text, new Callbacks<>() {
            public Function<SimpleOption<Object>, ClickableWidget> getWidgetCreator(TooltipFactory<Object> tooltipFactory, GameOptions gameOptions, int x, int y, int width, Consumer<Object> changeCallback) {
                return o -> new Widget(x, y, width, 20, text, ActionUtil::doNothing, textSupplier -> Text.empty());
            }

            public Optional<Object> validate(Object value) {
                return Optional.empty();
            }

            public Codec<Object> codec() {
                return null;
            }
        });
    }

    public InfoTextOption(Text text, Callbacks<Object> callbacks) {
        super(text, null, null, null, ActionUtil::doNothing);
        this.defaultValue = null;
        this.value = null;
        this.callbacks = callbacks;
    }

    @Deprecated
    public Object getValue() {
        return null;
    }

    @Deprecated
    public void setValue(Object value) {
    }

    public static class Widget extends ButtonWidget {
        public Widget(int x, int y, int width, int height, Text message, PressAction onPress, NarrationSupplier narrationSupplier) {
            super(x, y, width, height, message, onPress, narrationSupplier);
        }

        @Override
        protected void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
            this.drawMessage(context, MinecraftClient.getInstance().textRenderer, this.active ? 0xFFFFFF : 0xA0A0A0 | MathHelper.ceil(this.alpha * 255.0f) << 24);
        }

        @Override
        public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
            return false;
        }

        @Override
        public boolean mouseClicked(double mouseX, double mouseY, int button) {
            return false;
        }
    }
}