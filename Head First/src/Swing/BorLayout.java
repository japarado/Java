package Swing;

import javax.swing.*;
import java.awt.*;

public class BorLayout
{
    public static void main(String[] args)
    {
        BorLayout gui = new BorLayout();
        gui.go();
    }
    public void go()
    {
        JFrame frame = new JFrame();
        JButton button = new JButton("Click Me like you mean it");
        frame.getContentPane().add(BorderLayout.EAST,button);
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}
