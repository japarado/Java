package Handling;

public class TestException
{
    public static void main(String[] args)
    {
        try
        {
            errorMethod();
            System.out.println("Successful");
        }
        catch(NullPointerException e)
        {
            System.out.println("Failed " + e);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Failed " + e);
        }
        finally
        {
            System.out.println("Finally");
        }
    }

    public static void errorMethod() throws ArrayIndexOutOfBoundsException
    {
        String[] yes = new String[1];
        yes[1] = "rawr";
    }
}
