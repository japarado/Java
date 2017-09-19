package Statistics;

public class Duck
{
    int size;
    static int count;

    public Duck()
    {
        size = 20;
    }
    public Duck(int size)
    {
        this.size = size;
    }

    public void makeSound()
    {
        System.out.println("Quack");
    }
}
