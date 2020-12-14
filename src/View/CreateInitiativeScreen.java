/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CreateInitiativeManager;
import Model.CreateInitiative;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class CreateInitiativeScreen {

    private CreateInitiative model;
    private CreateInitiativeManager controller;

    public CreateInitiativeScreen(CreateInitiative model) {
        this.model = model;
    }

    public void setController(CreateInitiativeManager controller) {
        this.controller = controller;
    }

    public void CreateInitiativeInput(int studentId, String name, String location, String description, int phone, int numberOfVolunteers) {

    }
}
