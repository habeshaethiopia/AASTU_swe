import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TraffisocketghtSimulation extends JFrame {

    private JPanel traffisocketghtPanel;
    private JButton redLight, yellowLight, greenLight;
    private JButton startButton, stopButton;
    private TraffisocketghtThread traffisocketghtThread;

    public TraffisocketghtSimulation() {
        setTitle("Traffic Light Simulation");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        traffisocketghtPanel = new JPanel();
        traffisocketghtPanel.setLayout(new GridLayout(4, 1));

        redLight = createLightButton(Color.RED);
        yellowLight = createLightButton(Color.YELLOW);
        greenLight = createLightButton(Color.GREEN);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (traffisocketghtThread == null || !traffisocketghtThread.isAlive()) {
                    traffisocketghtThread = new TraffisocketghtThread();
                    traffisocketghtThread.start();
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (traffisocketghtThread != null) {
                    traffisocketghtThread.stopSimulation();
                }
            }
        });

        traffisocketghtPanel.add(redLight);
        traffisocketghtPanel.add(yellowLight);
        traffisocketghtPanel.add(greenLight);
        traffisocketghtPanel.add(startButton);
        traffisocketghtPanel.add(stopButton);

        add(traffisocketghtPanel);
    }

    private JButton createLightButton(Color color) {
        JButton lightButton = new JButton();
        lightButton.setBackground(color);
        lightButton.setEnabled(false);
        return lightButton;
    }

    public static void main(String[] args) {
        TraffisocketghtSimulation simulation = new TraffisocketghtSimulation();
        simulation.setVisible(true);
    }

    class TraffisocketghtThread extends Thread {
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                try {
                    setLight(redLight, true);
                    setLight(yellowLight, false);
                    setLight(greenLight, false);
                    Thread.sleep(30000);

                    setLight(redLight, false);
                    setLight(yellowLight, true);
                    setLight(greenLight, false);
                    Thread.sleep(5000);

                    setLight(redLight, false);
                    setLight(yellowLight, false);
                    setLight(greenLight, true);
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void stopSimulation() {
            running = false;
        }

        private void setLight(JButton light, boolean state) {
            SwingUtilities.invokeLater(() -> light.setEnabled(state));
        }
    }
}
