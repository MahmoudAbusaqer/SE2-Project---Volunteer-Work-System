/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBConnection;
import Model.StatisticsInstitution;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class StatisticManagerInstitution {

    private StatisticsInstitution model;
    private Connection connection;

    public StatisticManagerInstitution(StatisticsInstitution model) {
        this.model = model;
        connection = DBConnection.getConnection();
    }

    public void showStatistics() {

    }

    public void add(StatisticsInstitution newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into statisticsinstitution(institutionId, institutionName, numberOfAllStudents, studentsFinishedNumbers, activeVolunteers) values (?, ?, ?, ?, ?)");
            statement.setInt(1, newObject.getInstitutionId());
            statement.setString(2, newObject.getInstitutionName());
            statement.setInt(3, newObject.getNumberOfAllStudents());
            statement.setInt(4, newObject.getStudentsFinishedNumbers());
            statement.setInt(5, newObject.getActiveVolunteers());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int objectId) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from statisticsinstitution where id=?");
            statement.setInt(1, objectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(StatisticsInstitution newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("update statisticsinstitution set institutionId=?, institutionName=?, numberOfAllStudents=?, studentsFinishedNumbers=?, activeVolunteers=? where id=?");
            statement.setInt(1, newObject.getInstitutionId());
            statement.setString(2, newObject.getInstitutionName());
            statement.setInt(3, newObject.getNumberOfAllStudents());
            statement.setInt(4, newObject.getStudentsFinishedNumbers());
            statement.setInt(5, newObject.getActiveVolunteers());
            statement.setInt(6, newObject.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
