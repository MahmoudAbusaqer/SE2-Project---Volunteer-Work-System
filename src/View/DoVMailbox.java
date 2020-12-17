/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.dovMailboxManager;
import Model.DOVMailbox;
import java.util.Date;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class DoVMailbox {

    private DOVMailbox model;
    private dovMailboxManager controller;

    public DoVMailbox(DOVMailbox model) {
        this.model = model;
    }

    public void setController(dovMailboxManager controller) {
        this.controller = controller;
    }

    public void showMailbox() {
        controller.showMailbox();
    }

    public void mailResponse(int senderId, String senderName, String title, String body, Date date, boolean approveOrDeny) {
        controller.mailResponse(senderId, senderName, title, body, date, approveOrDeny);//need to be edit
    }
}
