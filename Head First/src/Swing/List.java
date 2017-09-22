package Swing;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class List
{
    JList list;

    public static void main(String[] args)
    {
        List list = new List();
        list.go();
    }

    public void go()
    {
        JFrame frame = new JFrame("JList Example");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //JList
        String[] listEntries = {"alps","beta","gammma","delta","epsilon","zeta","eta",
                "theta"};
        list = new JList(listEntries);

        JScrollPane scroller = new JScrollPane(list);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JPanel panel = new JPanel();
        panel.add(scroller);

        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new ListHandler());

        frame.add(panel);
        frame.setVisible(true);
    }

    class ListHandler implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent lse)
        {
            if (!lse.getValueIsAdjusting())
            {
                String selection = (String) list.getSelectedValue();
                System.out.println(selection);
            }
        }
    }

}
