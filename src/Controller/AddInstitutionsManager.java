/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AddInstitutions;
import View.AddInstitutionsScreen;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class AddInstitutionsManager {

    private AddInstitutions model;
    private AddInstitutionsScreen view;

    public AddInstitutionsManager(AddInstitutions model) {
        this.model = model;
    }

    public void setView(AddInstitutionsScreen view) {
        this.view = view;
    }

    public void updateView(AddInstitutions model) {

    }
}
