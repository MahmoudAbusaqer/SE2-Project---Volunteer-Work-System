/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.InstitutionMailboxManager;
import Model.InstitutionMailbox;
import java.util.Date;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class InstitutionMailboxScreen {

    private InstitutionMailbox model;
    private InstitutionMailboxManager controller;

    public InstitutionMailboxScreen(InstitutionMailbox model) {
        this.model = model;
    }

    public void setController(InstitutionMailboxManager controller) {
        this.controller = controller;
    }

    public void showMailbox(int senderId, String senderName, String title, String body, Date date, boolean approveOrDeny) {

    }
}
