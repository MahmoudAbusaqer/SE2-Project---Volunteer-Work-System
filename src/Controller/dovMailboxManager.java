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

    public dovMailboxManager(DOVMailbox model) {
        this.modelDOV = model;
        connection = DBConnection.getConnection();
    }

    public List<DOVMailbox> showMailbox() throws SQLException {
        List<DOVMailbox> dOVMailboxs = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from vws.dovmailbox;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            modelDOV.setSenderId(resultSet.getInt(2));
            modelDOV.setSenderName(resultSet.getString(3));
            modelDOV.setTitle(resultSet.getString(4));
            modelDOV.setBody(resultSet.getString(5));
            modelDOV.setDate(resultSet.getDate(6));
            modelDOV.setApproveOrDeny(resultSet.getBoolean(7));
            dOVMailboxs.add(modelDOV);
        }
        return dOVMailboxs;
    }

    //if the sender is a student the response should go to the student otherwise to the institutions
    public void mailResponse(int senderId, String senderName, String title, String body, Date date, boolean approveOrDeny) {
        if (senderId == 0) {//if senderId is for a student
            modelStudent.setSenderId(senderId);
            modelStudent.setSenderName(senderName);
            modelStudent.setTitle(title);
            modelStudent.setDate(date);
            modelStudent.setApproveOrDeny(approveOrDeny);
            addToStudent(modelStudent);
        } else if (senderId == 0) {//if the sender for an institution and it is a final rebort then the student get a resonse too
            modelInstitution.setSenderId(senderId);
            modelInstitution.setSenderName(senderName);
            modelInstitution.setTitle(title);
            modelInstitution.setDate(date);
            modelInstitution.setApproveOrDeny(approveOrDeny);
            addToInstitutions(modelInstitution);//to send the email to institution
            modelStudent.setSenderId(senderId);
            modelStudent.setSenderName(senderName);
            modelStudent.setTitle(title);
            modelStudent.setDate(date);
            modelStudent.setApproveOrDeny(approveOrDeny);
            addToStudent(modelStudent);//to send the email to student
        } else {
            //error message
        }
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
