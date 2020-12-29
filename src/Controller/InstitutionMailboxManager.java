/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBConnection;
import Model.InstitutionMailbox;
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
//This class is only for the Institutions to see their mailbox and if they have new mail from the DOV.
public class InstitutionMailboxManager {

    private InstitutionMailbox model;
    private Connection connection;

    public InstitutionMailboxManager(InstitutionMailbox model) {
        this.model = model;
        connection = DBConnection.getConnection();
    }

    public List<InstitutionMailbox> showMailbox(int id) throws SQLException {
        List<InstitutionMailbox> institutionMailboxs = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from vws.institutionmailbox where sendfor=? or sendfor=0;;");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            InstitutionMailbox institutionMailbox = new InstitutionMailbox();
            institutionMailbox.setSenderId(resultSet.getInt(2));
            institutionMailbox.setSenderName(resultSet.getString(3));
            institutionMailbox.setTitle(resultSet.getString(4));
            institutionMailbox.setBody(resultSet.getString(5));
            institutionMailbox.setDate(resultSet.getDate(6));
            institutionMailbox.setApproveOrDeny(resultSet.getBoolean(7));
            institutionMailboxs.add(institutionMailbox);
        }
        return institutionMailboxs;
    }

//    public void add(InstitutionMailbox newObject) {
//        try {
//            PreparedStatement statement = connection.prepareStatement("insert into vws.institutionmailbox(senderId, senderName, title, body, date) values (?, ?, ?, ?, ?)");
//            statement.setInt(1, newObject.getSenderId());
//            statement.setString(2, newObject.getSenderName());
//            statement.setString(3, newObject.getTitle());
//            statement.setString(4, newObject.getBody());
//            statement.setDate(5, new java.sql.Date(newObject.getDate().getTime()));
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void delete(int objectId) {
//        try {
//            PreparedStatement statement = connection.prepareStatement("delete from vws.institutionmailbox where id=?");
//            statement.setInt(1, objectId);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void edit(int objectId) {
//
//    }
}
