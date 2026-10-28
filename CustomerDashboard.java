package customer;

import javax.swing.*;
import java.awt.*;

public class CustomerDashboard extends JFrame {

    private JButton homeButton;
    private JButton ordersButton;
    private JButton profileButton;
    private JButton logoutButton;

    public CustomerDashboard() {

        setTitle("FOODIE - Customer Dashboard");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ================= HEADER =================

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(45, 35, 30));
        header.setPreferredSize(new Dimension(1000, 75));

        JLabel logo = new JLabel("FOODIE");
        logo.setFont(new Font("Arial", Font.BOLD, 26));
        logo.setForeground(Color.WHITE);
        logo.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

        JPanel navigation = new JPanel(
                new FlowLayout(FlowLayout.RIGHT, 8, 18)
        );
        navigation.setBackground(new Color(45, 35, 30));

        homeButton = createButton("Home");
        ordersButton = createButton("My Orders");
        profileButton = createButton("Profile");
        logoutButton = createButton("Logout");

        navigation.add(homeButton);
        navigation.add(ordersButton);
        navigation.add(profileButton);
        navigation.add(logoutButton);

        header.add(logo, BorderLayout.WEST);
        header.add(navigation, BorderLayout.EAST);

        add(header, BorderLayout.NORTH);

        // ================= HOME CONTENT =================

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 248, 235));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(Box.createVerticalStrut(70));

        JLabel welcome = new JLabel("Welcome to FOODIE!");
        welcome.setFont(new Font("Arial", Font.BOLD, 34));
        welcome.setForeground(new Color(45, 35, 30));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(welcome);

        mainPanel.add(Box.createVerticalStrut(15));

        JLabel message = new JLabel(
                "Order your favourite food easily"
        );
        message.setFont(new Font("Arial", Font.PLAIN, 18));
        message.setForeground(new Color(100, 80, 65));
        message.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(message);

        mainPanel.add(Box.createVerticalStrut(50));

        JButton orderFoodButton = new JButton("ORDER FOOD");
        orderFoodButton.setFont(new Font("Arial", Font.BOLD, 18));
        orderFoodButton.setForeground(Color.WHITE);
        orderFoodButton.setBackground(new Color(230, 126, 34));
        orderFoodButton.setFocusPainted(false);
        orderFoodButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderFoodButton.setMaximumSize(new Dimension(250, 55));

        mainPanel.add(orderFoodButton);

        add(mainPanel, BorderLayout.CENTER);

        // ================= NAVIGATION ACTIONS =================

        // HOME
        homeButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "You are already on the Home page."
            );
        });

        // MY ORDERS
        ordersButton.addActionListener(e -> {
            dispose();

            try {
                new MyOrders().setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        null,
                        "Unable to open My Orders.\n\n"
                        + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

                new CustomerDashboard().setVisible(true);
            }
        });

        // PROFILE
        profileButton.addActionListener(e -> {
            dispose();

            try {
                new CustomerProfile().setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        null,
                        "Unable to open Profile.\n\n"
                        + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

                new CustomerDashboard().setVisible(true);
            }
        });

        // LOGOUT
        logoutButton.addActionListener(e -> {

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {

                dispose();

                new CustomerLogin().setVisible(true);
            }
        });

        // ORDER FOOD
        orderFoodButton.addActionListener(e -> {
            dispose();
            new FoodMenu().setVisible(true);
        });
    }

    // ================= BUTTON DESIGN =================

    private JButton createButton(String text) {

        JButton button = new JButton(text);

        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(230, 126, 34));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        return button;
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new CustomerDashboard().setVisible(true);
        });
    }
}

