package ContactManagementLab054.controller;

import java.util.ArrayList;

import ContactManagementLab054.model.Contact;
import ContactManagementLab054.repository.ContactRepository;
import ContactManagementLab054.view.Menu;

public class ContactManager extends Menu<String>{

    private ContactRepository contactRepository = new ContactRepository();
    private ArrayList<Contact> contacts = new ArrayList<>();

    static String [] mc = {"Add a contact", "Display all contact", "Delete a contact", "Exit"};

    public ContactManager() {
        super("====== Contact Program ======", mc);
    }


    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                contactRepository.addAContact(contacts);
                break;
            
            case 2:
                contactRepository.displayAllContact(contacts);
                break;

            case 3:
                contactRepository.deleteContactByID(contacts);
                break;

            case 4:
                System.exit(0);      
           
        }
    }
    
}
