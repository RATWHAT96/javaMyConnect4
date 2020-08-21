import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class GUI {

    public GUI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));
        panel.setLayout(new GridLayout(0,1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Connect Four");
        frame.pack();
        frame.setVisible(true);
    }
}