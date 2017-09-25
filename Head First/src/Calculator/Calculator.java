package Calculator;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Created by student on 9/25/2017.
 */
public class Calculator
{
    JTextArea compArea;
    JTextArea resultArea;

    JButton one;
    JButton two;
    JButton three;
    JButton four;
    JButton five;
    JButton six;
    JButton seven;
    JButton eight;
    JButton nine;
    JButton multiply;
    JButton divide;
    JButton subtract;
    JButton add;
    JButton clear;
    JButton equals;
    public static void main(String[] args)
    {
        Calculator calculator  = new Calculator();
        calculator.display();
    }
    public void display()
    {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(350,350);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        //topPanel components
            //compArea components
        compArea = new JTextArea();
        compArea.setColumns(20);
        compArea.setEditable(false);
        JScrollPane compScrollPane = new JScrollPane(compArea);
        compScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        compScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        topPanel.add(BorderLayout.NORTH,compArea);
            //compArea components
            //resultArea components
        resultArea = new JTextArea();
        JScrollPane resultScrollPane = new JScrollPane(resultArea);
        resultArea.setEditable(false);
        resultArea.setColumns(5);
        topPanel.add(BorderLayout.SOUTH,resultArea);
            //end resultAreaComponents
        topPanel.add(BorderLayout.NORTH, compArea);
        topPanel.add(BorderLayout.SOUTH,resultArea);
        //end topPanel components

        JPanel centerPanel = new JPanel();
        //centerPanel components
        HashMap<JButton,String> buttonStringHashMap = new HashMap<JButton,String>();



    }
}
