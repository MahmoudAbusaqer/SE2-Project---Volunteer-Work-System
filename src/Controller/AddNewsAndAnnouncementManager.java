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
public class AddNewsAndAnnouncementManager{

    private AddNewsAndAnnouncement addNewsAndAnnouncementModel;
    private StudentMailbox studentMailboxModel;
    private InstitutionMailbox institutionMailboxModel;
    private Connection connection;

    public AddNewsAndAnnouncementManager(AddNewsAndAnnouncement addNewsAndAnnouncementModel) {
        this.addNewsAndAnnouncementModel = addNewsAndAnnouncementModel;
        connection = DBConnection.getConnection();
    }

    public void AddNewsAndAnnouncement(String nOr, String title, String body, Date date) {
        AddNewsAndAnnouncement addNewsAndAnnouncement = new AddNewsAndAnnouncement();
        addNewsAndAnnouncement.setnOrA(nOr);
        addNewsAndAnnouncement.setTitle(title);
        addNewsAndAnnouncement.setBody(body);
        addNewsAndAnnouncement.setDate(date);
        add(addNewsAndAnnouncement);
        StudentMailbox studentMailbox = new StudentMailbox();
        studentMailbox.setSenderId(111);
        studentMailbox.setSenderName("DOV");
        studentMailbox.setTitle(title);
        studentMailbox.setBody(body);
        studentMailbox.setDate(date);
        studentMailbox.setApproveOrDeny(true);
        addToStudent(studentMailbox);
        InstitutionMailbox institutionMailbox = new InstitutionMailbox();
        institutionMailbox.setSenderId(111);
        institutionMailbox.setSenderName("DOV");
        institutionMailbox.setTitle(title);
        institutionMailbox.setBody(body);
        institutionMailbox.setDate(date);
        institutionMailbox.setApproveOrDeny(true);
        addToInstitution(institutionMailbox);
    }

    public void add(AddNewsAndAnnouncement newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.newsandannounment(NOrA, title, body, date) values (?, ?, ?, ?)");
            statement.setString(1, newObject.getnOrA());
            statement.setString(2, newObject.getTitle());
            statement.setString(3, newObject.getBody());
            statement.setDate(4, new java.sql.Date(newObject.getDate().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addToStudent(StudentMailbox newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.studentmailbox(senderId, senderName, title, body, date, approveOrDeny, typeOfMail) values (?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, newObject.getSenderId());
            statement.setString(2, newObject.getSenderName());
            statement.setString(3, newObject.getTitle());
            statement.setString(4, newObject.getBody());
            statement.setDate(5, new java.sql.Date(newObject.getDate().getTime()));
            statement.setBoolean(6, newObject.isApproveOrDeny());
            statement.setString(7, "NewsAndAnnouncement");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addToInstitution(InstitutionMailbox newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.institutionmailbox(senderId, senderName, title, body, date, approveOrDeny, typeOfMail) values (?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, newObject.getSenderId());
            statement.setString(2, newObject.getSenderName());
            statement.setString(3, newObject.getTitle());
            statement.setString(4, newObject.getBody());
            statement.setDate(5, new java.sql.Date(newObject.getDate().getTime()));
            statement.setBoolean(6, newObject.isApproveOrDeny());
            statement.setString(7, "NewsAndAnnouncement");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
