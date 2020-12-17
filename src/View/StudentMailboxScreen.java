/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StudentMailboxManager;
import Model.StudentMailbox;
import java.util.Date;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class StudentMailboxScreen {

    private StudentMailbox model;
    private StudentMailboxManager controller;

    public StudentMailboxScreen(StudentMailbox model) {
        this.model = model;
    }

    public void setController(StudentMailboxManager controller) {
        this.controller = controller;
    }

    public void showMailbox() {
        controller.showMailbox();
    }
}
