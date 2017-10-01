package FileReading;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class FileExp
{
    public static void main(String[] args)
    {
        //make a file object representing an existing object
        File f = new File("MyCode.txt");

        //make a new directory
        File dir = new File("Chapter 7");
        dir.mkdir();

        //list the contents of a directory
        if(dir.isDirectory())
        {
            String[] dirContents = dir.list();
            for(int i=0;i<dirContents.length;i++)
            {
                System.out.println(dirContents[i]);
            }
        }

        //get the absolute path of a file pr directory
        System.out.println(dir.getAbsolutePath());

        //delete a file or directory(returns true if sucessful)
        boolean isDeleted = f.delete();
        System.out.println("Is deleted = " + isDeleted);
    }
}
