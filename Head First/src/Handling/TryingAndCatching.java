package Handling;

public class TryingAndCatching
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println(Math.sqrt(-10));
            System.out.println("Success");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            System.out.println("The finally block");
        }
    }
}
