/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AddInstitutionsManager;
import Model.AddInstitutions;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class AddInstitutionsScreen {

    private AddInstitutions model;
    private AddInstitutionsManager controller;

    public AddInstitutionsScreen(AddInstitutions model) {
        this.model = model;
    }

    public void setController(AddInstitutionsManager controller) {
        this.controller = controller;
    }

    public void AddInstitutionInput(String name, String email, String distict, int phone, int district) {

    }
}
