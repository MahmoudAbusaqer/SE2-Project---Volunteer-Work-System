/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBConnection;
import Model.District;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class DistrictManager {

    private District model;
    private Connection connection;

    public DistrictManager(District model) {
        this.model = model;
        connection = DBConnection.getConnection();
    }

    public void showDistrict() {

    }

    public void districtChose(String district) {

    }

    public void add(District newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into district(name , institutionsNumber) values (?, ?)");
            statement.setString(1, newObject.getName());
            statement.setInt(2, newObject.getInstitutionsNumbers());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int objectId) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from district where id=?");
            statement.setInt(1, objectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(int objectId) {

    }
}
