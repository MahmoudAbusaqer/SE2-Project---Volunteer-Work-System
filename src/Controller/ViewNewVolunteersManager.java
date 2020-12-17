/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBConnection;
import Model.ViewNewVolunteers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class ViewNewVolunteersManager {

    private ViewNewVolunteers model;
    private Connection connection;

    public ViewNewVolunteersManager(ViewNewVolunteers model) {
        this.model = model;
        connection = DBConnection.getConnection();
    }

    public void showNewVolunteers() {
        //need a select to show New Volunteers
    }

    public void add(ViewNewVolunteers newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into viewnewvolunteers(studentId, name, faculty, address, email, phone) values (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, newObject.getId());
            statement.setString(2, newObject.getName());
            statement.setString(3, newObject.getFaculty());
            statement.setString(4, newObject.getAddress());
            statement.setString(5, newObject.getEmail());
            statement.setInt(6, newObject.getPhone());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int objectId) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from viewnewvolunteers where id=?");
            statement.setInt(1, objectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(int objectId) {

    }
}
