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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public List<StudentMailbox> showMailbox() throws SQLException {
        List<StudentMailbox> studentMailboxs = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from vws.studentmailbox;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            model.setSenderId(resultSet.getInt(2));
            model.setSenderName(resultSet.getString(3));
            model.setTitle(resultSet.getString(4));
            model.setBody(resultSet.getString(5));
            model.setDate(resultSet.getDate(6));
            model.setApproveOrDeny(resultSet.getBoolean(7));
            studentMailboxs.add(model);
        }
        return studentMailboxs;
    }

    public void add(StudentMailbox newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.studentmailbox(senderId, senderName, title, body, date) values (?, ?, ?, ?, ?)");
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
            PreparedStatement statement = connection.prepareStatement("delete from vws.studentmailbox where id=?");
            statement.setInt(1, objectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(int objectId) {

    }
}
