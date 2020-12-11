/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StudentMailbox;
import View.StudentMailboxScreen;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class StudentMailboxManager {

    private StudentMailbox model;
    private StudentMailboxScreen view;

    public StudentMailboxManager(StudentMailbox model) {
        this.model = model;
    }

    public void setView(StudentMailboxScreen view) {
        this.view = view;
    }

    public void updateView(StudentMailbox model) {

    }
}
