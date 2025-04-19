package indigo;

import indigo.screen.DashboardScreen;

import javax.swing.*;
import java.awt.*;

public class Main implements Runnable {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Main());
    }

    @Override
    public void run() {
//        JFrame loginFrame = new JFrame("Login Title");
//
//        loginFrame.setLocation(new Point(100, 100));
//        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//        JPanel mainPanel = new JPanel();
//        mainPanel.setLayout(new BorderLayout());
//        loginFrame.getContentPane().add(mainPanel);
//        mainPanel.add(new JButton("Button Text"), BorderLayout.CENTER);
//
//        loginFrame.pack();
//        loginFrame.setLocationByPlatform(true);
//        loginFrame.setVisible(true);

        JFrame dashboardScreen = new DashboardScreen();
        dashboardScreen.pack();
        dashboardScreen.setLocationByPlatform(true);
        dashboardScreen.setVisible(true);
    }

    public static void aaa(String[] args) {
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