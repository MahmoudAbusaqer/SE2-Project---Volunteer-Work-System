/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Report;
import View.ReportScreen;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class ReportManager {

    private Report model;
    private ReportScreen view;

    public ReportManager(Report model) {
        this.model = model;
    }

    public void setView(ReportScreen view) {
        this.view = view;
    }

    public void updateView(Report model) {

    }
}
