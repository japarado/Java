package ContactsList;

import org.jetbrains.annotations.Contract;

/**
 * Created by Parado on 27/7/2017.
 */
public /*final*/ class Contact
{
    private String name;
    private String number;

    public void setName(String newName)
    {
        name = newName;
    }
    public void steNumber(String newNumber)
    {
        number = newNumber;
    }
    public String getName()
    {
        return name;
    }
    public String getNumber()
    {
        return number;
    }
}
