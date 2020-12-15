/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CreateInitiative;
import Model.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class CreateInitiativeManager {

    private CreateInitiative model;
    private Connection connection;

    public CreateInitiativeManager(CreateInitiative model) {
        this.model = model;
        connection = DBConnection.getConnection();
    }

    public void CreateInitiativeInput(int studentId, String name, String location, String description, int phone, int numberOfVolunteers) {

    }

    public void add(CreateInitiative newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into initiativesreqests(name, location, description, phone, numberOfVolunteers) values (?, ?, ?, ?, ?)");
            statement.setString(1, newObject.getName());
            statement.setString(2, newObject.getLocation());
            statement.setString(3, newObject.getDescription());
            statement.setInt(4, newObject.getPhone());
            statement.setInt(5, newObject.getNumberOfVolunteers());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int objectId) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from initiativesreqests where id=?");
            statement.setInt(1, objectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(int objectId) {

    }
}
