package Animal;

public class Launcher
{
    public static void main(String[] args)
    {
        Dog doggo = new Dog(12);
        System.out.println(doggo.getName());
        System.out.println(doggo.getAge());
    }
}
