/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StatisticsInstitution;
import View.StatisticsScreenInstitution;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class StatisticManagerInstitution {

    private StatisticsInstitution model;
    private StatisticsScreenInstitution view;

    public StatisticManagerInstitution(StatisticsInstitution model) {
        this.model = model;
    }

    public void setView(StatisticsScreenInstitution view) {
        this.view = view;
    }

    public void updateView(StatisticsInstitution model) {

    }
}
