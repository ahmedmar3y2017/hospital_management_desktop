/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy_pationt;

import com.jfoenix.controls.JFXTextArea;
import database.database;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
public class Pharmacy_pationtController implements Initializable {

    @FXML
    private TextField id;

    @FXML
    private TextField disease;

    @FXML
    private TextField name;

    @FXML
    private ComboBox to;

    @FXML
    private Button show1;

    @FXML
    private Button newbutton;

    @FXML
    private Button sendmessage;

    @FXML
    private Button getdata;

    @FXML
    private JFXTextArea area1;

    @FXML
    private ComboBox from;

    @FXML
    private Button show2;

    @FXML
    private JFXTextArea area2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void action(ActionEvent event) throws ClassNotFoundException, SQLException {

        if (event.getSource() == getdata) {

            if (id.getText().length() == 0) {

                JOptionPane.showMessageDialog(null, "Error Enter ID please .......");
            } else {

                int iid = Integer.parseInt(id.getText());
                String nname = name.getText();
                String ddisease = disease.getText();

                database d = new database();

                if (d.select_pationt_id(iid)) {

                    ResultSet resultSet = d.select_all_patient(iid);
                    if (resultSet.next()) {

                        name.setText(resultSet.getString("f_name") + " " + resultSet.getString("l_name"));

                        disease.setText(resultSet.getString("disease"));
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Error this pationt not exist .....");
                }

            }

        }

    }

}
