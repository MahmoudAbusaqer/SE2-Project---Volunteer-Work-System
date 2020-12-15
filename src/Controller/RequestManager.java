/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBConnection;
import Model.RequestVolunteer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class RequestManager {

    private RequestVolunteer model;
    private Connection connection;

    public RequestManager(RequestVolunteer model) {
        this.model = model;
        connection = DBConnection.getConnection();
    }

    public void showInstitutions(String name, String email, String address, int phone) {

    }

    public void requestVlounteer(int studentId, String studentName, int institutionId, String institutionName) {

    }

    public void add(RequestVolunteer newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into volunteerrequests(studentId, studentName, institutionId, institutionName, district, address) values (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, newObject.getStudentId());
            statement.setString(2, newObject.getStudentName());
            statement.setInt(3, newObject.getInstitutionId());
            statement.setString(4, newObject.getStudentName());
            statement.setString(5, newObject.getDistrict());
            statement.setString(6, newObject.getStudentName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int objectId) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from volunteerrequests where id=?");
            statement.setInt(1, objectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(int objectId) {

    }
}
