package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupForm
{
    JTextField usernameTf;
    JTextField passwordTf;
    JTextField passwordConfTf;
    JTextField emailTf;
    public static void main(String[] args)
    {
        SignupForm gui = new SignupForm();
        gui.go();
    }
    public void go()
    {
        JFrame frame = new JFrame("Sign up ");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Initialize main container panel
        JPanel mainPanel = new JPanel();

        //Create a new JPanel for each line. This is because each added component
        //to a box layout entails a new line
        JPanel usernamePnl = new JPanel();
        JPanel emailPnl = new JPanel();
        JPanel passwordPnl = new JPanel();
        JPanel passwordConfPnl = new JPanel();
        JPanel buttonsPnl = new JPanel();

        //Initialize Labels
        JLabel usernameLbl = new JLabel("Username");
        JLabel emailLbl = new JLabel("Email");
        JLabel passwordLbl = new JLabel("Password");
        JLabel passwordConfLbl = new JLabel("Confirm Password");

        //Initialize the Buttons
        JButton submitBtn = new JButton("Submit");
        JButton clearBtn = new JButton("Clear");

        //add action listeners for each button
        submitBtn.addActionListener(new SubmitBtnListener());
        clearBtn.addActionListener(new ClearBtnListener());

        //Initialize text fields
        usernameTf = new JTextField();
        passwordTf = new JTextField();
        passwordConfTf = new JTextField();
        emailTf = new JTextField();

        //add the text fields and labels to their appropriate panels
        usernamePnl.add(usernameLbl);
        usernamePnl.add(usernameTf);

        emailPnl.add(emailLbl);
        emailPnl.add(emailTf);

        passwordPnl.add(passwordLbl);
        passwordPnl.add(passwordTf);

        passwordConfPnl.add(passwordConfLbl);
        passwordConfPnl.add(passwordConfTf);


        //add a layout manager to the JPanel mainPanel
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.add(usernamePnl);
        mainPanel.add(emailPnl);
        mainPanel.add(passwordPnl);
        mainPanel.add(passwordConfPnl);


        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        frame.setVisible(true);

    }

    class SubmitBtnListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {

        }
    }
    class ClearBtnListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {

        }
    }
}
