/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.InstitutionMailboxManager;
import Model.InstitutionMailbox;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public void showMailbox() throws SQLException {
        List<InstitutionMailbox> institutionMailboxs = new ArrayList<>();
        institutionMailboxs = controller.showMailbox();
        int index = 0;
        while (!institutionMailboxs.isEmpty()) {
            model = institutionMailboxs.get(index);
            //here need to match every GUI field with the model.get
            institutionMailboxs.remove(index);
            index++;
        }
    }
}
