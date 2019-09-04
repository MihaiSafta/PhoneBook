package org.fasttrackit.persitence;

import org.fasttrackit.domain.Contact;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactRepository {
    public void createContact(String name, String lastName, int phoneNumber) throws SQLException, IOException, ClassNotFoundException {
        String insertSql = "INSERT INTO phonebook (name, lastName, phonenumber) VALUE (?,?,?)";
        try (Connection connection = db_configuration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3,phoneNumber);
            preparedStatement.executeUpdate();

        }
    }

    public List<Contact> getContacts() throws SQLException, IOException, ClassNotFoundException {
        String query = "SELECT id, name, lastName,phoneNumber FROM phonebook";
        try (Connection connection = db_configuration.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<Contact> contacts = new ArrayList<>();
            while (resultSet.next()) {
                Contact item = new Contact();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setLastName(resultSet.getString("lastName"));
                item.setPhoneNumber(resultSet.getInt("phoneNumber"));
                contacts.add(item);
            }
            return contacts;
        }
    }

    public void deleteContact(long id) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM phonebook WHERE id = ?";
        try (Connection connection = db_configuration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        }
    }

    public void updateContact(long id, int phoneNumber) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE phonebook SET PhoneNumber = ?, WHERE id = ?";
        try (Connection connection = db_configuration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1,id);
            preparedStatement.setInt(2,phoneNumber);
            preparedStatement.executeUpdate();
        }

    }
}
