package Statistics;

public class TestBox
{
    /*WILL NOT COMPILE*/
    Integer i;
    int j;

    public static void main(String[] args)
    {
        TestBox t = new TestBox();
        t.go();
    }

    public void go()
    {
        j=i;
        System.out.println(i);
        System.out.println(j);
    }
}
