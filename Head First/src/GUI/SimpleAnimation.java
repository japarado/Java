package GUI;

import javax.swing.*;

public class SimpleAnimation
{
    int x = 70;
    int y = 70;

    public static void main(String[] args)
    {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }
    public void go()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();
    }
}