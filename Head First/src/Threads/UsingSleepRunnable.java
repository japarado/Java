package Threads;

public class UsingSleepRunnable implements Runnable
{
    public void run()
    {
        go();
    }
    public void go()
    {
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
        doMore();
    }
    public void doMore()
    {
        System.out.println("top o' the stack");
    }
}
class ThreadTesterSleep
{
    public static void main(String[] args)
    {
        Runnable threadJob = new UsingSleepRunnable();
        Thread myThread = new Thread(threadJob);

        myThread.start();
        System.out.println("back in main");
    }
}
