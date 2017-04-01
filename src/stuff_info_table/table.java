/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stuff_info_table;

import hospital_managment.FXMLDocumentController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import stuff.StuffController;

/**
 *
 * @author ahmed
 */
public class table {
    
   public static Stage stage;
    Scene s;
    FXMLDocumentController c;
//TableviewController user;
    public table() throws IOException {

        /*
          FXMLLoader load = new FXMLLoader();
        Parent p = load.load(getClass().getResource("FXMLDocument.fxml").openStream());
        FXMLDocumentController user = (FXMLDocumentController) load.getController();
        */
        
        c = new FXMLDocumentController();
        stage = new Stage();

        
        FXMLLoader load=new FXMLLoader();
        Parent p=load.load(getClass().getResource("tableview.fxml").openStream());
        TableviewController user=(TableviewController)load.getController();
        
       
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
                try {
                    new stuff.stuff();
                } catch (IOException ex) {
                    Logger.getLogger(table.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });
//        Parent p = FXMLLoader.load(getClass().getResource("stuff.fxml"));
        s = new Scene(p);
        stage.setScene(s);
        stage.setResizable(false);

//            stage.initOwner(c.button.getScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Stuff search  .... ! ");
        stage.showAndWait();
    }
  
}
