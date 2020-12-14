/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StatisticManagerDoV;
import Model.StatisticsDoV;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class StatisticsScreenDoV {

    private StatisticsDoV model;
    private StatisticManagerDoV controller;

    public StatisticsScreenDoV(StatisticsDoV model) {
        this.model = model;
    }

    public void setController(StatisticManagerDoV controller) {
        this.controller = controller;
    }

    public void showStatistics() {

    }
}
