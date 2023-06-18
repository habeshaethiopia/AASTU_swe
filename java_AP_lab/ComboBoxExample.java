import javax.swing.*;
import java.awt.*;

public class ComboBoxExample extends JFrame {
    private JComboBox<String> comboBox;
    private JLabel label;

    public ComboBoxExample() {
        setTitle("JComboBox Example");
        setLayout(new FlowLayout());

        // Create JComboBox
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        comboBox = new JComboBox<>(items);
        comboBox.setSelectedIndex(0);  // Set the default selected item

        // Create JLabel to display the selected item
        label = new JLabel("Selected Item: " + items[0]);

        // Add event listener to the JComboBox
        comboBox.addActionListener(e -> {
            String selectedItem = (String) comboBox.getSelectedItem();
            label.setText("Selected Item: " + selectedItem);
        });

        // Add components to the JFrame
        add(comboBox);
        add(label);

        // Set JFrame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);  // Center the JFrame on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        new ComboBoxExample();
    }
}