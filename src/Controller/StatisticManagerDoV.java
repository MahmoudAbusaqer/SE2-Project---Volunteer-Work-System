/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBConnection;
import Model.StatisticsDoV;
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
//This class is only for the DOV to see all the statistics that they need about the volunteer work in the system.
public class StatisticManagerDoV {

    private StatisticsDoV model;
    private Connection connection;

    public StatisticManagerDoV(StatisticsDoV model) {
        this.model = model;
        connection = DBConnection.getConnection();
    }

    public List<StatisticsDoV> showStatistics() throws SQLException {
        List<StatisticsDoV> statisticsDoVs = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from vws.statisticsdov;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            StatisticsDoV statisticsDoV = new StatisticsDoV();
            statisticsDoV.setVolunteersNumbers(resultSet.getInt(2));
            statisticsDoV.setInstitutionsNumbers(resultSet.getInt(3));
            statisticsDoV.setFinishedVolunteersNumbers(resultSet.getInt(4));
            statisticsDoV.setInitiatives(resultSet.getInt(5));
            statisticsDoV.setActiveVolunteers(resultSet.getInt(6));
            statisticsDoV.setActiveInitiatives(resultSet.getInt(7));
            statisticsDoVs.add(statisticsDoV);
        }
        return statisticsDoVs;
    }

    public void add(StatisticsDoV newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.statisticsdov(volunteersNumbers, institutionNumbers, finishedVolunteersNumbers, initiatives, activeVolunteers, activeInitiatives) values (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, newObject.getVolunteersNumbers());
            statement.setInt(2, newObject.getInstitutionsNumbers());
            statement.setInt(3, newObject.getFinishedVolunteersNumbers());
            statement.setInt(4, newObject.getInitiatives());
            statement.setInt(5, newObject.getActiveVolunteers());
            statement.setInt(6, newObject.getActiveInitiatives());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void delete(int objectId) {
//        try {
//            PreparedStatement statement = connection.prepareStatement("delete from vws.statisticsdov where id=?");
//            statement.setInt(1, objectId);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    public void edit(StatisticsDoV newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("update vws.statisticsdov set volunteersNumbers=?, institutionNumbers=?, finishedVolunteersNumbers=?, initiatives=?, activeVolunteers=?, activeInitiatives=? where id=?");
            statement.setInt(1, newObject.getVolunteersNumbers());
            statement.setInt(2, newObject.getInstitutionsNumbers());
            statement.setInt(3, newObject.getFinishedVolunteersNumbers());
            statement.setInt(4, newObject.getInitiatives());
            statement.setInt(5, newObject.getActiveVolunteers());
            statement.setInt(6, newObject.getActiveInitiatives());
            statement.setInt(7, newObject.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
