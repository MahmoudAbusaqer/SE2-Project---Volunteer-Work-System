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
public class ReportManager implements SendToDOV {

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
            Student Student = new Student();
            Student.setId(resultSet.getInt(2));
            Student.setName(resultSet.getString(3));
            Student.setFaculty(resultSet.getString(4));
            Student.setAddress(resultSet.getString(5));
            Student.setEmail(resultSet.getString(6));
            Student.setPhone(resultSet.getInt(7));
            students.add(Student);
        }
        return students;
    }

    public void reportInput(int studentId, String studentName, int institutionId, String report) {
        Report report1 = new Report();
        report1.setStudentId(studentId);
        report1.setStudentName(studentName);
        report1.setInstitutionId(institutionId);
        report1.setReport(report);
        add(report1);
        DOVMailbox dOVMailbox = new DOVMailbox();
        dOVMailbox.setSenderId(studentId);
        dOVMailbox.setSenderName(studentName);
        dOVMailbox.setTitle("A new finish report from an institution ");
        dOVMailbox.setBody("The student: " + studentName + " with the id: " + studentId + " who volunteered in institution: " + institutionId + " and here is the institution report: " + report + ".");
        dOVMailbox.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
        dOVMailbox.setTypeOfMail("finish vlounteer");
        sendToDOV(dOVMailbox);
    }

    public void add(Report newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.institutionreport(studentId, studentName, institutionId, report) values (?, ?, ?, ?)");
            statement.setInt(1, newObject.getStudentId());
            statement.setString(2, newObject.getStudentName());
            statement.setInt(3, newObject.getInstitutionId());
            statement.setString(4, newObject.getReport());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendToDOV(DOVMailbox newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into dovmailbox(senderId, senderName, title, body, date, approveOrDeny, typeOfMail, sendfor) values (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, newObject.getSenderId());
            statement.setString(2, newObject.getSenderName());
            statement.setString(3, newObject.getTitle());
            statement.setString(4, newObject.getBody());
            statement.setDate(5, new java.sql.Date(newObject.getDate().getTime()));
            statement.setBoolean(6, newObject.isApproveOrDeny());
            statement.setString(7, newObject.getTypeOfMail());
            statement.setInt(8, newObject.getSenderId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
