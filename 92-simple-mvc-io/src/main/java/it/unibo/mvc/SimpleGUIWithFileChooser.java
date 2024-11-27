package it.unibo.mvc;

import java.util.List;

import java.io.File;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 3;

    private final Controller controller;
    private final JFrame frame = new JFrame();

    /**
     * Constructor that inizialize a simple GUI
     * @param null
     */
    public SimpleGUIWithFileChooser() {
        this.controller = new Controller();
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JTextField text = new JTextField();
        text.setEditable(false);
        final JButton browse = new JButton("Browse");
        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                final JFileChooser fileChooser = new JFileChooser();
                final int returnedVal = fileChooser.showSaveDialog(panel);
                if (returnedVal == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    controller.setCurrentFile(selectedFile);
                    try {
                        final List<String> lines = Files.readAllLines(controller.getCurrentFile().toPath());
                        final StringBuilder readedLines = new StringBuilder();
                        for(final String line: lines) {
                            readedLines.append(line);
                        }
                        text.setText(readedLines.toString());
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(frame, e, "Error on writing on File", JOptionPane.ERROR_MESSAGE);
                    }
                }             
            }
            
        });

        panel.add(text, BorderLayout.CENTER);
        panel.add(browse, BorderLayout.SOUTH);
        mainPanel.add(panel);
        frame.setContentPane(mainPanel);

    }

    private void setSizeScreen() {
        final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int sh = (int) dimension.getHeight();
        final int sw = (int) dimension.getWidth();
        this.frame.setSize(sh / PROPORTION, sw / PROPORTION);
    }

    public void display() {
        setSizeScreen();
        this.frame.setLocationByPlatform(true);
        this.frame.setVisible(true);
    }

    public static void main(String... args) {
        new SimpleGUIWithFileChooser().display();
    }


}
