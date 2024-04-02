package gamejavaquiz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

class CustomBorder implements Border {

    private final int borderWidth;

    public CustomBorder(int borderWidth) {
        this.borderWidth = borderWidth;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < borderWidth; i++) {
            g.drawRect(x + i, y + i, width - 2 * i - 1, height - 2 * i - 1);
        }
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(borderWidth, borderWidth, borderWidth, borderWidth);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
