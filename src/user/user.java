/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import hospital_managment.FXMLDocumentController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ahmed
 */
public class user {

    Stage stage;
    Scene s;
    FXMLDocumentController c;

    public user() throws IOException {

        c = new FXMLDocumentController();
        stage = new Stage();

        Parent p = FXMLLoader.load(getClass().getResource("home.fxml"));
        s = new Scene(p);
        stage.setScene(s);
        stage.setResizable(false);

//            stage.initOwner(c.button.getScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("User .... ! ");
        stage.showAndWait();
    }

}
