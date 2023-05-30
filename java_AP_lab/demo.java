import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class demo {
    public static void main(String[] args) {
        JFrame demo = new JFrame("demo");
        demo.setVisible(true);
        demo.setSize(400, 400);

        JPanel pnl = new JPanel();
        demo.add(pnl);
        // Allocate a new Layout object. The Panel container sets to this layout.
        pnl.setLayout(new BorderLayout());
        // The Panel container adds components in the proper order.
        pnl.add(new JLabel("One"));
        pnl.add(new JLabel("Two"));
        pnl.add(new JLabel("Three"));
        System.out.println(pnl.getLayout());
    }
}
