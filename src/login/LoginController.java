/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import database.database;
import hospital_managment.FXMLDocumentController;
import hospital_managment.Hospital_managment;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import user.usercontroller;

public class LoginController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Button ok;
    @FXML
    ComboBox box;
    @FXML
    Button cancel;
    database data;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
//        l=new login();
        ObservableList l = FXCollections.observableArrayList("admin", "reciption", "doctor", "accountant", "nurse", "pharmasist", "xray", "lab");
        box.setItems(l);
        box.setPromptText("Choose ... ");
        box.setValue("");
        try {
            data = new database();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void handle(ActionEvent event) {
        //----------------------------------------------------------------------------------------------
        // action button Ok that check the login user the system 
        if (event.getSource() == ok) {
            // if the data is empty
            if (username.getText().equals("")
                    || password.getText().equals("")
                    || box.getSelectionModel().getSelectedItem().toString().equals("")) {
                if (username.getText().equals("")) {
                    
                    JOptionPane.showMessageDialog(null, "please Enter username ");
                    
                } else if (password.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "please Enter  password ");
                    
                } else if (box.getSelectionModel().getSelectedItem().toString().equals("")) {
                    
                    JOptionPane.showMessageDialog(null, "please select specialization ");
                }
            } // if user ennter all information (data)
            else {
                String name = username.getText();
                String pass = password.getText();
                String spec = box.getSelectionModel().getSelectedItem().toString();
                try {
                    // check database connection  
                    if (data.re()) {
                        // check if username and password and specialization is true or not 
                        if (data.check_to_login(name, pass, spec)) {
                            login.s.close();
//                            System.out.println("Done user ..... " + spec);
//                            Thread.sleep(3000);
                            check_specialization(spec);

//                            Hospital_managment m = new Hospital_managment();
                        } // if user is error 
                        else {
                            
                            System.out.println("Error User ");
                            
                        }
                        // if database isnt connection 
                    } else {
                        
                        System.out.println("Database error ... ");
                    }

//                } catch (IOException ex) {
//                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        } // if cancel the login page 
        else if (event.getSource() == cancel) {
            
            System.exit(0);
            
        }
    }

    // methode to check specialization in combobox 
    public void check_specialization(String specialization) {
//        FXMLDocumentController c = new FXMLDocumentController();
        if (specialization.equals("admin")) {
          
            try {
                Hospital_managment h = new Hospital_managment(specialization);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
         
            
        } else if (specialization.equals("reciption")) {
            try {
                Hospital_managment h = new Hospital_managment(specialization);
                
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if (specialization.equals("doctor")) {
            try {
                Hospital_managment h=new Hospital_managment(specialization);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            
        } else if (specialization.equals("accountant")) {
            try {
                Hospital_managment h = new Hospital_managment(specialization);
                
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if (specialization.equals("nurse")) {
            try {
                Hospital_managment h = new Hospital_managment(specialization);
                
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if (specialization.equals("pharmasist")) {
            try {
                Hospital_managment h = new Hospital_managment(specialization);
                
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if (specialization.equals("xray")) {
            try {
                Hospital_managment h = new Hospital_managment(specialization);
                
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if (specialization.equals("lab")) {
            try {
                Hospital_managment h = new Hospital_managment(specialization);
                
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
