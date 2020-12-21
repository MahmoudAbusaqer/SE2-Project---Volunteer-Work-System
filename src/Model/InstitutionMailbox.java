/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class InstitutionMailbox {

    private int id;
    private int senderId;
    private String senderName;
    private String title;
    private String body;
    private Date date;
    private boolean approveOrDeny;
    private String typeOfMail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isApproveOrDeny() {
        return approveOrDeny;
    }

    public void setApproveOrDeny(boolean approveOrDeny) {
        this.approveOrDeny = approveOrDeny;
    }

    public String getTypeOfMail() {
        return typeOfMail;
    }

    public void setTypeOfMail(String typeOfMail) {
        this.typeOfMail = typeOfMail;
    }

}
