package org.fasttrackit;

import org.fasttrackit.persitence.ContactRepository;

import java.io.IOException;
import java.sql.SQLException;


public class App 
{
    public static void main( String[] args ) throws SQLException, IOException, ClassNotFoundException, NullPointerException {
        ContactRepository contactRepository = new ContactRepository();
        contactRepository.updateContact(1, 123456789);
        System.out.println(contactRepository.getContacts());
    }
}
