package DataStructures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Jukebox3
{
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args)
    {
        new Jukebox3().go();
    }

    class ArtistCompare implements Comparator<Song>
    {
        public int compare(Song one, Song two)
        {
            return one.getArtist().compareTo(two.getArtist());
        }
    }

    public void go()
    {
        getSongs();
        System.out.println(songList);
        /*Call the static Collections sort() method, then print the list again.
        The second printout is in alphabetical order*/
        Collections.sort(songList);
        System.out.println(songList);

        //Make an instance of the comparator INNER class
        ArtistCompare artistCompare = new ArtistCompare();
        /*invoke sort(), passing it the list and a reference to
        the new custom Comparator object */
        Collections.sort(songList,artistCompare);

        System.out.println(songList);
    }
    private void getSongs()
    {
        try
        {
            File file = new File("src/DataStructures/SongList.txt");
            System.out.println(new File("SongList.txt").getAbsolutePath());
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
        Song nextSong = new Song(tokens[0]);
        //Song nextSong = new Song(tokens[0],tokens[1],tokens[2],tokens[3]);
        songList.add(nextSong);
        //songList.add(tokens[0]);
    }
}
