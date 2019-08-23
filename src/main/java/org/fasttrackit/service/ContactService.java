package org.fasttrackit.service;

import org.fasttrackit.domain.Contact;
import org.fasttrackit.persitence.ContactRepository;
import org.fasttrackit.transfer.SaveContactRequest;
import org.fasttrackit.transfer.UpdateContactRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ContactService {
    private ContactRepository contactRepository = new ContactRepository();

    public void createContact(SaveContactRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Creating contact" + request);
        contactRepository.createContact(request.getName(), request.getLastName(),request.getPhoneNumber());
    }
    public List<Contact> getContacts() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving contacts..." );
        return contactRepository.getContacts();
    }
    public  void deleteContact(long id) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting contact: " + id);
        contactRepository.deleteContact(id);
    }
    public void updateContacts(Long id, UpdateContactRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Updating contact" + id + ":"+ request);
        contactRepository.updateContact(id,request.getPhoneNumber());
    }
}
