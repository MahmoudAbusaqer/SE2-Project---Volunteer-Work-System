/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AddInstitutions;
import Model.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class AddInstitutionsManager {

    private AddInstitutions model;
    private Connection connection;

    public AddInstitutionsManager(AddInstitutions model) {
        this.model = model;
        connection = DBConnection.getConnection();
    }

    public void AddInstitutionInput(String name, String email, String distict, int phone, int district) {

    }

    public void add(AddInstitutions newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into proposedinstitutions(name, address, email, phone, district) values (?,?,?,?,?)");
            statement.setString(1, newObject.getName());
            statement.setString(2, newObject.getAddress());
            statement.setString(3, newObject.getEmail());
            statement.setInt(4, newObject.getPhone());
            statement.setInt(5, newObject.getDistrict());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int objectId) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from proposedinstitutions where id=?");
            statement.setInt(1, objectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(int objectId) {

    }
}
