import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class jframe extends JFrame {
    jframe()
    {
        setVisible(true);
        setSize(400, 400);
        JPanel m = new JPanel();
        JMenuBar menu = new JMenuBar();
        
        JMenu a = new JMenu("option");
        menu.add(a);
         JMenu b = new JMenu("option");
        menu.add(b); JMenu c = new JMenu("option");
        menu.add(c); JMenu d = new JMenu("option");
        menu.add(d); JMenu f = new JMenu("option");
        menu.add(f); JMenu e = new JMenu("option");
        menu.add(e);
        m.add(menu);
        
        setJMenuBar(menu);
    }
public static void main(String[] args) {
    jframe m = new jframe();
}

}
