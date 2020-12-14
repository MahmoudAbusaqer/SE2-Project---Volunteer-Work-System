/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AddNewsAndAnnouncementManager;
import Model.AddNewsAndAnnouncement;
import java.util.Date;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class AddNewsAndAnnouncementScreen {

    private AddNewsAndAnnouncement model;
    private AddNewsAndAnnouncementManager controller;

    public AddNewsAndAnnouncementScreen(AddNewsAndAnnouncement model) {
        this.model = model;
    }

    public void setController(AddNewsAndAnnouncementManager controller) {
        this.controller = controller;
    }

    public void AddNewsAndAnnouncement(int nOr, String title, String body, Date date) {

    }
}
