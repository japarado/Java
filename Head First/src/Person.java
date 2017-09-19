import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Parado on 6/8/2017.
 */
public class Person
{
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address)
    {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public Person(String name)
    {
        this.name = name;
    }
    public Person(int age)
    {
        this.age = age;
    }
    public Person()
    {
        this.name = "Dee Fault";
        this.age = 000;
        this.address = "ADDRESS VOID";
    }
    public String getName()
    {
        return this.name;
    }
    public int getAge()
    {
        return this.age;
    }
    public String getAddress()
    {
        return this.address;
    }
    public void setname(String name)
    {
        this.name = name;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getInfo()
    {
        String infoString = "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Address: " + address;
        return infoString;
    }

}
