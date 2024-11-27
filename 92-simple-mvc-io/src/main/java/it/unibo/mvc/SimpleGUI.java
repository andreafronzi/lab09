package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final Boolean VISIBLE = true;
    private static final int PROPORTION = 5;

    private final Controller controller; 
    private final JFrame frame = new JFrame();

    public SimpleGUI() {
        this.controller = new Controller();
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextArea text = new JTextArea("Text Area");
        canvas.add(text, BorderLayout.CENTER);
        final JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                try {
                    controller.setFileContent(text.getText());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(frame, e, "error", JOptionPane.ERROR_MESSAGE);
                 }
            }
        });
        canvas.add(save, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.pack();
        this.frame.setVisible(VISIBLE);
    }


    public static void main(final String[] args) {
        new SimpleGUI().display();
    }

}
