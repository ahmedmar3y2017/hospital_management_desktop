package search_password;

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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import stuff_info_table.employee;

public class Search_passwordController implements Initializable {
    
    @FXML
    Button search;
    @FXML
    TextField username;
    @FXML
    ComboBox box;
    // table and his column 

    @FXML
    TableView<useremp> table;
    @FXML
    TableColumn<useremp, String> user;
    @FXML
    TableColumn<useremp, String> pass;
    
    @FXML
    TableColumn<useremp, String> specialization;
    
    ObservableList<useremp> list = FXCollections.observableArrayList();
    ObservableList<String> combolist = FXCollections.observableArrayList(
            "admin", "reciption", "doctor", "accountant", "nurse", "pharmasist", "xray", "lab"
    );
    
    database data;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            data = new database();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Search_passwordController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Search_passwordController.class.getName()).log(Level.SEVERE, null, ex);
        }
        box.setItems(combolist);
        box.setValue("");
        user.setCellValueFactory(new PropertyValueFactory<useremp, String>("username"));
        pass.setCellValueFactory(new PropertyValueFactory<useremp, String>("password"));
        specialization.setCellValueFactory(new PropertyValueFactory<useremp, String>("specialization"));
        
        table.setItems(list);
    }
    
    public void action_button(ActionEvent a) throws SQLException {
        if (a.getSource() == search) {
            
            if (username.getText().equals("") || box.getSelectionModel().getSelectedItem().equals("")) {
                if (username.getText().equals("")) {
                    
                    JOptionPane.showMessageDialog(null, "Please Enter the username");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Please Select specialization");
                    
                }
                
            } // do operation search 
            else {
                
                String name = username.getText();
                String spec = box.getSelectionModel().getSelectedItem().toString();
                
                if (data.re()) {
                    if (data.check_to_user(name, spec)) {
                        
                        ResultSet res = data.select_user(name, spec);
                        while (res.next()) {
                            
                            String n = res.getString("username");
                            String p = res.getString("password");
                            String s = res.getString("specialization");
                            
//                           Time t= res.getTime("");
                            
                            
                            useremp u = new useremp(n, p, s);
                            list.add(u);
                            table.setItems(list);
                            
                        }
                        
                    } else {
                        
                        JOptionPane.showMessageDialog(null, "Not found employee ....");
                        
                    }
                    
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Error database connection ....");
                }
                
            }
            
        }
        
    }
    
}
