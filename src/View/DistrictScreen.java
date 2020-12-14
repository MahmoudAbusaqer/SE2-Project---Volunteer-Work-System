/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DistrictManager;
import Model.District;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class DistrictScreen {

    private District model;
    private DistrictManager controller;

    public DistrictScreen(District model) {
        this.model = model;
    }

    public void setController(DistrictManager controller) {
        this.controller = controller;
    }

    public void showDistrict() {

    }

    public void districtChose(String district) {

    }
}
