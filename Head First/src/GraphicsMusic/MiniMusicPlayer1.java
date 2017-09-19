package GraphicsMusic;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;

public class MiniMusicPlayer1
{
    public static void main(String[] args)
    {
        try
        {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for (int i = 5; i < 61; i += 4)
            {
                track.add(makeEvent(144,1,i,100,i));
                track.add(makeEvent(128,1,i,100,i+2))
            }
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        }
        catch(Exception ex)
        {

        }
    }
}
