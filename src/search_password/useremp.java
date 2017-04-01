/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search_password;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ahmed
 */
public class useremp {

    SimpleStringProperty username;
    SimpleStringProperty password;
    SimpleStringProperty specialization;
    public useremp(String username, String password, String specialization) {
        this.username = new SimpleStringProperty(username);
        this.specialization = new SimpleStringProperty(specialization);
        this.password = new SimpleStringProperty(password);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(SimpleStringProperty username) {
        this.username = username;
    }

    public String getSpecialization() {
        return specialization.get();
    }

    public void setSpecialization(SimpleStringProperty specialization) {
        this.specialization = specialization;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(SimpleStringProperty password) {
        this.password = password;
    }

}
