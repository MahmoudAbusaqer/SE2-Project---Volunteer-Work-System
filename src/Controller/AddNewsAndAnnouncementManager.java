/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AddNewsAndAnnouncement;
import View.AddNewsAndAnnouncementScreen;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class AddNewsAndAnnouncementManager {

    private AddNewsAndAnnouncement model;
    private AddNewsAndAnnouncementScreen view;

    public AddNewsAndAnnouncementManager(AddNewsAndAnnouncement model) {
        this.model = model;
    }

    public void setView(AddNewsAndAnnouncementScreen view) {
        this.view = view;
    }

    public void updateView(AddNewsAndAnnouncement model) {

    }
}
