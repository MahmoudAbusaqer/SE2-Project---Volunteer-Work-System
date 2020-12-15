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
import java.sql.SQLException;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class StatisticManagerDoV {

    private StatisticsDoV model;
    private Connection connection;

    public StatisticManagerDoV(StatisticsDoV model) {
        this.model = model;
        connection = DBConnection.getConnection();
    }

    public void showStatistics() {

    }

    public void add(StatisticsDoV newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into statisticsdov(volunteersNumbers, institutionNumbers, finishedVolunteersNumbers, initiatives, activeVolunteers, activeInitiatives) values (?, ?, ?, ?, ?, ?)");
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

    public void delete(int objectId) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from statisticsdov where id=?");
            statement.setInt(1, objectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(StatisticsDoV newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("update statisticsdov set volunteersNumbers=?, institutionNumbers=?, finishedVolunteersNumbers=?, initiatives=?, activeVolunteers=?, activeInitiatives=? where id=?");
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
