/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ViewNewVolunteersManager;
import Model.RequestVolunteer;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class ViewNewVolunteersScreen {

    private RequestVolunteer model;
    private ViewNewVolunteersManager controller;

    public ViewNewVolunteersScreen(RequestVolunteer model) {
        this.model = model;
    }

    public void setController(ViewNewVolunteersManager controller) {
        this.controller = controller;
    }

    public void showNewVolunteers() {
        controller.showNewVolunteers();
    }
}
