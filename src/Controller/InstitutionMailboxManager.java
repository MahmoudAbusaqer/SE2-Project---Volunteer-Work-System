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
}
