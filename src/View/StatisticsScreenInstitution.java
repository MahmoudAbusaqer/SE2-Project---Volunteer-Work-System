/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StatisticManagerInstitution;
import Model.StatisticsInstitution;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public void showStatistics(int institutionId) throws SQLException {
        List<StatisticsInstitution> statisticsInstitutions = new ArrayList<>();
        statisticsInstitutions = controller.showStatistics(institutionId);
        int index = 0;
        while (!statisticsInstitutions.isEmpty()) {//I think this does not need while
            model = statisticsInstitutions.get(index);
            //here need to match every GUI field with the model.get
            statisticsInstitutions.remove(index);
            index++;
        }
    }
}
