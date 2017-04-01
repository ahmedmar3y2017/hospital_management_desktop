/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reciptionist;

import com.jfoenix.controls.JFXTextArea;
import database.database;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class ReciptionistController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField id;
    
    @FXML
    private TextField address;
    
    @FXML
    private TextField firstname;
    
    @FXML
    private TextField lastname;
    
    @FXML
    private TextField mobile;
    
    @FXML
    private TextField age;
    
    @FXML
    private TextField email;
    
    @FXML
    private ComboBox gender;
    
    @FXML
    private ComboBox blood;
    
    @FXML
    private JFXTextArea state;
    
    @FXML
    private Button delete;
    
    @FXML
    private Button add;
    
    @FXML
    private Button update;
    
    @FXML
    private Button search;
    
    @FXML
    private JFXTextArea fromdoc;
    
    @FXML
    private JFXTextArea fromacc;
    
    @FXML
    private TextField room_number;
    
    @FXML
    private ComboBox<?> room_type;
    
    @FXML
    private ComboBox<?> department;
    
    @FXML
    private ComboBox<?> year;
    
    @FXML
    private ComboBox<?> month;
    
    @FXML
    private ComboBox<?> day;
    
    @FXML
    private Button save;
    
    @FXML
    private Button get_data;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        gender.setItems(FXCollections.observableArrayList("male", "female"));
        blood.setItems(FXCollections.observableArrayList("a+", "b", "d", "c+"));
        
    }
    
    @FXML
    void action(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        if (event.getSource() == add) {
            
            if (id.getText().length() == 0 || firstname.getText().length() == 0 || lastname.getText().length() == 0 || mobile.getText().length() == 0 || age.getText().length() == 0 || email.getText().length() == 0 || address.getText().length() == 0 || gender.getSelectionModel().getSelectedItem().toString().length() == 0 || blood.getSelectionModel().toString().length() == 0 || state.getText().length() == 0) {
                
                JOptionPane.showMessageDialog(null, "Error Complete data");
                
            } else {
                
                database data = new database();
                
                if (data.select_pationt_id(Integer.parseInt(id.getText()))) {
                    
                    JOptionPane.showMessageDialog(null, "This id is Exist Please change it ");
                    
                } else {
                    //-------------------------------------insert into --------------------------------------------

                    if (data.insert_reciption_pationt(Integer.parseInt(id.getText()), firstname.getText(), lastname.getText(), Double.parseDouble(age.getText()), mobile.getText(), email.getText(), address.getText(), gender.getSelectionModel().getSelectedItem().toString(), blood.getSelectionModel().getSelectedItem().toString(), state.getText())) {
                        JOptionPane.showMessageDialog(null, "Done insert Reciption Doctor ....");
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Error in insert");
                        
                    }
                    
                }
                
            }
            
        }
        if (event.getSource() == update) {
            
            if (id.getText().length() == 0 || firstname.getText().length() == 0 || lastname.getText().length() == 0 || mobile.getText().length() == 0 || age.getText().length() == 0 || email.getText().length() == 0 || address.getText().length() == 0 || gender.getSelectionModel().getSelectedItem().toString().length() == 0 || blood.getSelectionModel().toString().length() == 0 || state.getText().length() == 0) {
                
                JOptionPane.showMessageDialog(null, "Error Complete data");
                
            } else {
                
                database data = new database();
                
                if (!data.select_pationt_id(Integer.parseInt(id.getText()))) {
                    
                    JOptionPane.showMessageDialog(null, "This id is Exist Please change it ");
                    
                } else {
                    //-------------------------------------insert into --------------------------------------------

                    if (data.update_reciption_pationt(Integer.parseInt(id.getText()), firstname.getText(), lastname.getText(), Double.parseDouble(age.getText()), mobile.getText(), email.getText(), address.getText(), gender.getSelectionModel().getSelectedItem().toString(), blood.getSelectionModel().getSelectedItem().toString(), state.getText())) {
                        JOptionPane.showMessageDialog(null, "Done update Reciption Doctor ....");
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Error in update");
                        
                    }
                    
                }
                
            }
            
        }
        if (event.getSource() == search) {
            if (id.getText().length() == 0) {
                
                JOptionPane.showMessageDialog(null, "Please Enter the Id");
            } else {
                database d = new database();
                
                if (d.select_pationt_id(Integer.parseInt(id.getText()))) {
                    
                    ResultSet r = d.select_all_patient(Integer.parseInt(id.getText()));
                    
                    if (r.next()) {
                        
                        firstname.setText("");
                        lastname.setText("");
                        age.setText("");
                        mobile.setText("");
                        email.setText("");
                        address.setText("");
                        gender.setValue("");
                        blood.setValue("");
                        state.setText("");
                        
                        firstname.setText(r.getString("f_name"));
                        lastname.setText(r.getString("l_name"));
                        age.setText(String.valueOf(r.getDouble("age")));
                        mobile.setText(r.getString("mobil"));
                        email.setText(r.getString("email"));
                        address.setText(r.getString("address"));
                        gender.setValue(r.getString("gender"));
                        blood.setValue(r.getString("blood_group"));
                        state.setText(r.getString("patient_state"));
                        
                    }
                    
                } else {
                    JOptionPane.showConfirmDialog(null, "Not Exist Patient");
                    
                }
            }
            
        }
        
        if (event.getSource() == delete) {
            
            if (id.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Enter the id please");
                
            } else {
                database d = new database();
                if (d.select_pationt_id(Integer.parseInt(id.getText()))) {
                    
                    d.delete_patient(Integer.parseInt(id.getText()));
                    
                    JOptionPane.showMessageDialog(null, "Done delete .....");
                    
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Patient not found .....");
                }
                
            }
        }
        
    }
    
}
