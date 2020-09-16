package swing;

import javax.swing.*;
import java.awt.*;

public class SwingObserverExample {

    JFrame frame;

    public static void main(String[] args) {
        SwingObserverExample obs = new SwingObserverExample();
        obs.go();
    }

    private void go() {
        frame = new JFrame();
        JButton button = new JButton("Should I do it?");
        button.addActionListener(e -> System.out.println("Don't do it"));
        button.addActionListener(e -> System.out.println("Come on, do it"));
        frame.getContentPane().add(BorderLayout.CENTER, button);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



}
