/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.RequestManager;
import Model.RequestVolunteer;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class InstitutionsScreen {

    private RequestVolunteer model;
    private RequestManager controller;

    public InstitutionsScreen(RequestVolunteer model) {
        this.model = model;
    }

    public void setController(RequestManager controller) {
        this.controller = controller;
    }

    public void showInstitutions(String name, String email, String address, int phone) {

    }

    public void requestVlounteer(int studentId, String studentName, int institutionId, String institutionName) {

    }
}
