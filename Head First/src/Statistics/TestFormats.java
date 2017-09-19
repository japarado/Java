package Statistics;

public class TestFormats
{
    public static void main(String[] args)
    {
        //formatting a number to use commas
        String s = String.format("%, d",1000000000);
        //the 'd' means DECIMAL INTEGER
        System.out.println(s);
        String h = String.format("I have %.2f bugs to fix.",4756578.09876);
        System.out.println(h);
        // the '2f' means a floating point rounded off to the second decimal point

        String g = String.format("I have %s bugs to fix.",23);
        System.out.println(g);


    }
}
