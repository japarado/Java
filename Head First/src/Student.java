public class Student extends Person
{
    String idNum = "###-###-###";
    public Student(String name)
    {
        super(name);
    }
    public Student(String name, String idNum)
    {
        super(name);
        this.idNum = idNum;
    }
    public Student()
    {
        super();
    }
}
