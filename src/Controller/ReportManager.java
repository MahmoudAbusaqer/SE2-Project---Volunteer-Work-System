/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBConnection;
import Model.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class ReportManager {

    private Report model;
    private Connection connection;

    public ReportManager(Report model) {
        this.model = model;
        connection = DBConnection.getConnection();
    }

    public void reportInput(int studentId, String studentName, String institutionName, String report) {
        model.setStudentId(studentId);
        model.setStudentName(studentName);
        model.setInstitutionName(institutionName);
        model.setReport(report);
        add(model);
    }

    public void add(Report newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into institutionreport(studentId, studentName, institutionName, report) values (?, ?, ?, ?)");
            statement.setInt(1, newObject.getStudentId());
            statement.setString(2, newObject.getStudentName());
            statement.setString(3, newObject.getInstitutionName());
            statement.setString(4, newObject.getReport());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int objectId) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from institutionreport where id=?");
            statement.setInt(1, objectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(int objectId) {

    }
}
