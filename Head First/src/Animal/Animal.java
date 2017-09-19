package Animal;

public abstract class Animal
{
    private String name;
    private int age;

    public Animal()
    {
        this.name = "NULL";
        this.age = 0;
    }
    public Animal(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public Animal(int age)
    {
        this.age = age;
    }
    public Animal(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getAge()
    {
        return this.age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
}
