import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.MenuKeyEvent;

import java.awt.*;
import java.awt.event.ActionListener;


public class calculator{
    public static void main(String[] args){
        JFrame f = new JFrame("AP-Calculator");
        JLabel main = new JLabel();
        f.setSize(400, 300);
        JPanel ansJPanel = new JPanel();
        ansJPanel.setBounds(20, 50,300, 42);
        JTextField entry = new JTextField(40);
        entry.setBounds(0,0,50, 15);
        ansJPanel.add(entry);
        JLabel st = new JLabel("STATUS:",JLabel.RIGHT);
        st.setBounds(0,0 , 0, 15);
        JPanel operand = new JPanel(new GridLayout(5,4,3,3));
        
        
        String op []= {
            "1","2","3","c","4","5","6","+","7","8","9","-","0","=","/","*","AC","OFF",".",
        };

        JButton[] num = new JButton[19];
        
        for (int i = 0; i < 19; i++)
        {
            num[i] = new JButton(String.valueOf(op[i]));
           
            
            operand.add(num[i]);

        }
        
        
        ansJPanel.add(st);

        main.add(ansJPanel);
        main.add(operand);


        f.add(main);
        f.setVisible(true);
    }
}