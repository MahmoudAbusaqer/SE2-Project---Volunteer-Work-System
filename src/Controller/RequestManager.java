/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBConnection;
import Model.DOVMailbox;
import Model.District;
import Model.Institutions;
import Model.RequestVolunteer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mahmoud_Abusaqer
 */
//This class is only for the student to only request to volunteer, when the student chooses the institution and send the request, the request will go to the DOVMailbox.
public class RequestManager {

    private District districtModel;
    private Institutions institutionsModel;
    private RequestVolunteer requestVolunteerModel;
    private DOVMailbox dOVMailboxModel;
    private Connection connection;

//    public RequestManager() {
//        connection = DBConnection.getConnection();
//        this.districtModel = new District();
//        this.institutionsModel = new Institutions();
//        this.dOVMailboxModel = new DOVMailbox();
//    }
    public RequestManager(RequestVolunteer requestVolunteerModel) {
        this.requestVolunteerModel = requestVolunteerModel;
        connection = DBConnection.getConnection();
        this.districtModel = new District();
        this.institutionsModel = new Institutions();
        this.dOVMailboxModel = new DOVMailbox();
    }

//    public List<District> showDistrict() throws SQLException {
//        List<District> districts = new ArrayList<>();
//        PreparedStatement preparedStatement = connection.prepareStatement("select name from vws.district;");
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            District district = new District();
////            district.setId(resultSet.getInt(1));
//            district.setName(resultSet.getString(2));
////            district.setInstitutionsNumbers(resultSet.getInt(3));
//            districts.add(district);
//        }
//        return districts;
//    }
    public List<String> showDistrict() throws SQLException {
        List<String> districts = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select name from vws.district;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String districtName = new String();
            districtName = resultSet.getString(1);
            districts.add(districtName);
        }
        return districts;
    }

    public List<Institutions> showInstitutions(String district) throws SQLException {
        List<Institutions> institutionses = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from vws.institutions where district=?;");
        preparedStatement.setString(1, district);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Institutions institutions = new Institutions();
            institutions.setId(resultSet.getInt(1));
            institutions.setName(resultSet.getString(2));
            institutions.setAddress(resultSet.getString(3));
            institutions.setEmail(resultSet.getString(4));
            institutions.setPhone(resultSet.getInt(5));
            institutions.setDistrict(resultSet.getString(6));
            institutionses.add(institutions);
        }
        return institutionses;
    }

    public void requestVlounteer(int studentId, String studentName, int institutionId, String institutionName, String district, String address) {
        RequestVolunteer requestVolunteer = new RequestVolunteer();
        requestVolunteer.setStudentId(studentId);
        requestVolunteer.setStudentName(studentName);
        requestVolunteer.setInstitutionId(institutionId);
        requestVolunteer.setInstitutionName(institutionName);
        requestVolunteer.setDistrict(district);
        requestVolunteer.setAddress(address);
        add(requestVolunteer);
        DOVMailbox mailbox = new DOVMailbox();
        mailbox.setSenderId(studentId);
        mailbox.setSenderName(studentName);
        mailbox.setTitle("A new student request to volunteer.");
        mailbox.setBody("The student: " + studentName + " with the id: " + studentId + " wants to volunteer in: " + institutionName);
        mailbox.setDate(new java.sql.Timestamp(System.currentTimeMillis()));
        mailbox.setTypeOfMail("vlounteer");
        sendToDOV(mailbox);
    }

    public void add(RequestVolunteer newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.volunteerrequests(studentId, studentName, institutionId, institutionName, district, address) values (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, newObject.getStudentId());
            statement.setString(2, newObject.getStudentName());
            statement.setInt(3, newObject.getInstitutionId());
            statement.setString(4, newObject.getStudentName());
            statement.setString(5, newObject.getDistrict());
            statement.setString(6, newObject.getAddress());
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
//            PreparedStatement statement = connection.prepareStatement("delete from vws.volunteerrequests where id=?");
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
