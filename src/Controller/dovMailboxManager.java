/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DOVMailbox;
import View.DoVMailbox;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class dovMailboxManager {

    private DOVMailbox model;
    private DoVMailbox view;

    public dovMailboxManager(DOVMailbox model) {
        this.model = model;
    }

    public void setView(DoVMailbox view) {
        this.view = view;
    }

    public void updateView(DOVMailbox model) {

    }
}
