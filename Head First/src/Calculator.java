import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by student on 9/21/2017.
 */
public class Calculator
{
    JTextArea compArea;
    JTextField resultArea;

    JButton zero;
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
    JButton add;
    JButton subtract;
    JButton equals;
    JButton clear;

    public JButton button;

    public static void main(String args[])
    {
        Calculator calculator = new Calculator();
        calculator.displayCalculator();
    }

    public void displayCalculator()
    {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //prepare the container panels
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        //the text area for the displaying the input
        compArea = new JTextArea();

        //prepare the buttons
        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        multiply = new JButton("*");
        divide = new JButton("/");
        add = new JButton("+");
        subtract = new JButton("-");
        equals = new JButton("=");
        clear = new JButton("AC");

        //end prepare buttons
        JButton[] buttonArr = {zero, one, two, three, four, five, six, seven, eight, nine, multiply, divide, add, subtract, equals, clear};

        for(int x = 0;x<buttonArr.length;x++)
        {
            buttonArr[x].addActionListener(new ButtonListener());
            centerPanel.add(buttonArr[x]);
        }


        //text area(comp area)
        compArea = new JTextArea();
        compArea.setEditable(false);
        compArea.setColumns(20);
        JScrollPane scroller = new JScrollPane(compArea);
        JPanel compPanel = new JPanel();
        compPanel.add(BorderLayout.NORTH, scroller);

        //text field(results area)
        resultArea = new JTextField();
        resultArea.setColumns(10);
        resultArea.setEditable(false);
        compPanel.add(BorderLayout.SOUTH,resultArea);

        topPanel.add(BorderLayout.CENTER, compPanel);


        frame.getContentPane().add(BorderLayout.CENTER,centerPanel);
        frame.getContentPane().add(BorderLayout.NORTH, topPanel);
        frame.setVisible(true);
    }

    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            JButton button =(JButton) event.getSource();
            String txt = button.getText();
            System.out.println(txt);
            switch (txt)
            {
                case "0":
                    compArea.append("0");
                case "1":
                    compArea.append("1");
                case "2":
                    compArea.append("2");
                case "3":
                    compArea.append("3");
                case "4":
                    compArea.append("4");
                case "5":
                    compArea.append("5");
                case "6":
                    compArea.append("6");
                case "7":
                    compArea.append("7");
                case "8":
                    compArea.append("8");
                case "9":
                    compArea.append("9");
                case "*":
                    compArea.append("*");
                case "/":
                    compArea.append("/");
                case "+":
                    compArea.append("+");
                case "-":
                    compArea.append("-");
                case "AC":
                    compArea.setText("");
            }
        }
    }
}
