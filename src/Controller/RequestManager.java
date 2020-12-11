/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RequestVolunteer;
import View.InstitutionsScreen;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class RequestManager {

    private RequestVolunteer model;
    private InstitutionsScreen view;

    public RequestManager(RequestVolunteer model) {
        this.model = model;
    }

    public void setView(InstitutionsScreen view) {
        this.view = view;
    }

    public void updateView(RequestVolunteer model) {

    }
}
