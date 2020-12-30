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
import Model.volunteers;
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
            dOVMailbox.setId(resultSet.getInt(1));
            dOVMailbox.setSenderId(resultSet.getInt(2));
            dOVMailbox.setSenderName(resultSet.getString(3));
            dOVMailbox.setTitle(resultSet.getString(4));
            dOVMailbox.setBody(resultSet.getString(5));
            dOVMailbox.setDate(resultSet.getDate(6));
            dOVMailbox.setApproveOrDeny(resultSet.getBoolean(7));
            dOVMailbox.setTypeOfMail(resultSet.getString(8));
            dOVMailbox.setSendFor(resultSet.getInt(9));
            dOVMailboxs.add(dOVMailbox);
        }
        return dOVMailboxs;
    }

    //if the sender is a student the response should go to the student otherwise to the institutions
    public void mailResponse(int sendfor, int senderId, String senderName, String title, String body, Date date, boolean approveOrDeny, String typeOfMail, int mailId) {
        edit(mailId, approveOrDeny);
        if (typeOfMail != null) {
            switch (typeOfMail) {
                case "finish vlounteer":
                    mailResponseInstitution(sendfor, senderId, senderName, title, body, date, approveOrDeny, typeOfMail);
                    mailResponseStudent(sendfor, senderId, senderName, title, body, date, approveOrDeny, typeOfMail);
                    break;
                default:
                    mailResponseStudent(sendfor, senderId, senderName, title, body, date, approveOrDeny, typeOfMail);
            }
        }
    }

    public void mailResponseInstitution(int sendfor, int senderId, String senderName, String title, String body, Date date, boolean approveOrDeny, String typeOfMail) {
        InstitutionMailbox mailbox = new InstitutionMailbox();
        mailbox.setSendFor(sendfor);
        mailbox.setSenderId(senderId);
        mailbox.setSenderName(senderName);
        mailbox.setTitle(title);

        mailbox.setTypeOfMail(typeOfMail);
        mailbox.setDate(date);
        mailbox.setApproveOrDeny(approveOrDeny);
        if (approveOrDeny) {
            mailbox.setBody("Your request to " + typeOfMail + " was approved ☺ you can now continue.");
//                case "finish vlounteer"://need db trigger
        } else {
            mailbox.setBody("Your request to " + typeOfMail + " was denied 😢 try again and make sure you complete all the processes.");
            switch (typeOfMail) {
                case "finish vlounteer":
//                    deleteInstitutionReport();//need db trigger
                    break;
                default:

            }
        }
        addToInstitutions(mailbox);//to send the email to institution
    }

    public void mailResponseStudent(int sendfor, int senderId, String senderName, String title, String body, Date date, boolean approveOrDeny, String typeOfMail) {
        StudentMailbox mailbox = new StudentMailbox();
        mailbox.setSendFor(sendfor);
        mailbox.setSenderId(senderId);
        mailbox.setSenderName(senderName);
        mailbox.setTitle(title);
        if (approveOrDeny) {
            mailbox.setBody("Your request to " + typeOfMail + " was approved ☺ you can now continue.");
            //for all need a db triggers
        } else {
            mailbox.setBody("Your request to " + typeOfMail + " was denied 😢 try again.");
            switch (typeOfMail) {
                case "vlounteer":
//                    deleteVolunteer(sendfor);
                    break;
                case "suggest institution":
//                    deleteInstitution();//need db trigger
                    break;
                case "create initiative":
                    deleteInitiativ(senderId);
                    break;
                default:
                //alert
            }
        }
        mailbox.setTypeOfMail(typeOfMail);
        mailbox.setDate(date);
        mailbox.setApproveOrDeny(approveOrDeny);
        addToStudent(mailbox);//to send the email to student
    }

    public void addToStudent(StudentMailbox newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.studentmailbox(senderId, senderName, title, body, date, approveOrDeny, typeOfMail, sendfor) values (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, newObject.getSenderId());
            statement.setString(2, newObject.getSenderName());
            statement.setString(3, newObject.getTitle());
            statement.setString(4, newObject.getBody());
            statement.setDate(5, new java.sql.Date(newObject.getDate().getTime()));
            statement.setBoolean(6, newObject.isApproveOrDeny());
            statement.setString(7, newObject.getTypeOfMail());
            statement.setInt(8, newObject.getSendFor());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addToInstitutions(InstitutionMailbox newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.institutionmailbox(senderId, senderName, title, body, date, approveOrDeny, typeOfMail, sendfor) values (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, newObject.getSenderId());
            statement.setString(2, newObject.getSenderName());
            statement.setString(3, newObject.getTitle());
            statement.setString(4, newObject.getBody());
            statement.setDate(5, new java.sql.Date(newObject.getDate().getTime()));
            statement.setBoolean(6, newObject.isApproveOrDeny());
            statement.setString(7, newObject.getTypeOfMail());
            statement.setInt(8, newObject.getSendFor());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addToVolunteers(volunteers newObject) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into vws.volunteers(studentId, studentName, institutionId, institutionName, district, address) values (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, newObject.getId());
            statement.setString(2, newObject.getName());
            statement.setString(4, newObject.getAddress());
            statement.setString(5, newObject.getEmail());
            statement.setInt(6, newObject.getPhone());
            statement.setInt(7, newObject.getInstitutionId());
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

    public void deleteVolunteer(int objectId) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from vws.volunteers where studentId=?");
            statement.setInt(1, objectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteInstitution(int objectId) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from vws.institutions where id=?");
            statement.setInt(1, objectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteInitiativ(int objectId) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from vws.initiativesreqests where studentId=?");
            statement.setInt(1, objectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteInstitutionReport(int objectId) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from vws.institutionreport where studentId=?");
            statement.setInt(1, objectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(int objectId, boolean approveOrDeny) {
        try {
            PreparedStatement statement = connection.prepareStatement("update vws.dovmailbox set approveOrDeny=? where id=?");
            statement.setBoolean(1, approveOrDeny);
            statement.setInt(2, objectId);
            statement.executeUpdate();
//            System.out.println(statement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
