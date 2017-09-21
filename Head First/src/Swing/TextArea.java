package Swing;

import javax.swing.*;

public class TextArea
{
    public static void main(String[] args)
    {
        TextArea textArea = new TextArea();
        textArea.go();
    }
    public void go()
    {
        JFrame frame = new JFrame("Sign up ");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JTextArea text = new JTextArea(10,20);
        JScrollPane scroller = new JScrollPane(text);
        text.setLineWrap(true);

        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scroller);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
