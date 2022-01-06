package testpanbis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    private final Panel panel;

    public Window() {

        // define window title, window size etc
        this.setTitle("TEST WINDOW");
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // generate a new panel
        // check the Panel class to see how it works
        panel = new Panel();
        panel.setBackground(Color.white);

        // get window container and add the panel to the window container
        Container content = getContentPane();
        content.add(panel, "Center");

        // define buttons (set text, position and subscribe to a listener bound to THIS class instance (see actionPerformed below)
        // Watch out, this class must implement ActionListener to work since we use that
        // declare buttons and a panel
        JButton btnRectangle = new JButton("RECTANGLE");
        JButton btnOval = new JButton("OVALE");
        JButton btnTriangle = new JButton("TRIANGLE");
        JButton btnReset = new JButton("RESET");

        content.add(btnRectangle, "North");
        content.add(btnOval, "East");
        content.add(btnTriangle, "West");
        content.add(btnReset, "South");

        btnRectangle.addActionListener(this);
        btnOval.addActionListener(this);
        btnTriangle.addActionListener(this);
        btnReset.addActionListener(this);
    }

    /**
     * Method that is called when a button is clicked if the button is subscribed to the callback (btn.addActionListener(this))
     *
     * @param e Action event (data from the component that called the callback)
     */
    public void actionPerformed(ActionEvent e) {
        panel.setNewForm(e.getActionCommand());
        panel.repaint();
    }
}