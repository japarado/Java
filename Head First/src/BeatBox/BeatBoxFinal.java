package BeatBox;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.*;

public class BeatBoxFinal
{
    JFrame theFrame;
    JPanel mainPanel;
    JList incomingList;
    JTextField userMessage;
    ArrayList<JCheckBox> checkBoxList;
    int nextNum;
    Vector<String> listVector = new Vector<>();
    String userName;
    ObjectOutputStream out;
    ObjectInputStream in;
    HashMap<String, boolean[]> otherSeqsMap = new HashMap<String,boolean[]>();

    Sequencer sequencer;
    Sequence sequence;
    Sequence mySequence = null;
    Track track;

    String[] instrumentNames =
            {
            "Bass drum","Closed Hi-Hat","Open Hi-Hat","Acoustic Snare","Crash Cymbal",
            "Hand Clap","High Tom","Hi Bongo","Maracas","Whistle","Low Conga","Cowbell",
            "Vibraslap","Low-mid tom","High Agogo","Open High Conga"
            };
    int[] instruments =
            {
                    35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63
            };

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name here");
        String name = scan.nextLine();
        new BeatBoxFinal().startUp(name);
    }
    public void startUp(String name)
    {
        userName = name;
        try
        {
            Socket sock = new Socket("127.0.0.1",4242);
            out = new ObjectOutputStream(sock.getOutputStream());
            in = new ObjectInputStream(sock.getInputStream());
            Runnable remoteReader = new RemoteReader();
            Thread remote = new Thread(remoteReader);
        }
        catch (Exception ex)
        {
            System.out.println("couldn't connect, - you'll have to play alone");
        }
        setUpMidi();
        buildGUI();
    }
    public void buildGUI()
    {
        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkBoxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        JButton sendIt = new JButton("Send It");
        sendIt.addActionListener(new MySendListener());
        buttonBox.add(sendIt);

        userMessage = new JTextField();
        buttonBox.add(userMessage);

        incomingList = new JList();
        incomingList.addListSelectionListener(new MyListSelectionListener());
        incomingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane theList = new JScrollPane(incomingList);
        buttonBox.add(theList);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++)
        {
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST,buttonBox);
        background.add(BorderLayout.WEST,nameBox);

        theFrame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16,16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER,mainPanel);

        for(int i=0;i<256;i++)
        {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkBoxList.add(c);
            mainPanel.add(c);

            theFrame.setBounds(50,50,300,300);
            theFrame.pack();
            theFrame.setVisible(true);
        }
    }
    public void setUpMidi()
    {
        try
        {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ,4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void buildTrackAndStart()
    {
        ArrayList<Integer> trackList = null;
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for(int i=0;i<16;i++)
        {
            trackList = new ArrayList<Integer>();

            for(int j=0;j<16;j++)
            {
                JCheckBox jc = (JCheckBox) checkBoxList.get(j+(16*i));
                if(jc.isSelected())
                {
                    int key = instruments[i];
                    trackList.add(new Integer(key));
                }
                else
                {
                    trackList.add(null);
                }
            }
            makeTracks(trackList);
        }
        track.add(makeEvent(192,9,1,0,15));
        try
        {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public class MyStartListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            buildTrackAndStart();
        }
    }
    public class MyStopListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            sequencer.stop();
        }
    }
    public class MyUpTempoListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor * 1.03));
            buildTrackAndStart();
        }
    }
    public class MyDownTempoListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor * 1.03));
        }
    }
    public class MySendListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            boolean[] checkBoxState = new boolean[256];
            for(int i=0;i<256;i++)
            {
                JCheckBox check = (JCheckBox) checkBoxList.get(i);
                if(check.isSelected())
                {
                    checkBoxState[i] = true;
                }
            }
            String messageToSend = null;
            try
            {
                out.writeObject(userName + nextNum++ + ": " + userMessage.getText());
                out.writeObject(checkBoxState);
            }
            catch (Exception ex)
            {
                System.out.println("Sorry dude, could not send it to the server");
            }
            userMessage.setText("");
        }
    }
    public class MyListSelectionListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent le)
        {
            if(!le.getValueIsAdjusting())
            {
                String selected = (String) incomingList.getSelectedValue();
                if(selected != null)
                {
                    boolean[] selectedState = (boolean[]) otherSeqsMap.get(selected);
                    changeSequence(selectedState);
                    sequencer.stop();
                    buildTrackAndStart();
                }
            }
        }
    }
    public class RemoteReader implements Runnable
    {
        boolean[] checkBoxState = null;
        String nameToShow = null;
        Object obj = null;

        public void run()
        {
            try
            {
                while( (obj=in.readObject()) != null)
                {
                    System.out.println("got an object from a server");
                    System.out.println(obj.getClass());
                    String nameToShow = (String) obj;
                    checkBoxState = (boolean[]) in.readObject();
                    otherSeqsMap.put(nameToShow, checkBoxState);
                    listVector.add(nameToShow);
                    incomingList.setListData(listVector);
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    public class MyPlayMineListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            if(mySequence != null)
            {
                sequence = mySequence;
            }
        }
    }
    public void changeSequence(boolean[] checkBoxState)
    {
        for (int i = 0; i <256 ; i++)
        {
            JCheckBox check = (JCheckBox) checkBoxList.get(i);
            if(checkBoxState[i])
            {
                check.setSelected(true);
            }
            else
            {
                check.setSelected(false);
            }
        }
    }
    public void makeTracks(ArrayList list)
    {
        Iterator it = list.iterator();
        for(int i=0;i<16;i++)
        {
            Integer num = (Integer) it.next();
            if(num != null)
            {
                int numKey = num.intValue();
                track.add(makeEvent(144,9,numKey,100,i));
                track.add(makeEvent(128,9,numKey,100,i+1));
            }
        }
    }
    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick)
    {
        MidiEvent event = null;
        try
        {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd,chan,one,two);
            event = new MidiEvent(a,tick);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return event;
    }
}
