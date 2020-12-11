/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RequestVolunteer;
import View.ViewNewVolunteersScreen;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class ViewNewVolunteersManager {

    private RequestVolunteer model;
    private ViewNewVolunteersScreen view;

    public ViewNewVolunteersManager(RequestVolunteer model) {
        this.model = model;
    }

    public void setView(ViewNewVolunteersScreen view) {
        this.view = view;
    }

    public void updateView(RequestVolunteer model) {

    }
}
