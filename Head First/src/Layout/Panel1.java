package Layout;

import javax.swing.*;
import java.awt.*;

public class Panel1
{
    public static void main(String[] args)
    {
        Panel1 gui = new Panel1();
        gui.go();
    }
    public void go()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(250,200);

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        frame.getContentPane().add(BorderLayout.EAST, panel);

        JButton button = new JButton("Shock Me");
        JButton buttonTwo = new JButton("bliss");
        //JButton buttonThree = new JButton("huh?");
        panel.add(button);
        panel.add(buttonTwo);
        //panel.add(buttonThree);

        frame.setVisible(true);
    }
}
