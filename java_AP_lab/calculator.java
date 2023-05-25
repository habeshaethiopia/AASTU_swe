import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class calculator{
    public static void main(String[] args){
        JFrame f = new JFrame("AP-Calculator");
        
        f.setSize(400, 300);
        JPanel ansJPanel = new JPanel();
        ansJPanel.setBounds(20, 50,300, 42);
        JTextField entry = new JTextField(40);
        entry.setBounds(0,0,50, 15);
        ansJPanel.add(entry);
        JLabel st = new JLabel("STATUS:",JLabel.RIGHT);
        st.setBounds(0,0 , 0, 15);
        JPanel operand = new JPanel();

        JButton[] num = new JButton[19] ;
        for (int i = 0; i < 10; i++)
        {
            num[i] = new JButton(String.valueOf(i));
            operand.add(num[i]);

        }
        num[10] = new JButton("C");
        num[11] = new JButton("+");
        num[12] = new JButton("-");
        num[13] = new JButton("*");
        num[14] = new JButton(".");
        num[15] = new JButton("0ff");
        num[16] = new JButton("AC");
        for (int i = 10; i < 17; i++) {
            operand.add(num[i]);
        }
        
        ansJPanel.add(st);

        f.add(ansJPanel);
        f.add(operand);



        f.setVisible(true);
    }
}