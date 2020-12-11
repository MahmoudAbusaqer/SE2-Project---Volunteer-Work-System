/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.InstitutionMailbox;
import View.InstitutionMailboxScreen;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class InstitutionMailboxManager {

    private InstitutionMailbox model;
    private InstitutionMailboxScreen view;

    public InstitutionMailboxManager(InstitutionMailbox model) {
        this.model = model;
    }

    public void setView(InstitutionMailboxScreen view) {
        this.view = view;
    }

    public void updateView(InstitutionMailbox model) {

    }
}
