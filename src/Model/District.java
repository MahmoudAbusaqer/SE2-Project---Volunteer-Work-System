/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class District {

    private int id;
    private String name;
    private int institutionsNumbers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInstitutionsNumbers() {
        return institutionsNumbers;
    }

    public void setInstitutionsNumbers(int institutionsNumbers) {
        this.institutionsNumbers = institutionsNumbers;
    }

}
