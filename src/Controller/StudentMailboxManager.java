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
import java.util.List;

/**
 *
 * @author Mahmoud_Abusaqer
 */
//This class is only for the Students to see their mailbox and if they have new mail from the DOV.
public class StudentMailboxManager {

    private StudentMailbox model;
    private Connection connection;

    public StudentMailboxManager(StudentMailbox model) {
        this.model = model;
        connection = DBConnection.getConnection();
    }

    public List<StudentMailbox> showMailbox(int id) throws SQLException {
        List<StudentMailbox> studentMailboxs = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from vws.studentmailbox where sendfor=? or sendfor=0;");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            StudentMailbox mailbox = new StudentMailbox();
            mailbox.setSenderId(resultSet.getInt(2));
            mailbox.setSenderName(resultSet.getString(3));
            mailbox.setTitle(resultSet.getString(4));
            mailbox.setBody(resultSet.getString(5));
            mailbox.setDate(resultSet.getDate(6));
            mailbox.setApproveOrDeny(resultSet.getBoolean(7));
            studentMailboxs.add(mailbox);
        }
        return studentMailboxs;
    }
}
