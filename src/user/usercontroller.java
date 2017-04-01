/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import database.database;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class usercontroller implements Initializable, EventHandler<ActionEvent> {

    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    PasswordField confirm;
    @FXML
    ComboBox box;
    @FXML
    Button save;
    @FXML
    Button nnew;
    @FXML
    Button cancel;
    @FXML
    Text text1;
    @FXML
    Text text2;

    database data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList l = FXCollections.observableArrayList("admin", "reciption", "doctor", "accountant", "nurse", "pharmasist", "xray", "lab");
        box.getItems().addAll(l);
        box.setValue("");

        try {
            // object from database
            data = new database();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(usercontroller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(usercontroller.class.getName()).log(Level.SEVERE, null, ex);
        }

        // when type a password short 
        password.setOnKeyReleased(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (password.getLength() < 5) {
                    text1.setFill(Color.RED);

                    text1.setText("short");

                } else {

                    text1.setText("");

                }

            }
        });
        confirm.setOnKeyReleased(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {

                if (password.getText().equals(confirm.getText())) {
                    text2.setFill(Color.BLUE);

                    text2.setText("Done");

                } else {
                    text2.setFill(Color.RED);

                    text2.setText("Error");

                }

            }
        });

    }

    // button action only 
    @Override
    public void handle(ActionEvent event) {

        // action button save 
        if (event.getSource() == save) {
            if (username.getText().equals("")
                    || password.getText().equals("")
                    || confirm.getText().equals("")
                    || box.getSelectionModel().getSelectedItem().toString().equals("")) {
                if (username.getText().equals("")) {

                    JOptionPane.showMessageDialog(null, "please Enter username ");

                } else if (password.getText().equals("")) {

                    JOptionPane.showMessageDialog(null, "please Enter password ");

                } else if (confirm.getText().equals("")) {

                    JOptionPane.showMessageDialog(null, "please Enter Confirm password ");

                } else if (box.getSelectionModel().getSelectedItem().toString().equals("")) {

                    JOptionPane.showMessageDialog(null, "please select specialization ");

                }

            } else if (!password.getText().equals(confirm.getText())) {

                JOptionPane.showMessageDialog(null, "This password doesnt confirm .....");

            }else if(password.getLength()<5){
             
                JOptionPane.showMessageDialog(null, "This password short < 5  ... ");
                
            }
                else {

                String name = username.getText();
                String apec = box.getSelectionModel().getSelectedItem().toString();
                String pss = confirm.getText();
                if (data.re()) {

                    try {
                        if (data.check_to_user(name, apec)) {
                            JOptionPane.showMessageDialog(null, "This username Exist \n Specialization :  " + apec);

                        } else {

                            data.insert_user(name, pss, apec);
                            System.out.println("Done insertion user  .......");
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(usercontroller.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        }
        // button nnew action 
        if (event.getSource() == nnew) {

            username.setText("");
            password.setText("");
            confirm.setText("");
            box.setPromptText("Choose ... ");

            box.setValue("");
        }
        // cancel button to close this stage 
        if (event.getSource() == cancel) {

            Stage s = (Stage) cancel.getScene().getWindow();
            s.close();

        }
    }

}
