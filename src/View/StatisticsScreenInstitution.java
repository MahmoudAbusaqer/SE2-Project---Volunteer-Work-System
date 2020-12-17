/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StatisticManagerInstitution;
import Model.StatisticsInstitution;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class StatisticsScreenInstitution {

    private StatisticsInstitution model;
    private StatisticManagerInstitution controller;

    public StatisticsScreenInstitution(StatisticsInstitution model) {
        this.model = model;
    }

    public void setController(StatisticManagerInstitution controller) {
        this.controller = controller;
    }

    public void showStatistics() {
        controller.showStatistics();
    }
}
