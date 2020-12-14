/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ReportManager;
import Model.Report;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class ReportScreen {

    private Report model;
    private ReportManager controller;

    public ReportScreen(Report model) {
        this.model = model;
    }

    public void setController(ReportManager controller) {
        this.controller = controller;
    }

    public void showReport() {

    }

    public void reportInput(int studentId, String studentName, String institutionName, String report) {

    }
}
