/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stuff_info_table;

import database.database;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class TableviewController implements Initializable {

    @FXML
    TableView<employee> table;
    @FXML
    TableColumn<employee, String> f_name;
    @FXML
    TableColumn<employee, String> l_name;

    @FXML
    TableColumn<employee, String> mobil;

    @FXML
    TableColumn<employee, String> email;

    @FXML
    TableColumn<employee, String> address;

    @FXML
    TableColumn<employee, Date> date;
    @FXML
    TableColumn<employee, String> specialization;

    @FXML
    TableColumn<employee, String> gender;
    @FXML
    TableColumn<employee, String> blood;
    @FXML
    Button button;
    @FXML
    TextField text;
    @FXML
    ComboBox box;
    ObservableList<employee> list = FXCollections.observableArrayList( //           new employee("sdg", "zseg", "zseg", "wegsdv", "awegs", "awegsd", "awegs", "awegs", "awegs")
            );

    ObservableList<String> ll = FXCollections.observableArrayList("admin", "reciption", "doctor", "accountant", "nurse", "pharmasist", "xray", "lab");

    int id_table;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        box.setValue("");
        box.setPromptText("choose ...");
        box.setItems(ll);

        f_name.setCellValueFactory(new PropertyValueFactory<employee, String>("f_name"));
        l_name.setCellValueFactory(new PropertyValueFactory<employee, String>("l_name"));
        mobil.setCellValueFactory(new PropertyValueFactory<employee, String>("mobil"));
        email.setCellValueFactory(new PropertyValueFactory<employee, String>("email"));
        address.setCellValueFactory(new PropertyValueFactory<employee, String>("address"));
        date.setCellValueFactory(new PropertyValueFactory<employee, Date>("date"));
        specialization.setCellValueFactory(new PropertyValueFactory<employee, String>("specialization"));
        gender.setCellValueFactory(new PropertyValueFactory<employee, String>("gender"));
        blood.setCellValueFactory(new PropertyValueFactory<employee, String>("blood"));

        table.setItems(list);

    }

    public void mouse_action(MouseEvent event) throws ParseException {

        if (event.getSource() == table) {

            employee e = table.getSelectionModel().getSelectedItem();
            if(e==null){
                
                JOptionPane.showMessageDialog(null, "Please search first ");
                
            }
            else 
            {
            String fname = e.getF_name();
            String lname = e.getL_name();
            String add = e.getAddress();
            String Email = e.getEmail();
            String Gender = e.getGender();
            String Blood = e.getBlood();
            String Mobil = e.getMobil();
            String Special = e.getSpecialization();
            String Dat = e.getDate();
            java.util.Date dd =  new SimpleDateFormat("dd//MM//yyyy").parse(Dat);

            GregorianCalendar calender = new GregorianCalendar();
//            calender.setTimeInMillis(Long.parseLong(Dat));
            calender.setTime(dd);

            String day = String.valueOf(calender.get(Calendar.DAY_OF_WEEK_IN_MONTH));
            String month = String.valueOf(calender.get(Calendar.MONTH)+1);
            String year = String.valueOf(calender.get(Calendar.YEAR));

//            stuff.stuff.user.set_fname(fname);
//            System.out.println(fname);
            stuff_info_table.table.stage.close();

            try {
                new stuff.stuff(String.valueOf(id_table),fname, lname, Mobil, Email, add, Special, Gender, Blood,year,month,day);

            } catch (IOException ex) {
                Logger.getLogger(TableviewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }

    }

    public void search_action(ActionEvent e) {

        if (e.getSource() == button) {

            if (text.getText().equals("") || box.getSelectionModel().getSelectedItem().toString().equals("")) {

                if (text.getText().equals("")) {

                    JOptionPane.showMessageDialog(null, "Please enter id ....");

                } else if (box.getSelectionModel().getSelectedItem().toString().equals("")) {

                    JOptionPane.showMessageDialog(null, "Please select specialization ....");

                }

            } else {
                ResultSet res;
                if (box.getSelectionModel().getSelectedItem().toString().equals("admin")) {
                    try {
                        database data = new database();

                        if (data.re()) {

                            if (data.check_id_admin(text.getText())) {

                                res = data.select_admin(Integer.parseInt(text.getText()));

                                while (res.next()) {

                                    Date d = res.getDate("date_of_join");
id_table=res.getInt("id");

                                    String date = new SimpleDateFormat("dd//MM//yyyy").format(d);
                                    list.add(new employee(res.getString("f_name"), res.getString("l_name"), res.getString("mobil"), res.getString("email"), res.getString("address"), date, res.getString("specialization"), res.getString("gender"), res.getString("blood_group")));
                                    table.setItems(list);
                                }
                            } else {

                                JOptionPane.showMessageDialog(null, "The user not found");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Error database connection");
                        }
                    } catch (Exception  ex) {
                      ex.printStackTrace();
                    } 

                } else if (box.getSelectionModel().getSelectedItem().toString().equals("reciption")) {

                    try {
                        database data = new database();

                        if (data.re()) {

                            if (data.check_id_reciption(text.getText())) {

                                res = data.select_reciption(Integer.parseInt(text.getText()));
                                while (res.next()) {
id_table=res.getInt("id");
                                    Date d = res.getDate("date_of_join");
                                    String date = new SimpleDateFormat("dd//MM//yyyy").format(d);

                                    list.add(new employee(res.getString("f_name"), res.getString("l_name"), res.getString("mobil"), res.getString("email"), res.getString("address"), date, res.getString("specialization"), res.getString("gender"), res.getString("blood_group")));
                                    table.setItems(list);
                                }
//                                table.setModel(DbUtils.resultSetToTableModel(res));
                            } else {

                                JOptionPane.showMessageDialog(null, "The user not found");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Error database connection");
                        }
                    }  catch (Exception  ex) {
                      ex.printStackTrace();
                    } 
                } else if (box.getSelectionModel().getSelectedItem().toString().equals("doctor")) {
                    try {
                        database data = new database();

                        if (data.re()) {

                            if (data.check_id_doctor(text.getText())) {

                                res = data.select_doctor(Integer.parseInt(text.getText()));
                                while (res.next()) {
id_table=res.getInt("id");

                                    Date d = res.getDate("date_of_join");
                                    String date = new SimpleDateFormat("dd//MM//yyyy").format(d);

                                    list.add(new employee(res.getString("f_name"), res.getString("l_name"), res.getString("mobil"), res.getString("email"), res.getString("address"), date, res.getString("specialization"), res.getString("gender"), res.getString("blood_group")));
                                    table.setItems(list);
                                }
//                                table.setModel(DbUtils.resultSetToTableModel(res));
                            } else {

                                JOptionPane.showMessageDialog(null, "The user not found");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Error database connection");
                        }
                    } catch (Exception  ex) {
                      ex.printStackTrace();
                    } 

                } else if (box.getSelectionModel().getSelectedItem().toString().equals("accountant")) {
                    try {
                        database data = new database();

                        if (data.re()) {

                            if (data.check_id_accountant(text.getText())) {

                                res = data.select_accountant(Integer.parseInt(text.getText()));
                                while (res.next()) {
id_table=res.getInt("id");

                                    Date d = res.getDate("date_of_join");
                                    String date = new SimpleDateFormat("dd//MM//yyyy").format(d);

                                    list.add(new employee(res.getString("f_name"), res.getString("l_name"), res.getString("mobil"), res.getString("email"), res.getString("address"), date, res.getString("specialization"), res.getString("gender"), res.getString("blood_group")));
                                    table.setItems(list);
                                }
//                                table.setModel(DbUtils.resultSetToTableModel(res));
                            } else {

                                JOptionPane.showMessageDialog(null, "The user not found");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Error database connection");
                        }
                    } catch (Exception  ex) {
                      ex.printStackTrace();
                    } 

                } else if (box.getSelectionModel().getSelectedItem().toString().equals("nurse")) {
                    try {
                        database data = new database();

                        if (data.re()) {

                            if (data.check_id_nurse(text.getText())) {

                                res = data.select_nurse(Integer.parseInt(text.getText()));
                                while (res.next()) {
id_table=res.getInt("id");

                                    Date d = res.getDate("date_of_join");
                                    String date = new SimpleDateFormat("dd//MM//yyyy").format(d);

                                    list.add(new employee(res.getString("f_name"), res.getString("l_name"), res.getString("mobil"), res.getString("email"), res.getString("address"), date, res.getString("specialization"), res.getString("gender"), res.getString("blood_group")));
                                    table.setItems(list);
                                }
//                                table.setModel(DbUtils.resultSetToTableModel(res));
                            } else {

                                JOptionPane.showMessageDialog(null, "The user not found");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Error database connection");
                        }
                    } catch (Exception  ex) {
                      ex.printStackTrace();
                    } 

                } else if (box.getSelectionModel().getSelectedItem().toString().equals("pharmasist")) {

                    try {
                        database data = new database();

                        if (data.re()) {

                            if (data.check_id_pharmasist(text.getText())) {

                                res = data.select_pharmasist(Integer.parseInt(text.getText()));
                                while (res.next()) {
id_table=res.getInt("id");

                                    Date d = res.getDate("date_of_join");
                                    String date = new SimpleDateFormat("dd//MM//yyyy").format(d);

                                    list.add(new employee(res.getString("f_name"), res.getString("l_name"), res.getString("mobil"), res.getString("email"), res.getString("address"), date, res.getString("specialization"), res.getString("gender"), res.getString("blood_group")));
                                    table.setItems(list);
                                }
//                                table.setModel(DbUtils.resultSetToTableModel(res));
                            } else {

                                JOptionPane.showMessageDialog(null, "The user not found");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Error database connection");
                        }
                    } catch (Exception  ex) {
                      ex.printStackTrace();
                    } 

                } else if (box.getSelectionModel().getSelectedItem().toString().equals("xray")) {

                    try {
                        database data = new database();

                        if (data.re()) {

                            if (data.check_id_xray(text.getText())) {

                                res = data.select_xray(Integer.parseInt(text.getText()));
                                while (res.next()) {
id_table=res.getInt("id");

                                    Date d = res.getDate("date_of_join");
                                    String date = new SimpleDateFormat("dd//MM//yyyy").format(d);

                                    list.add(new employee(res.getString("f_name"), res.getString("l_name"), res.getString("mobil"), res.getString("email"), res.getString("address"), date, res.getString("specialization"), res.getString("gender"), res.getString("blood_group")));
                                    table.setItems(list);
                                }
//                                table.setModel(DbUtils.resultSetToTableModel(res));
                            } else {

                                JOptionPane.showMessageDialog(null, "The user not found");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Error database connection");
                        }
                    }  catch (Exception  ex) {
                      ex.printStackTrace();
                    } 

                } else if (box.getSelectionModel().getSelectedItem().toString().equals("lab")) {

                    try {
                        database data = new database();

                        if (data.re()) {

                            if (data.check_id_lab(text.getText())) {

                                res = data.select_lab(Integer.parseInt(text.getText()));
                                while (res.next()) {
id_table=res.getInt("id");

                                    Date d = res.getDate("date_of_join");
                                    String date = new SimpleDateFormat("dd//MM//yyyy").format(d);

                                    list.add(new employee(res.getString("f_name"), res.getString("l_name"), res.getString("mobil"), res.getString("email"), res.getString("address"), date, res.getString("specialization"), res.getString("gender"), res.getString("blood_group")));
                                    table.setItems(list);
                                }
//                                table.setModel(DbUtils.resultSetToTableModel(res));
                            } else {

                                JOptionPane.showMessageDialog(null, "The user not found");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Error database connection");
                        }
                    } catch (Exception  ex) {
                      ex.printStackTrace();
                    } 

                }
            }

        }

    }

}
