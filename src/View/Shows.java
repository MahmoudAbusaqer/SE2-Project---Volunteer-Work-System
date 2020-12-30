/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.sql.SQLException;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public interface Shows {

    void showMailbox(int id) throws SQLException;

    void showNewVolunteers(int institutionId) throws SQLException;
}
