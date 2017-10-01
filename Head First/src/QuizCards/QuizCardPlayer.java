/*
package QuizCards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class QuizCardPlayer
{
    private JTextArea display;
    private JTextArea answer;private ArrayList<QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;

    public static void main(String[] args)
    {
        QuizCardPlayer reader = new QuizCardPlayer();
        reader.go();
    }

    public void go()
    {
        //build gui
        frame = new JFrame("Quiz Card Player");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif",Font.BOLD,24);

        display = new JTextArea(10,20);
        display.setFont(bigFont);

        display.setLineWrap(true);
        display.setEditable(false);

        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        nextButton = new JButton();
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load Card Set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        frame.setSize(640,500);
        frame.setVisible(true);
    }

    class NextCardListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ev)
        {
            //if this is a question, show the anser, otherwise, show the next question
            //set a flag for whether we're viewing a question or answer
            if(isShowAnswer)
            {
                //show the answer because they've seen the question
                display.setText("Next Card");
                isShowAnswer = false;
            }
            else
            {
                //there are no more cards!
                display.setText("That was the last card");
                nextButton.setEnabled(false);
            }
        }
    }
    class OpenMenuListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            //bring up a file dialog box
            //let the user navigate to and choose a card set to open
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }
    }
    private void loadFile(File file)
    {
        */
/*must build an arraylist of card, by reading them from a text file
        * called from the OpenMenuListener event handler, reads that file one line
        * at a time
        * and tells the makeCard method to make a new Card out of the line
        * (one line in the file holds both the question and the answer, separated
        * by a "/)*//*

        cardList = new ArrayList<QuizCard>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null)
            {
                makeCard(line);
            }
            reader.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        //now time to start by showing the first card
        showNextCard();
    }
    private void makeCard(String lineToParse)
    {
        */
/*called the loadFile method, takes a line from the text file
        * and parses into two pieces-question and answer-and creates a new QuizCard
        * and adds it to the ArrayList called CardList*//*

        String[] result = lineToParse.split("/");
        QuizCard card = new QuizCard(result[0],result[1]);
        cardList.add(card);
        System.out.println("made a card");
    }
    private void showNextCard()
    {
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(("Show Answer"));
        isShowAnswer = true;


    }
}
*/
