import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculator {
    public static void main(String[] args) {
        JFrame f = new JFrame("AP-Calculator");
        f.setLayout(new FlowLayout(FlowLayout.LEFT));
        f.setSize(300, 250);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel ansJPanel = new JPanel();
        ansJPanel.setLayout(new GridLayout(2, 1));
        ansJPanel.setBounds(20, 50, 300, 42);
        JTextField entry = new JTextField(23);
        entry.setEditable(false);
        entry.setToolTipText("calculate");
        entry.setBounds(0, 0, 50, 15);
        ansJPanel.add(entry);
        JLabel st = new JLabel("STATUS:", JLabel.LEFT);
        JPanel operand = new JPanel(new GridLayout(5, 4, 4, 4));

        String op[] = {
                "1", "2", "3", "c", "4", "5", "6", "+", "7", "8", "9", "-", "0", "=", "/", "*", "AC", "OFF", ".",
        };

        JButton[] num = new JButton[19];
        for (int i = 0; i < 19; i++) {
            final int x = i;

            num[i] = new JButton(String.valueOf(op[i]));

            num[i].addActionListener(l -> {
                String c = String.valueOf(op[x]);
                if (c.equals("=")) {
                    entry.setText(calcu(entry.getText()));
                    st.setText(status(entry.getText()));
                } else if (c.equals("c") || c.equals("AC")) {
                    entry.setText("");
                    st.setText("Status : ");
                } else
                    entry.setText(entry.getText() + c);
            });
            operand.add(num[i]);

        }
        // JInternalFrame frame = new JInternalFrame("child frame", true, true, false, false);
        // frame.setSize(300, 250);
        
        // f.add(frame);
        // frame.setVisible(true);
        num[16].setBounds(15,23,40,45);
               System.out.println(num[16].getSize()); 

        ansJPanel.add(st);
        f.add(ansJPanel);

        f.add(operand);
        // JFrame demo = new JFrame("demo");
        // demo.setVisible(true);
        // demo.setSize(299, 200);
        // // demo.add(operand);
        // JDialog d = new JDialog(f);
        // d.setSize(299, 200);
        // d.setVisible(true);
        // //f.add(d);
        f.setVisible(true);

    }

    public static String calcu(String s) {


        return "Result";
    }

    static String status(String s) {
        if (calcu(s).equals("Error"))
            return "Something went wrong";
        else
            return "operation successful";

    }
}
