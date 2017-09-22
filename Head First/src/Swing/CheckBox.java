package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBox
{
    JCheckBox cbox;
    JCheckBox botCbox;
    public static void main(String[] args)
    {
        CheckBox checkBox = new CheckBox();
        checkBox.run();
    }

    public void run()
    {
        JFrame frame = new JFrame("Checkbox Example");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        cbox = new JCheckBox("Click me!");
        cbox.addActionListener(new BoxListener());

        botCbox = new JCheckBox("No, click ME!");
        botCbox.addActionListener(new BotBoxListener());

        frame.getContentPane().add(BorderLayout.SOUTH,botCbox);
        frame.getContentPane().add(BorderLayout.NORTH,cbox);
        frame.setVisible(true);
    }

    class BoxListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String status = "off";
            if(cbox.isSelected())
            {
                status = "on";
                System.out.println(status);
            }
            else
            {
                status = "off";
                System.out.println(status);
            }
        }
    }
    class BotBoxListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(botCbox.isSelected()  && cbox.isSelected())
            {
                cbox.setSelected(false);
            }
        }
    }
}
