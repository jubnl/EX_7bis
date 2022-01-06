package testpanbis;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private String formName = "";


    private void makeRectOval(Graphics g, int xMiddle, int yMiddle, boolean oval) {
        final int x = xMiddle - (xMiddle / 2);
        final int y = yMiddle - (yMiddle / 2);
        if (oval) {
            g.fillOval(x, y, xMiddle, yMiddle);
            return;
        }
        g.fillRect(x, y, xMiddle, yMiddle);
    }

    private void makeTriangle(Graphics g, int xMiddle, int yMiddle) {
        final int n = 3;
        int[] x = new int[]{xMiddle - (xMiddle / 2), xMiddle, xMiddle + (xMiddle / 2)};
        int[] y = new int[n];

        y[0] = y[2] = yMiddle + (yMiddle / 2);
        y[1] = yMiddle - (yMiddle / 2);
        g.fillPolygon(x, y, n);
    }

    protected void setNewForm(String form) {
        this.formName = form;
    }

    /**
     * Called when this.repaint() is called
     *
     * @param g Graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        // call parent
        super.paintComponent(g);

        // define drawing color
        g.setColor(Color.DARK_GRAY);

        // window center (width / 2 and height / 2)
        int xMiddle = this.getWidth() / 2;
        int yMiddle = this.getHeight() / 2;

        switch (this.formName) {
            case "RECTANGLE" -> makeRectOval(g, xMiddle, yMiddle, false);
            case "OVALE" -> makeRectOval(g, xMiddle, yMiddle, true);
            case "TRIANGLE" -> makeTriangle(g, xMiddle, yMiddle);
            default -> g.setPaintMode();
        }
    }
}
