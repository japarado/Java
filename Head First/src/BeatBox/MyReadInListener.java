/*
package BeatBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class MyReadInListener implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        boolean[] checkBoxState = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(new File("Checkbox.ser"));
            ObjectInputStream is = new ObjectInputStream(fileIn);
            checkBoxState = (boolean[]) is.readObject();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        for(int i=0;i<256;i++)
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
        sequencer.stop();
        buildTrackAndStart();
    }
}
*/
