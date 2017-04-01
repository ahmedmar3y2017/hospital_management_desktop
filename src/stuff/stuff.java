/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stuff;

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
public class stuff {

    public static Stage stage;
    Scene s;
    FXMLDocumentController c;
public  StuffController user;
public stuff(String id,String f_name,String l_name,String mobil,String email,String address,String specialization,String gender,String blood_group,String year,String month,String day) throws IOException{
    
    
        /*
          FXMLLoader load = new FXMLLoader();
        Parent p = load.load(getClass().getResource("FXMLDocument.fxml").openStream());
        FXMLDocumentController user = (FXMLDocumentController) load.getController();
        */
        
        c = new FXMLDocumentController();
        stage = new Stage();

        
        FXMLLoader load=new FXMLLoader();
        Parent p=load.load(getClass().getResource("stuff.fxml").openStream());
         user=(StuffController)load.getController();
         user.set_id(id);
        user.set_fname(f_name);
      user.set_lname(l_name);
        user.set_address(address);
        user.set_email(email);
        user.set_gender(gender);
        user.set_mobil(mobil);
        user.set_specialization(specialization);
        user.set_blood(blood_group);
        // date 
        user.set_day(day);
        user.set_month(month);
        user.set_year(year);
        
//        Parent p = FXMLLoader.load(getClass().getResource("stuff.fxml"));
        s = new Scene(p);
        stage.setScene(s);
        stage.setResizable(false);

//            stage.initOwner(c.button.getScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Stuff .... ! ");
        stage.show();
    
    
}
    public stuff() throws IOException {

        /*
          FXMLLoader load = new FXMLLoader();
        Parent p = load.load(getClass().getResource("FXMLDocument.fxml").openStream());
        FXMLDocumentController user = (FXMLDocumentController) load.getController();
        */
        
        c = new FXMLDocumentController();
        stage = new Stage();

        
        FXMLLoader load=new FXMLLoader();
        Parent p=load.load(getClass().getResource("stuff.fxml").openStream());
         user=(StuffController)load.getController();
//        user.set_fname("ahmed");
      
        
//        Parent p = FXMLLoader.load(getClass().getResource("stuff.fxml"));
        s = new Scene(p);
        stage.setScene(s);
        stage.setResizable(false);

//            stage.initOwner(c.button.getScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Stuff .... ! ");
        stage.show();
    }

}
