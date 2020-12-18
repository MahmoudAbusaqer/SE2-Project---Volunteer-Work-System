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

    public void CreateInitiativeInput(String name, String location, int numberOfVolunteers, int studentId, String description, int phone) {
        model.setStudentId(studentId);
        model.setName(name);
        model.setLocation(location);
        model.setDescription(description);
        model.setPhone(phone);
        model.setNumberOfVolunteers(numberOfVolunteers);
        add(model);
    }

    public void add(CreateInitiative newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.initiativesreqests(name, location, numberOfVolunteers, studentId, description, phone) values (?, ?, ?, ?, ?, ?)");
            statement.setString(1, newObject.getName());
            statement.setString(2, newObject.getLocation());
            statement.setInt(3, newObject.getNumberOfVolunteers());
            statement.setInt(4, newObject.getStudentId());
            statement.setString(5, newObject.getDescription());
            statement.setInt(6, newObject.getPhone());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int objectId) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from vws.initiativesreqests where id=?");
            statement.setInt(1, objectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(int objectId) {

    }
}
