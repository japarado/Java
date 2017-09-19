package Statistics;

public class ExceptionExperiment
{
    public static void main(String[] args)
    {
        String t = "two";
        try
        {
            int y = Integer.parseInt(t);
        }
        catch(NumberFormatException error)
        {
            System.out.println(error);
        }
    }
}
