/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StatisticsDoV;
import View.StatisticsScreenDoV;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class StatisticManagerDoV {

    private StatisticsDoV model;
    private StatisticsScreenDoV view;

    public StatisticManagerDoV(StatisticsDoV model) {
        this.model = model;
    }

    public void setView(StatisticsScreenDoV view) {
        this.view = view;
    }

    public void updateView(StatisticsDoV model) {

    }
}
