package DataStructures;

import java.util.List;

public class Song implements Comparable<Song>
{
    private String title;
    private String artist;
    private String rating;
    private String bpm;

    public Song(String title, String artist, String rating, String bpm)
    {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.bpm = bpm;
    }
    public Song (String title)
    {
        this.title = title;
    }

    public int compareTo(Song s)
    {
        return title.compareTo(s.getTitle());
    }

    public String getTitle()
    {
        return title;
    }

    public String getArtist()
    {
        return artist;
    }

    public String getRating()
    {
        return rating;
    }

    public String getBpm()
    {
        return bpm;
    }

    public String toString()
    {
        return title;
    }
}
