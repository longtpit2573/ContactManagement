package ContactManagementLab054.repository;

import java.util.ArrayList;

import ContactManagementLab054.model.Contact;

public interface IContactRepository {
    boolean addAContact(ArrayList<Contact> contacts);
    void displayAllContact(ArrayList<Contact> contacts);
    boolean deleteContactByID(ArrayList<Contact> contacts);
    Contact getContactByID(ArrayList<Contact>contacts, int id);
}
