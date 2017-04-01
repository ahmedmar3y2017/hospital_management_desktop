package change_password;

import database.database;
import java.net.URL;
import java.sql.ResultSet;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Change_passwordController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    TextField username;
    @FXML
    PasswordField old_password;
    @FXML
    PasswordField new_password;
    @FXML
    PasswordField confirm;
    @FXML
    ComboBox specialization;

    @FXML
    Button ok;
    @FXML
    Button cancel;

    database data;

    ObservableList<String> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        specialization.setValue("");
//        specialization.setItems(list);

        try {
            data = new database();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Change_passwordController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Change_passwordController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // select specialization from database and do this into combobox to update username and password

            ResultSet res = data.select_user_spec();
            while (res.next()) {
                list.add(res.getString("specialization"));
                specialization.setItems(list);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Change_passwordController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void handle(ActionEvent event) {

        // action button ok
        if (event.getSource() == ok) {
            if (username.getText().equals("")
                    || old_password.getText().equals("")
                    || new_password.getText().equals("")
                    || confirm.getText().equals("")
                    || specialization.getSelectionModel().getSelectedItem().toString().equals("")) {

                if (username.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter username .....");

                } else if (specialization.getSelectionModel().getSelectedItem().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Select Specialization .....");

                } else if (old_password.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Old Password .....");

                } else if (new_password.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter new password .....");

                } else if (confirm.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Confirm password .....");

                }

            } else if (!confirm.getText().equals(new_password.getText())) {

                JOptionPane.showMessageDialog(null, "Error confirm password");

            } // update data inside component in database 
            else {

                // if the database connection is done
                if (data.re()) {

                    try {
                        String name = username.getText();
                        String spec = specialization.getSelectionModel().getSelectedItem().toString();
                        String old_pass = old_password.getText();
                        String new_pass = new_password.getText();
                        String con = confirm.getText();
                        // check first if the username and specialization found in database
                        if (data.check_to_user(name, spec)) {

                            // check if the password correct or wrong
                            if (data.check_user_complete(name, spec, old_pass)) {
                                data.update_user(name, spec, old_pass, con);
                                JOptionPane.showMessageDialog(null, "... Done ...");

                            } else {

                                JOptionPane.showMessageDialog(null, "Old pass is Error ....");

                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "This Employee not found");

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Change_passwordController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {

                }

            }

        } // action button cancel 
        else if (event.getSource() == cancel) {
            // close this stage 
            ((Stage) ok.getScene().getWindow()).close();
        }

    }

}
