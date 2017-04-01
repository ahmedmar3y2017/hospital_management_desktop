/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class login extends Application {

    
    static Stage s=new Stage();


    public static void main(String[] args) {
        
        
        launch(args);
        
     
        
    }

       
      @Override
    public void start(Stage stage) throws Exception {
        s=stage;
        
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        
  
       
        
        Scene scene = new Scene(root);
        
        
        s.setResizable(false);
        s.setScene(scene);
        s.setTitle("Login  ....");
        s.show();
    }
    
}
