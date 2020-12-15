/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBConnection;
import Model.StudentMailbox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class StudentMailboxManager {

    private StudentMailbox model;
    private Connection connection;

    public StudentMailboxManager(StudentMailbox model) {
        this.model = model;
        connection = DBConnection.getConnection();
    }

    public void showMailbox(int senderId, String senderName, String title, String body, Date date, boolean approveOrDeny) {

    }

    public void add(StudentMailbox newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into studentmailbox(senderId, senderName, title, body, date) values (?, ?, ?, ?, ?)");
            statement.setInt(1, newObject.getSenderId());
            statement.setString(2, newObject.getSenderName());
            statement.setString(3, newObject.getTitle());
            statement.setString(4, newObject.getBody());
            statement.setDate(5, new java.sql.Date(newObject.getDate().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int objectId) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from studentmailbox where id=?");
            statement.setInt(1, objectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(int objectId) {

    }
}
