/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CreateInitiative;
import View.CreateInitiativeScreen;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class CreateInitiativeManager {

    private CreateInitiative model;
    private CreateInitiativeScreen view;

    public CreateInitiativeManager(CreateInitiative model) {
        this.model = model;
    }

    public void setView(CreateInitiativeScreen view) {
        this.view = view;
    }

    public void updateView(CreateInitiative model) {

    }
}
