import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class exercise extends JPanel {
    JButton button1, button2, button3, button4, button5;

    // Constructor
    public exercise() {
        super.setLayout(new GridBagLayout()); // super JPanel
        GridBagConstraints gbc = new GridBagConstraints();
        //
        // The following constraints are applicable to all components
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Define constraints for individual components
        button1 = new JButton("B1");
        gbc.gridx = 0; // column 0 (first column)
        gbc.gridy = 0; // row 0 (first row)
        gbc.weightx = 0.5; // weight for distributing extra x-spaces
        super.add(button1, gbc); // add and apply constraints
        //
        button2 = new JButton("B2");
        gbc.gridx = 1; // column 1
        gbc.gridy = 0; // row 0
       // gbc.weightx = 1.0;
        super.add(button2, gbc);
        //
        button3 = new JButton("B3");
        gbc.gridx = 2; // column 2
        gbc.gridy = 0; // row 0
        //gbc.weightx = 0.5;
        super.add(button3, gbc);
        //
        button4 = new JButton("Long-Named Button 4");
        gbc.gridx = 0; // column 0
        gbc.gridy = 1; // row 1 (second row)
        gbc.gridwidth = 3; // span 3 columns
        gbc.ipady = 40;
        // internal padding-y
        super.add(button4, gbc);
        button5 = new JButton("5");
        gbc.gridx = 1;
        // second column
        gbc.gridy = 2;
        // third row
        gbc.gridwidth = 2; // span 2 columns
        gbc.ipady = 0;
        // reset to default
        gbc.anchor = GridBagConstraints.PAGE_END; // align at bottom of space
        gbc.insets = new Insets(10, 0, 0, 0);
        // top margin
       // gbc.weighty = 1.0; // request any extra vertical space
        super.add(button5, gbc);
        //
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("GridBagLayoutDemo");
                frame.setContentPane(new exercise());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 300);
                frame.setVisible(true);
            }
        });
    }
}
