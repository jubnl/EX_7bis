package testpanbis;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private boolean rectangle, ovale, triangle, reset;

    /**
     * Called when this.repaint() is called
     * @param g Graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        // call parent class
        super.paintComponent(g);

        // define drawing color
        g.setColor(Color.DARK_GRAY);

        // window center (width / 2 and height / 2)
        int xMiddle = this.getWidth() / 2;
        int yMiddle = this.getHeight() / 2;

        // only used below in comments to show where xMax and yMax is
        final int xMax = this.getWidth();
        final int yMax = this.getHeight();

        // if (rectangle == true) is the same as if (rectangle)
        if (rectangle) {
            final int x = xMiddle - (xMiddle / 2);
            final int y = yMiddle - (yMiddle / 2);
            final int width = xMiddle;
            final int height = yMiddle;
            // fillRect(x-pos, y-pos, width, height), draw a rectangle using graphics
            g.fillRect(x, y, width, height);

            // point xy = starting point

            //                                              xMiddle
            // ------------------------x--------------------------------------------------------------------------- xMax (positive)
            /** 0,0
             *
             *
             *
             *                                                width
             * y                       xy--------------------------------------------------
             *                        h|
             *                        e|
             * yMiddle                i|
             *                        g|
             *                        h|
             *                        t|
             *
             *
             *
             *
             *
             * yMax (positive)
             */

            return;
        }

        // fillOval(x-pos, y-pos, width, height)
        if (ovale) {
            final int x = xMiddle - (xMiddle / 2);
            final int y = yMiddle - (yMiddle / 2);
            final int width = xMiddle;
            final int height = yMiddle;

            g.fillOval(x, y, width, height);

            //                                              xMiddle
            // ------------------------x--------------------------------------------------------------------------- xMax (positive)
            /** 0,0
             *
             *
             *
             *                                                width
             * y                       xy--------------------------------------------------
             *                        h|
             *                        e|
             * yMiddle                i|
             *                        g|
             *                        h|
             *                        t|
             *
             *
             *
             *
             *
             * yMax (positive)
             */

            // and it will draw an oval in the area of the rectangle

            return;
        }

        if (triangle) {
            final int n = 3;
            int[] x = new int[n];
            int[] y = new int[n];

            //Coordonnées du triangle
            x[0] = xMiddle - (xMiddle / 2);
            x[1] = xMiddle;
            x[2] = xMiddle + (xMiddle / 2);
            y[0] = y[2] = yMiddle + (yMiddle / 2);
            y[1] = yMiddle - (yMiddle / 2);

            //                                    xMiddle
            // ------------------------x0-----------------------x1-----------------------x2------------------------ xMax (positive)
            /** 0,0
             *
             *
             *
             *
             * y1                                              x1/y1
             *
             *
             * yMiddle
             *
             *
             * y0/y2                  x0/y0                                              x2/y2
             *
             *
             *
             *
             * yMax (positive)
             */

            // then watch where x0 and y0 cross, same for x1/y1 and x2/y2

            // fillPolygon(int[] x-pos, int[] y-pos, int howManyPointsShouldTheMethodDraw)
            // draw triangle
            g.fillPolygon(x, y, n);
            return;
        }
        if (reset) g.setPaintMode();
    }

    public void setRectangle() {
        ovale = triangle = reset = false;
        rectangle = true;
    }

    public void setOvale() {
        rectangle = triangle = reset = false;
        ovale = true;
    }

    public void setTriangle() {
        rectangle = ovale = reset = false;
        triangle = true;
    }

    public void setReset() {
        rectangle = ovale = triangle = false;
        reset = true;
    }
}
