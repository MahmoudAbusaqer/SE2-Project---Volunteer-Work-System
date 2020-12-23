/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBConnection;
import Model.DOVMailbox;
import Model.Report;
import Model.Student;
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
//This class is only for the Institutions to send a report to the DOVMailbox when a student completes all the hours required to pass the volunteer course.
public class ReportManager {

    private Report reportModel;
    private Student studentModel;
    private DOVMailbox dOVMailboxModel;
    private Connection connection;

    public ReportManager(Report reportModel) {
        this.reportModel = reportModel;
        this.studentModel = new Student();
        this.dOVMailboxModel = new DOVMailbox();
        connection = DBConnection.getConnection();
    }

    public List<Student> showStudent(int institutionId) throws SQLException {
        List<Student> students = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from vws.volunteers where institutionId=?;");
        preparedStatement.setInt(1, institutionId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            studentModel.setId(resultSet.getInt(2));
            studentModel.setName(resultSet.getString(3));
            studentModel.setAddress(resultSet.getString(4));
            studentModel.setEmail(resultSet.getString(5));
            studentModel.setPhone(resultSet.getInt(6));
            students.add(studentModel);
        }
        return students;
    }

    public void reportInput(int studentId, String studentName, String institutionName, String report) {
        reportModel.setStudentId(studentId);
        reportModel.setStudentName(studentName);
        reportModel.setInstitutionName(institutionName);
        reportModel.setReport(report);
        add(reportModel);
        dOVMailboxModel.setSenderId(studentId);
        dOVMailboxModel.setSenderName(studentName);
        dOVMailboxModel.setTitle("A new institution report to a student who finished the volunteer work.");
        dOVMailboxModel.setBody("The student: " + studentName + " with the id: " + studentId + " who volunteered in: " + institutionName + " has successfully finished all the hours required.");
        dOVMailboxModel.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
        dOVMailboxModel.setTypeOfMail("finish vlounteer");
        sendToDOV(dOVMailboxModel);
    }

    public void add(Report newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.institutionreport(studentId, studentName, institutionName, report) values (?, ?, ?, ?)");
            statement.setInt(1, newObject.getStudentId());
            statement.setString(2, newObject.getStudentName());
            statement.setString(3, newObject.getInstitutionName());
            statement.setString(4, newObject.getReport());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sendToDOV(DOVMailbox newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into dovmailbox(senderId, senderName, title, body, date, approveOrDeny, typeOfMail) values (?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, newObject.getSenderId());
            statement.setString(2, newObject.getSenderName());
            statement.setString(3, newObject.getTitle());
            statement.setString(4, newObject.getBody());
            statement.setDate(5, new java.sql.Date(newObject.getDate().getTime()));
            statement.setBoolean(6, newObject.isApproveOrDeny());
            statement.setString(7, newObject.getTypeOfMail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void delete(int objectId) {
//        try {
//            PreparedStatement statement = connection.prepareStatement("delete from vws.institutionreport where id=?");
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
