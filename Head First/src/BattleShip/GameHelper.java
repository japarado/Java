package BattleShip;

import javax.xml.bind.SchemaOutputResolver;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Parado on 27/7/2017.
 */
/*
public class GameHelper
{
    private static final String alphabet = "acdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;
    public String getUserInput(String prompt)
    {
        String inputLine = null;
        System.out.println(prompt + " ");
        try
        {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length() == 0 )
                return null;
        }
        catch (IOException error)
        {
            System.out.println("IOException" + error);
        }
        return inputLine;
    }
    public ArrayList<String> placeDotCom(int comSize)
    {
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphacoords = new String[comSize];
        String temp = null;
        int coords[] = new int[comSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;

        comCount++;
        int incr = 1;
        if((comCount % 2) == 1)
        {
            incr = gridLength;
        }
        while(!success & attempts ++ < 200)
        {
            location = (int) (Math.random() * gridSize);
            //System.out.println(" try " + location);
            int x=0;
            success = true;
            while(success && x < comSize)
            {
                if (grid[location] == 0)
                {
                    coords[x++] = location;
                    location += incr;
                    if(location >= gridSize)
                    {
                        success = false;
                    }
                    if(x>0 && (location % gridLength == 0))
                    {
                        success = false;
                    }
                    else
                    {
                        //System.out.println(" used " + location);
                        success = false;
                    }
                }
            }
            x=0;
            int row = 0;
            int column = 0;
            //System.out.println("\n");
            while(x<comSize)
            {
                grid[coords[x]] = 1;
                row = (int) (coords[x] / gridLength);
                column = coords[x] % gridLength;
                temp = String.valueOf(alphabet.charAt(column));

                alphaCells.add(temp.concat(Integer.toString(row)));
                x++;
                //System.out.print(" coord "x++" = " + alphaCells.get(x-1)));
            }
            //System.out.print("\n");

        }
        return alphaCells;
    }

}
*/