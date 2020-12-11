/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.District;
import View.DistrictScreen;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class DistrictManager {

    private District model;
    private DistrictScreen view;

    public DistrictManager(District model) {
        this.model = model;
    }

    public void setView(DistrictScreen view) {
        this.view = view;
    }

    public void updateView(District model) {

    }
}
