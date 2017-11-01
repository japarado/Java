package DataStructures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Jukebox1
{
    ArrayList<String> songList = new ArrayList<String>();

    public static void main(String[] args)
    {
        new Jukebox1().go();
    }
    public void go()
    {
        getSongs();
        System.out.println(songList);
        /*Call the static Collections sort() method, then print the list again.
        The second printout is in alphabetical order*/
        Collections.sort(songList);
        System.out.println(songList);
    }
    private void getSongs()
    {
        try
        {
            File file = new File("src/DataStructures/SongList.txt");
            //System.out.println(new File("SongList.txt").getAbsolutePath());
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null)
            {
                addSong(line);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    private void addSong(String lineToParse)
    {
        String[] tokens = lineToParse.split("/");
        songList.add(tokens[0]);
    }
}
