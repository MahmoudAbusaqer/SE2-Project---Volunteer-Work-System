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
public class StatisticsInstitution {

    private int institutionId;
    private int institutionName;
    private int numberOfAllStudents;
    private int studentsFinishedNumbers;
    private int activeVolunteers;

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public int getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(int institutionName) {
        this.institutionName = institutionName;
    }

    public int getNumberOfAllStudents() {
        return numberOfAllStudents;
    }

    public void setNumberOfAllStudents(int numberOfAllStudents) {
        this.numberOfAllStudents = numberOfAllStudents;
    }

    public int getStudentsFinishedNumbers() {
        return studentsFinishedNumbers;
    }

    public void setStudentsFinishedNumbers(int studentsFinishedNumbers) {
        this.studentsFinishedNumbers = studentsFinishedNumbers;
    }

    public int getActiveVolunteers() {
        return activeVolunteers;
    }

    public void setActiveVolunteers(int activeVolunteers) {
        this.activeVolunteers = activeVolunteers;
    }

}
