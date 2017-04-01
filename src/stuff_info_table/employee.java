/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stuff_info_table;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ahmed
 */
public class employee {

    private SimpleStringProperty f_name;
    private SimpleStringProperty l_name;
    private SimpleStringProperty mobil;
    private SimpleStringProperty email;
    private SimpleStringProperty address;
    private SimpleStringProperty date;
    private SimpleStringProperty specialization;
    private SimpleStringProperty gender;
    private SimpleStringProperty blood;

    public String getF_name() {
        return f_name.get();
    }

    public String getL_name() {
        return l_name.get();
    }

    public String getMobil() {
        return mobil.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getAddress() {
        return address.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getSpecialization() {
        return specialization.get();
    }

    public String getGender() {
        return gender.get();
    }

    public String getBlood() {
        return blood.get();
    }

    public employee(String f_name, String l_name, String mobil, String email, String address, String date, String specialization, String gender, String blood) {
        this.f_name = new SimpleStringProperty(f_name);
        this.l_name = new SimpleStringProperty(l_name);
        this.mobil = new SimpleStringProperty(mobil);
        this.email = new SimpleStringProperty(email);
        this.address = new SimpleStringProperty(address);
        this.date = new SimpleStringProperty(date);
        this.specialization = new SimpleStringProperty(specialization);
        this.gender = new SimpleStringProperty(gender);
        this.blood = new SimpleStringProperty(blood);
    }

}
