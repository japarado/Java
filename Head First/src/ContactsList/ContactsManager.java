package ContactsList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Parado on 27/7/2017.
 */
public class ContactsManager extends Contact
{
    Scanner scan = new Scanner(System.in);
    ArrayList<Contact> contactsList = new ArrayList<Contact>();
    public void addContact()
    {
        contactsList.add(new Contact());
    }
}
