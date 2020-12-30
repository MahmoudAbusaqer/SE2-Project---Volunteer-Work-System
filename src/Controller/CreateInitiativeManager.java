/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CreateInitiative;
import Model.DBConnection;
import Model.DOVMailbox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mahmoud_Abusaqer
 */
//This class is only for the student to only suggest a new Initiative to the system.
public class CreateInitiativeManager {

    private CreateInitiative createInitiativeModel;
    private DOVMailbox dOVMailboxModel;
    private Connection connection;

    public CreateInitiativeManager(CreateInitiative createInitiativeModel) {
        this.createInitiativeModel = createInitiativeModel;
        this.dOVMailboxModel = new DOVMailbox();
        connection = DBConnection.getConnection();
    }

    public void CreateInitiativeInput(int studentId, String name, String location, String description, int numberOfVolunteers, int phone, String studentName) {
        CreateInitiative createInitiative = new CreateInitiative();
        createInitiative.setStudentId(studentId);
        createInitiative.setName(name);
        createInitiative.setLocation(location);
        createInitiative.setDescription(description);
        createInitiative.setPhone(phone);
        createInitiative.setNumberOfVolunteers(numberOfVolunteers);
        add(createInitiative);
        DOVMailbox dOVMailbox = new DOVMailbox();
        dOVMailbox.setSenderId(studentId);
        dOVMailbox.setSenderName(studentName);
        dOVMailbox.setTitle("A new institution suggest from a student.");
        dOVMailbox.setBody("The student: " + studentName + " with the id: " + studentId + " has suggested to create a new Initiative with the "
                + "name: " + name + " in the location: " + location + " with student phone number: " + phone + " and the initiative description: " + description);
        dOVMailbox.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
        dOVMailbox.setTypeOfMail("create initiative");
        sendToDOV(dOVMailbox);
    }

    public void add(CreateInitiative newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.initiativesreqests(name, location, numberOfVolunteers, studentId, description, phone) values (?, ?, ?, ?, ?, ?)");
            statement.setString(1, newObject.getName());
            statement.setString(2, newObject.getLocation());
            statement.setInt(3, newObject.getNumberOfVolunteers());
            statement.setInt(4, newObject.getStudentId());
            statement.setString(5, newObject.getDescription());
            statement.setInt(6, newObject.getPhone());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
