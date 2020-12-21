/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AddInstitutions;
import Model.DBConnection;
import Model.DOVMailbox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mahmoud_Abusaqer
 */
//This class is only for the student to only suggest a new Institution to the system.
public class AddInstitutionsManager {

    private AddInstitutions addInstitutionsModel;
    private DOVMailbox dOVMailboxModel;
    private Connection connection;

    public AddInstitutionsManager(AddInstitutions addInstitutionsModel) {
        this.addInstitutionsModel = addInstitutionsModel;
        this.dOVMailboxModel = new DOVMailbox();
        connection = DBConnection.getConnection();
    }

    public void AddInstitutionInput(String name, String address, String email, int phone, String district) {
        addInstitutionsModel.setName(name);
        addInstitutionsModel.setAddress(address);
        addInstitutionsModel.setEmail(email);
        addInstitutionsModel.setPhone(phone);
        addInstitutionsModel.setDistrict(district);
        add(addInstitutionsModel);
        dOVMailboxModel.setSenderId(0000000/*need edit we shoulg get this when the studen log in*/);
        dOVMailboxModel.setSenderName("studentName"/*need edit we shoulg get this when the studen log in*/);
        dOVMailboxModel.setTitle("A new institution suggest from a student.");
        dOVMailboxModel.setBody("The student: " + /*need edit we shoulg get this when the studen log in*/ "" + " with the id: " + ""/*need edit we shoulg get this when the studen log in*/ + " has suggested a  institution with the name: " + name + " in the distict: " + district + " with phone number: " + phone + " and email: " + email);
        dOVMailboxModel.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
        dOVMailboxModel.setTypeOfMail("suggest institution");
        sendToDOV(dOVMailboxModel);
    }

    public void add(AddInstitutions newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.proposedinstitutions(name, address, email, phone, district) values (?,?,?,?,?)");
            statement.setString(1, newObject.getName());
            statement.setString(2, newObject.getAddress());
            statement.setString(3, newObject.getEmail());
            statement.setInt(4, newObject.getPhone());
            statement.setString(5, newObject.getDistrict());
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
//            PreparedStatement statement = connection.prepareStatement("delete from vws.proposedinstitutions where id=?");
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
