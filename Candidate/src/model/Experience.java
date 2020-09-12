/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pc
 */
public class Experience extends Candidate{
    private int expInYear;
    private String proSkill;

    public Experience() {
    }

    public Experience(int expInYear, String proSkill, String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int type) {
        super(id, firstName, lastName, birthDate, address, phone, email, type);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }


    public int getexpInYear() {
        return expInYear;
    }

    public void setexpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getproSkill() {
        return proSkill;
    }

    public void setproSkill(String proSkill) {
        this.proSkill = proSkill;
    }
    
    
}
