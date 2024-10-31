package bruteforce;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Gui extends JFrame {
    private volatile boolean isRunning = false;

    // Buttons
    JButton start;
    JButton close;

    // Textfield
    JTextField textField;

    public Gui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setResizable(false);

        start = new JButton("Start Cracking");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start.setEnabled(false);
                close.setEnabled(true);
                isRunning = true;

                // Start a separate thread for the task
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (isRunning) {
                            try {
                                BruteForce.hacking(textField.getText());
                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            System.out.println("Task is running...");

                            try {
                                Thread.sleep(1000); // Simulating some work
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });

        close = new JButton("break");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setEnabled(true);
                close.setEnabled(false);
                isRunning = false;
            }
        });

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 45));

        this.add(start);
        this.add(close);
        this.add(textField);
        this.pack();
        this.setVisible(true);
    }
}

class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Gui g = new Gui();
    }
}