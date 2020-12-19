/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AddNewsAndAnnouncement;
import Model.DBConnection;
import Model.InstitutionMailbox;
import Model.StudentMailbox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Mahmoud_Abusaqer
 */
//This class is only for the DOV to only add a new News and Announcement and send them to the students & Institutions Mailboxes.
public class AddNewsAndAnnouncementManager {

    private AddNewsAndAnnouncement model;
    private Connection connection;

    public AddNewsAndAnnouncementManager(AddNewsAndAnnouncement model) {
        this.model = model;
        connection = DBConnection.getConnection();
    }

    public void AddNewsAndAnnouncement(int nOr, String title, String body, Date date) {
        model.setnOrA(nOr);
        model.setTitle(title);
        model.setBody(body);
        model.setDate(date);
        add(model);
    }

    public void add(AddNewsAndAnnouncement newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.newsandannounment(NOrA, title, body, date) values (?, ?, ?, ?)");
            statement.setInt(1, newObject.getnOrA());
            statement.setString(2, newObject.getTitle());
            statement.setString(3, newObject.getBody());
            statement.setDate(4, new java.sql.Date(newObject.getDate().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    
    public void add(InstitutionMailbox newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.institutionmailbox(senderId, senderName, title, body, date) values (?, ?, ?, ?, ?)");
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

//    public void delete(int objectId) {
//        try {
//            PreparedStatement statement = connection.prepareStatement("delete from vws.newsandannounment where id=?");
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
