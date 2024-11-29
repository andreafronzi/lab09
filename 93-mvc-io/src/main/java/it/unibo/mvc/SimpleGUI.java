package it.unibo.mvc;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 3;

    private final Controller controller = new SimpleController();
    private final JFrame frame = new JFrame();

    /**
     * Constructor that simply crate an instance of the simple GUI
     */
    public SimpleGUI() {
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        final JTextArea output = new JTextArea();
        final JTextField input = new JTextField();
        final JButton print = new JButton("Print");
        final JButton showH = new JButton("Show History");
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println(controller.getLine());                
            }            
        });
        showH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   output.setText(controller.getHistoryLine().toString());
            }
        });
        mainPanel.add(input, BorderLayout.NORTH);
        mainPanel.add(output, BorderLayout.CENTER);
        panel.add(print);
        panel.add(showH);
        mainPanel.add(panel, BorderLayout.SOUTH);
        this.frame.setContentPane(mainPanel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
    }
    
    public void display() {
        final Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();  
        final int sh = (int) screenDimension.getHeight();
        final int sw = (int) screenDimension.getWidth();
        this.frame.setSize(sw / PROPORTION, sh / PROPORTION);
        this.frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI().display();
    }
}
