package ContactManagementLab054.repository;

import java.util.ArrayList;

import ContactManagementLab054.common.Validate;
import ContactManagementLab054.model.Contact;

public class ContactRepository implements IContactRepository {

    private Validate check = new Validate();

    @Override
    public boolean addAContact(ArrayList<Contact> contacts) {
        int oldSize = contacts.size();
        int id = check.getID(contacts);
        System.out.println("ID: " + id);
        System.out.println("Enter Full Name: ");
        String fullName = check.getString();
        System.out.println("Enter group: ");
        String group = check.getString();
        System.out.println("Enter address: ");
        String address = check.getString();
        String phone = check.getValidPhoneNumber();

        Contact contact = new Contact(id, fullName, group, address, phone);
        contacts.add(contact);

        int newSize = contacts.size();
        if (oldSize < newSize) {
            System.out.println("Succesful!");
            return true;
        } else {
            System.out.println("Falled");
            return false;
        }

    }

    @Override
    public void displayAllContact(ArrayList<Contact> contacts) {
        System.out.println("--------------------------------- Display all Contacts ----------------------------");
        System.out.println("ID   \tName\t\t\tFirst Name\tLast Name\tGroup\tAddress\t\tPhone");

        for (Contact contact : contacts) {
            System.out.printf("%-5s\t%-20s\t%-10s\t%-10s\t%-5s\t%-10s\t%-10s%n",
                    contact.getId(),
                    contact.getFullName(),
                    contact.getFirstName(),
                    contact.getLastName(),
                    contact.getGroup(),
                    contact.getAddress(),
                    contact.getPhone());
        }

        System.out.println("----------------------------------------------------------------------------------");

    }

    @Override
    public boolean deleteContactByID(ArrayList<Contact> contacts) {

        int idToDelete = check.getIntData("Enter id want to delete: ");
        Contact contactDelete = getContactByID(contacts, idToDelete);
        if (contactDelete != null) {
            contacts.remove(contactDelete);
            System.out.println("Succesful!");
            return true;
        }else{
            return false;
        }

    }

    @Override
    public Contact getContactByID(ArrayList<Contact> contacts, int id) {

        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }

        return null;
    }

}
