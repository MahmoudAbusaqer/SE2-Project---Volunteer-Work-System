/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBConnection;
import Model.DOV;
import Model.Institutions;
import Model.Student;
import View.LoginPage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class LoginPageManager {

    private Student studentModel;
    private DOV dovModel;
    private Institutions institutionsModel;
    private Connection connection;

    public LoginPageManager() {
        connection = DBConnection.getConnection();
    }

    public List<DOV> checkDOV(int dovId, String password) throws SQLException {
        String checkPassword = null;
        DOV dov = null;
        List<DOV> dovs = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from vws.dov where id=? and password=?;");
        preparedStatement.setInt(1, dovId);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            dov = new DOV();
            dov.setId(resultSet.getInt(1));
            dov.setName(resultSet.getString(2));
            checkPassword = resultSet.getString(3);
            dovs.add(dov);
        }
        if (dovId == dov.getId() && password.equals(checkPassword)) {
            return dovs;
        } else {
            return null;
        }
    }

    public List<Student> checkStudent(int studentId, String password) throws SQLException {
        String checkPassword = null;
        Student student = null;
        List<Student> students = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from vws.students where id=? and password=?;");
        preparedStatement.setInt(1, studentId);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            student = new Student();
            student.setId(resultSet.getInt(1));
            student.setName(resultSet.getString(2));
            student.setFaculty(resultSet.getString(3));
            student.setAddress(resultSet.getString(4));
            student.setEmail(resultSet.getString(5));
            student.setPhone(resultSet.getInt(6));
            checkPassword = resultSet.getString(7);
            students.add(student);
        }
        if (studentId == student.getId() && password.equals(checkPassword)) {
            return students;
        } else {
            return null;
        }
    }

    public List<Institutions> checkInstitution(int institutionId, String password) throws SQLException {
        String checkPassword = null;
        Institutions institution = null;
        List<Institutions> institutionses = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from vws.institutions where id=? and password=?;");
        preparedStatement.setInt(1, institutionId);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            institution = new Institutions();
            institution.setId(resultSet.getInt(1));
            institution.setName(resultSet.getString(2));
            institution.setAddress(resultSet.getString(3));
            institution.setEmail(resultSet.getString(4));
            institution.setPhone(resultSet.getInt(5));
            institution.setDistrict(resultSet.getString(6));
            checkPassword = resultSet.getString(7);
            institutionses.add(institution);
        }
        if (institutionId == institution.getId() && password.equals(checkPassword)) {
            return institutionses;
        } else {
            return null;
        }
    }

}
