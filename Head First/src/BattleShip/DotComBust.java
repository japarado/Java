package BattleShip;

import java.util.ArrayList;
import java.lang.*;
/**
 * Created by Parado on 28/7/2017.
 */
/*
public class DotComBust
{
    private GameHelper helper = new GameHelper();
    ArrayList<DotCom> dotComsList = new ArrayList<>();
    int numOfGuesses = 0;

    private void setUpGame()
    {
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        System.out.println("Your goal is to sink three dot coms");
        System.out.println(one.getName() + " " + two.getName() + " " + three.getName());
        for(DotCom dotComToSet:dotComsList)
        {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }
    private void startPlaying()
    {
        while(!dotComsList.isEmpty())
        {
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    private void checkUserGuess(String userGuess)
    {
        numOfGuesses++;
        String result = "miss";
        for(DotCom dotComToTest : dotComsList)
        {
            result = dotComToTest.checkYourself(userGuess);
            if(result.equals("hit"))
            {
                break;
            }
            if(result.equals("kill"))
            {
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame()
    {
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        if(numOfGuesses <= 18)
        {
            System.out.println("It only took you " + numOfGuesses + " guesses");
            System.out.println("You got out before your options sank");
        }
        else
        {
            System.out.println("Took tou long enough " + numOfGuesses + " guesses");
            System.out.println("Fish are dancing with your options");
        }
    }
}
*/