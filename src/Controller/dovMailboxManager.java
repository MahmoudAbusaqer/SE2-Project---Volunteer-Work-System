/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBConnection;
import Model.DOVMailbox;
import Model.InstitutionMailbox;
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
//This class is only for the DOV to see their mailbox and if they have new mail from the Students or Institutions.
public class dovMailboxManager {

    private DOVMailbox modelDOV;
    private InstitutionMailbox modelInstitution;
    private StudentMailbox modelStudent;
    private Connection connection;

    public dovMailboxManager(DOVMailbox modelDOV) {
        this.modelDOV = modelDOV;
        this.modelInstitution = new InstitutionMailbox();
        this.modelStudent = new StudentMailbox();
        connection = DBConnection.getConnection();
    }

    public List<DOVMailbox> showMailbox() throws SQLException {
        List<DOVMailbox> dOVMailboxs = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from vws.dovmailbox;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            DOVMailbox dOVMailbox = new DOVMailbox();
            dOVMailbox.setSenderId(resultSet.getInt(2));
            dOVMailbox.setSenderName(resultSet.getString(3));
            dOVMailbox.setTitle(resultSet.getString(4));
            dOVMailbox.setBody(resultSet.getString(5));
            dOVMailbox.setDate(resultSet.getDate(6));
            dOVMailbox.setApproveOrDeny(resultSet.getBoolean(7));
            dOVMailboxs.add(dOVMailbox);
        }
        return dOVMailboxs;
    }

    //if the sender is a student the response should go to the student otherwise to the institutions
    public void mailResponse(int senderId, String senderName, String title, String body, Date date, boolean approveOrDeny, String typeOfMail) {
        if (typeOfMail != null) {
            switch (typeOfMail) {
                case "finish vlounteer":
                    mailResponseInstitution(senderId, senderName, title, body, date, approveOrDeny, typeOfMail);
                    mailResponseStudent(senderId, senderName, title, body, date, approveOrDeny, typeOfMail);
                    break;
                default:
                    mailResponseStudent(senderId, senderName, title, body, date, approveOrDeny, typeOfMail);
            }
        }
    }

    public void mailResponseInstitution(int senderId, String senderName, String title, String body, Date date, boolean approveOrDeny, String typeOfMail) {
        modelInstitution.setSenderId(senderId);
        modelInstitution.setSenderName(senderName);
        modelInstitution.setTitle(title);
        if (approveOrDeny) {
            modelInstitution.setBody("Your request to " + typeOfMail + " was approved ☺ you can now continue.");
        } else {
            modelInstitution.setBody("Your request to " + typeOfMail + " was denied 😢 try again and make sure you complete all the processes.");
        }
        modelInstitution.setDate(date);
        modelInstitution.setApproveOrDeny(approveOrDeny);
        addToInstitutions(modelInstitution);//to send the email to institution
    }

    public void mailResponseStudent(int senderId, String senderName, String title, String body, Date date, boolean approveOrDeny, String typeOfMail) {
        modelStudent.setSenderId(senderId);
        modelStudent.setSenderName(senderName);
        modelStudent.setTitle(title);
        if (approveOrDeny) {
            modelStudent.setBody("Your request to " + typeOfMail + " was approved ☺ you can now continue.");
        } else {
            modelStudent.setBody("Your request to " + typeOfMail + " was denied 😢 try again.");
        }
        modelStudent.setDate(date);
        modelStudent.setApproveOrDeny(approveOrDeny);
        addToStudent(modelStudent);//to send the email to student
    }

    public void addToStudent(StudentMailbox newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.studentmailbox(senderId, senderName, title, body, date, approveOrDeny) values (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, newObject.getSenderId());
            statement.setString(2, newObject.getSenderName());
            statement.setString(3, newObject.getTitle());
            statement.setString(4, newObject.getBody());
            statement.setDate(5, new java.sql.Date(newObject.getDate().getTime()));
            statement.setBoolean(6, newObject.isApproveOrDeny());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addToInstitutions(InstitutionMailbox newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.institutionmailbox(senderId, senderName, title, body, date, approveOrDeny) values (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, newObject.getSenderId());
            statement.setString(2, newObject.getSenderName());
            statement.setString(3, newObject.getTitle());
            statement.setString(4, newObject.getBody());
            statement.setDate(5, new java.sql.Date(newObject.getDate().getTime()));
            statement.setBoolean(6, newObject.isApproveOrDeny());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int objectId) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from vws.dovmailbox where id=?");
            statement.setInt(1, objectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(int objectId) {

    }
}
