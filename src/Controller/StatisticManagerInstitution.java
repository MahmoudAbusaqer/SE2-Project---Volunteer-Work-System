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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mahmoud_Abusaqer
 */
//This class is only for the Institutions to see all the statistics that they need about the volunteer work in their Institution.
public class StatisticManagerInstitution {

    private StatisticsInstitution model;
    private Connection connection;

    public StatisticManagerInstitution(StatisticsInstitution model) {
        this.model = model;
        connection = DBConnection.getConnection();
    }

    public List<StatisticsInstitution> showStatistics(int institutionId) throws SQLException {
        List<StatisticsInstitution> statisticsInstitutions = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from vws.statisticsinstitution where id=?;");
        preparedStatement.setInt(1, institutionId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            model.setInstitutionId(resultSet.getInt(2));
            model.setInstitutionName(resultSet.getString(3));
            model.setNumberOfAllStudents(resultSet.getInt(4));
            model.setStudentsFinishedNumbers(resultSet.getInt(5));
            model.setActiveVolunteers(resultSet.getInt(6));
            statisticsInstitutions.add(model);
        }
        return statisticsInstitutions;
    }

    public void add(StatisticsInstitution newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.statisticsinstitution(institutionId, institutionName, numberOfAllStudents, studentsFinishedNumbers, activeVolunteers) values (?, ?, ?, ?, ?)");
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

//    public void delete(int objectId) {
//        try {
//            PreparedStatement statement = connection.prepareStatement("delete from vws.statisticsinstitution where id=?");
//            statement.setInt(1, objectId);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void edit(StatisticsInstitution newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("update vws.statisticsinstitution set institutionId=?, institutionName=?, numberOfAllStudents=?, studentsFinishedNumbers=?, activeVolunteers=? where id=?");
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
