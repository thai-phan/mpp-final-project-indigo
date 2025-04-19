package indigo;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
    public static void main(String[] args) {
        // Create the main window
        JFrame frame = new JFrame("Hello, World!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a label with the text
        JLabel label = new JLabel("Hello, World!", JLabel.CENTER);
        frame.getContentPane().add(label);

        // Make the window visible
        frame.setVisible(true);
    }
}