package stuff;

import com.sun.jmx.snmp.BerDecoder;
import database.database;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import stuff_info_table.table;

public class StuffController implements Initializable, EventHandler<MouseEvent> {

    @FXML
    TextField id;
    @FXML
    TextField f_name;
    @FXML
    TextField l_name;
    @FXML
    TextField mobil;
    @FXML
    TextField email;
    @FXML
    TextField address;
    @FXML
    ComboBox year;
    @FXML
    ComboBox month;
    @FXML
    ComboBox day;
    @FXML
    ChoiceBox specialization;
    @FXML
    ChoiceBox gender;
    @FXML
    ChoiceBox blood_group;
    @FXML
    Ellipse save;
    @FXML
    Ellipse update;
    @FXML
    Ellipse get;
    @FXML
    Ellipse delete;
    @FXML
    Ellipse nnew;

    @FXML
    Text s;
    @FXML
    Text u;

    @FXML
    Text g;

    @FXML
    Text d;

    @FXML
    Text n;
    database data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList l1 = FXCollections.observableArrayList();
        ObservableList l2 = FXCollections.observableArrayList();
        ObservableList l3 = FXCollections.observableArrayList();
        ObservableList l4 = FXCollections.observableArrayList("admin", "reciption", "doctor", "accountant", "nurse", "pharmasist", "xray", "lab");

        for (int i = 2015; i < 2026; i++) {
            l1.add(i);
        }
        for (int y = 1; y < 13; y++) {
            l2.add(y);

        }
        for (int u = 1; u < 32; u++) {
            l3.add(u);

        }
        year.getItems().addAll(l1);
        month.getItems().addAll(l2);
        day.getItems().addAll(l3);
        year.setValue("");
        month.setValue("");
        day.setValue("");
        specialization.setValue("");
        specialization.getItems().addAll(l4);
        gender.setValue("");
        gender.getItems().addAll("male", "female");
        blood_group.setValue("");
        blood_group.getItems().addAll("A+", "A-", "B+", "B-", "O+", "O-");
        f_name.setText("");
        l_name.setText("");
        mobil.setText("");
        email.setText("");
        address.setText("");
        id.setText("");

        try {
            data = new database();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // save button and s text mouse pressed
        save.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                save.setFill(Color.BLUE);

            }
        });
        s.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                save.setFill(Color.BLUE);

            }
        });
        // update button and s text mouse pressed
        update.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                update.setFill(Color.BLUE);

            }
        });
        u.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                update.setFill(Color.BLUE);

            }
        });
        // get button and s text mouse pressed
        get.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                get.setFill(Color.BLUE);

            }
        });
        g.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                get.setFill(Color.BLUE);

            }
        });
        // delete button and s text mouse pressed
        delete.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                delete.setFill(Color.BLUE);

            }
        });
        d.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                delete.setFill(Color.BLUE);

            }
        });
        // new button and s text mouse pressed
        nnew.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                nnew.setFill(Color.BLUE);

            }
        });
        n.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                nnew.setFill(Color.BLUE);

            }
        });
    }
    
    
// set data after click the table methode 
 
    
  public  void set_id(String iid) {
       id.setText(iid);
    }

    public void set_fname(String name) {

        f_name.setText(name);
    }
public void set_lname(String name){
    
    
    l_name.setText(name);
    
}
public void set_mobil(String name){
    
    
    mobil.setText(name);
    
}
public void set_email(String name){
    
    
    email.setText(name);
    
}
public void set_address(String name){
    
    
    address.setText(name);
    
}
public void set_specialization(String name){
    
    
    specialization.getSelectionModel().select(name);
    
}
public void set_blood(String name){
    
    
    blood_group.getSelectionModel().select(name);
    
}
public void set_day(String name){
    
    
    day.getSelectionModel().select(name);
    
}
public void set_month(String name){
    
    
    month.getSelectionModel().select(name);
    
}
public void set_gender(String name){
    
    
    gender.getSelectionModel().select(name);
    
}
public void set_year(String name){
    
    
    year.getSelectionModel().select(name);
    
}

    // eclipse click
    @Override
    public void handle(MouseEvent event) {

        // ACTION FOR save and text s
        if (event.getSource() == save || event.getSource() == s) {
            save.setFill(Color.GRAY);
            if (specialization.getSelectionModel().getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Select specialization ");

            } // check if the specialization = admin
            else if (specialization.getSelectionModel().getSelectedItem().toString().equals("admin")) {

                if (id.getText().equals("")
                        || f_name.getText().equals("")
                        || l_name.getText().equals("")
                        || mobil.getText().equals("")
                        || email.getText().equals("")
                        || address.getText().equals("")
                        || year.getSelectionModel().getSelectedItem().toString().equals("")
                        || month.getSelectionModel().getSelectedItem().toString().equals("")
                        || day.getSelectionModel().getSelectedItem().toString().equals("")
                        || gender.getSelectionModel().getSelectedItem().toString().equals("")
                        || blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {
                    if (id.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter id ... ");

                    } else if (f_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter f _ name");

                    } else if (l_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter l _ name");

                    } else if (mobil.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Mobile ");

                    } else if (email.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter email");

                    } else if (address.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter address");

                    } else if (year.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select year");

                    } else if (month.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select month");

                    } else if (day.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select day");

                    } else if (gender.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select gender");

                    } else if (blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select blood_group");

                    }

                } // check the id for admin page 
                else {

                    try {
                        if (data.check_id_admin(id.getText())) {
                            JOptionPane.showMessageDialog(null, "This member exist ..");

                        } else {

                            // insert into admin table in database 
                            GregorianCalendar v = new GregorianCalendar();

                            int m = Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());

                            v.set(Integer.parseInt(year.getSelectionModel().getSelectedItem().toString()),
                                    --m,
                                    Integer.parseInt(day.getSelectionModel().getSelectedItem().toString()));

                            java.util.Date date = v.getTime();
//                         date
                            Date dd = new Date(date.getTime());

//                            Date d = null;
                            data.insert_admin(Integer.parseInt(id.getText()), f_name.getText(), l_name.getText(), mobil.getText(), email.getText(), address.getText(), dd, specialization.getSelectionModel().getSelectedItem().toString(), gender.getSelectionModel().getSelectedItem().toString(), blood_group.getSelectionModel().getSelectedItem().toString());
                            System.out.println("Done ........................................");
                            reset();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } // check if the specialization is reciptionist 
            else if (specialization.getSelectionModel().getSelectedItem().toString().equals("reciption")) {

                if (id.getText().equals("")
                        || f_name.getText().equals("")
                        || l_name.getText().equals("")
                        || mobil.getText().equals("")
                        || email.getText().equals("")
                        || address.getText().equals("")
                        || year.getSelectionModel().getSelectedItem().toString().equals("")
                        || month.getSelectionModel().getSelectedItem().toString().equals("")
                        || day.getSelectionModel().getSelectedItem().toString().equals("")
                        || gender.getSelectionModel().getSelectedItem().toString().equals("")
                        || blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {
                    if (id.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter id ... ");

                    } else if (f_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter f _ name");

                    } else if (l_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter l _ name");

                    } else if (mobil.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Mobile ");

                    } else if (email.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter email");

                    } else if (address.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter address");

                    } else if (year.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select year");

                    } else if (month.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select month");

                    } else if (day.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select day");

                    } else if (gender.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select gender");

                    } else if (blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select blood_group");

                    }

                } else {

                    try {
                        // check id for reciptionist table 

                        if (data.check_id_reciption(id.getText())) {
                            JOptionPane.showMessageDialog(null, "This member exist ..");

                        } else {

                            // insert into admin table in database
                            GregorianCalendar v = new GregorianCalendar();

                            int m = Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());

                            v.set(Integer.parseInt(year.getSelectionModel().getSelectedItem().toString()),
                                    --m,
                                    Integer.parseInt(day.getSelectionModel().getSelectedItem().toString()));

                            java.util.Date date = v.getTime();
//                         date

                            Date dd = new Date(date.getTime());

                            //                            Date d = null;
                            data.insert_reciption(Integer.parseInt(id.getText()), f_name.getText(), l_name.getText(), mobil.getText(), email.getText(), address.getText(), dd, specialization.getSelectionModel().getSelectedItem().toString(), gender.getSelectionModel().getSelectedItem().toString(), blood_group.getSelectionModel().getSelectedItem().toString());

                            System.out.println("Done ........................................");
                            reset();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            } // check if the specialization is doctor 
            else if (specialization.getSelectionModel().getSelectedItem().toString().equals("doctor")) {
                if (id.getText().equals("")
                        || f_name.getText().equals("")
                        || l_name.getText().equals("")
                        || mobil.getText().equals("")
                        || email.getText().equals("")
                        || address.getText().equals("")
                        || year.getSelectionModel().getSelectedItem().toString().equals("")
                        || month.getSelectionModel().getSelectedItem().toString().equals("")
                        || day.getSelectionModel().getSelectedItem().toString().equals("")
                        || gender.getSelectionModel().getSelectedItem().toString().equals("")
                        || blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {
                    if (id.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter id ... ");

                    } else if (f_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter f _ name");

                    } else if (l_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter l _ name");

                    } else if (mobil.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Mobile ");

                    } else if (email.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter email");

                    } else if (address.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter address");

                    } else if (year.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select year");

                    } else if (month.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select month");

                    } else if (day.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select day");

                    } else if (gender.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select gender");

                    } else if (blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select blood_group");

                    }

                } else {

                    try {
                        // check id for doctor table 

                        if (data.check_id_doctor(id.getText())) {
                            JOptionPane.showMessageDialog(null, "This member exist ..");

                        } else {

                            // insert into doctor table in database
                            GregorianCalendar v = new GregorianCalendar();

                            int m = Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());

                            v.set(Integer.parseInt(year.getSelectionModel().getSelectedItem().toString()),
                                    --m,
                                    Integer.parseInt(day.getSelectionModel().getSelectedItem().toString()));

                            java.util.Date date = v.getTime();
//                         date

                            Date dd = new Date(date.getTime());

                            //                            Date d = null;
                            data.insert_doctor(Integer.parseInt(id.getText()), f_name.getText(), l_name.getText(), mobil.getText(), email.getText(), address.getText(), dd, specialization.getSelectionModel().getSelectedItem().toString(), gender.getSelectionModel().getSelectedItem().toString(), blood_group.getSelectionModel().getSelectedItem().toString());

                            System.out.println("Done ........................................");
                            reset();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            } // check if the specialization is accountant 
            else if (specialization.getSelectionModel().getSelectedItem().toString().equals("accountant")) {

                if (id.getText().equals("")
                        || f_name.getText().equals("")
                        || l_name.getText().equals("")
                        || mobil.getText().equals("")
                        || email.getText().equals("")
                        || address.getText().equals("")
                        || year.getSelectionModel().getSelectedItem().toString().equals("")
                        || month.getSelectionModel().getSelectedItem().toString().equals("")
                        || day.getSelectionModel().getSelectedItem().toString().equals("")
                        || gender.getSelectionModel().getSelectedItem().toString().equals("")
                        || blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {
                    if (id.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter id ... ");

                    } else if (f_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter f _ name");

                    } else if (l_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter l _ name");

                    } else if (mobil.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Mobile ");

                    } else if (email.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter email");

                    } else if (address.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter address");

                    } else if (year.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select year");

                    } else if (month.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select month");

                    } else if (day.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select day");

                    } else if (gender.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select gender");

                    } else if (blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select blood_group");

                    }

                } else {

                    try {
                        // check id for accountant table 

                        if (data.check_id_accountant(id.getText())) {
                            JOptionPane.showMessageDialog(null, "This member exist ..");

                        } else {

                            // insert into accountant table in database
                            GregorianCalendar v = new GregorianCalendar();

                            int m = Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());

                            v.set(Integer.parseInt(year.getSelectionModel().getSelectedItem().toString()),
                                    --m,
                                    Integer.parseInt(day.getSelectionModel().getSelectedItem().toString()));

                            java.util.Date date = v.getTime();
//                         date

                            Date dd = new Date(date.getTime());

                            //                            Date d = null;
                            data.insert_accountant(Integer.parseInt(id.getText()), f_name.getText(), l_name.getText(), mobil.getText(), email.getText(), address.getText(), dd, specialization.getSelectionModel().getSelectedItem().toString(), gender.getSelectionModel().getSelectedItem().toString(), blood_group.getSelectionModel().getSelectedItem().toString());

                            System.out.println("Done ........................................");
                            reset();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            } // check if the specialization is nurse 
            else if (specialization.getSelectionModel().getSelectedItem().toString().equals("nurse")) {

                if (id.getText().equals("")
                        || f_name.getText().equals("")
                        || l_name.getText().equals("")
                        || mobil.getText().equals("")
                        || email.getText().equals("")
                        || address.getText().equals("")
                        || year.getSelectionModel().getSelectedItem().toString().equals("")
                        || month.getSelectionModel().getSelectedItem().toString().equals("")
                        || day.getSelectionModel().getSelectedItem().toString().equals("")
                        || gender.getSelectionModel().getSelectedItem().toString().equals("")
                        || blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {
                    if (id.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter id ... ");

                    } else if (f_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter f _ name");

                    } else if (l_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter l _ name");

                    } else if (mobil.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Mobile ");

                    } else if (email.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter email");

                    } else if (address.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter address");

                    } else if (year.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select year");

                    } else if (month.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select month");

                    } else if (day.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select day");

                    } else if (gender.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select gender");

                    } else if (blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select blood_group");

                    }

                } else {

                    try {
                        // check id for nurse table 

                        if (data.check_id_nurse(id.getText())) {
                            JOptionPane.showMessageDialog(null, "This member exist ..");

                        } else {

                            // insert into nurse table in database
                            GregorianCalendar v = new GregorianCalendar();

                            int m = Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());

                            v.set(Integer.parseInt(year.getSelectionModel().getSelectedItem().toString()),
                                    --m,
                                    Integer.parseInt(day.getSelectionModel().getSelectedItem().toString()));

                            java.util.Date date = v.getTime();
//                         date

                            Date dd = new Date(date.getTime());

                            //                            Date d = null;
                            data.insert_nurse(Integer.parseInt(id.getText()), f_name.getText(), l_name.getText(), mobil.getText(), email.getText(), address.getText(), dd, specialization.getSelectionModel().getSelectedItem().toString(), gender.getSelectionModel().getSelectedItem().toString(), blood_group.getSelectionModel().getSelectedItem().toString());

                            System.out.println("Done ........................................");
                            reset();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            } // check if the specialization is pharmasist 
            else if (specialization.getSelectionModel().getSelectedItem().toString().equals("pharmasist")) {

                if (id.getText().equals("")
                        || f_name.getText().equals("")
                        || l_name.getText().equals("")
                        || mobil.getText().equals("")
                        || email.getText().equals("")
                        || address.getText().equals("")
                        || year.getSelectionModel().getSelectedItem().toString().equals("")
                        || month.getSelectionModel().getSelectedItem().toString().equals("")
                        || day.getSelectionModel().getSelectedItem().toString().equals("")
                        || gender.getSelectionModel().getSelectedItem().toString().equals("")
                        || blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {
                    if (id.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter id ... ");

                    } else if (f_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter f _ name");

                    } else if (l_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter l _ name");

                    } else if (mobil.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Mobile ");

                    } else if (email.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter email");

                    } else if (address.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter address");

                    } else if (year.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select year");

                    } else if (month.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select month");

                    } else if (day.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select day");

                    } else if (gender.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select gender");

                    } else if (blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select blood_group");

                    }

                } else {

                    try {
                        // check id for pharmasist table 

                        if (data.check_id_pharmasist(id.getText())) {
                            JOptionPane.showMessageDialog(null, "This member exist ..");

                        } else {

                            // insert into pharmasist table in database
                            GregorianCalendar v = new GregorianCalendar();

                            int m = Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());

                            v.set(Integer.parseInt(year.getSelectionModel().getSelectedItem().toString()),
                                    --m,
                                    Integer.parseInt(day.getSelectionModel().getSelectedItem().toString()));

                            java.util.Date date = v.getTime();
//                         date

                            Date dd = new Date(date.getTime());

                            //                            Date d = null;
                            data.insert_pharmasist(Integer.parseInt(id.getText()), f_name.getText(), l_name.getText(), mobil.getText(), email.getText(), address.getText(), dd, specialization.getSelectionModel().getSelectedItem().toString(), gender.getSelectionModel().getSelectedItem().toString(), blood_group.getSelectionModel().getSelectedItem().toString());

                            System.out.println("Done ........................................");
                            reset();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            } // check if the specialization is xray 
            else if (specialization.getSelectionModel().getSelectedItem().toString().equals("xray")) {

                if (id.getText().equals("")
                        || f_name.getText().equals("")
                        || l_name.getText().equals("")
                        || mobil.getText().equals("")
                        || email.getText().equals("")
                        || address.getText().equals("")
                        || year.getSelectionModel().getSelectedItem().toString().equals("")
                        || month.getSelectionModel().getSelectedItem().toString().equals("")
                        || day.getSelectionModel().getSelectedItem().toString().equals("")
                        || gender.getSelectionModel().getSelectedItem().toString().equals("")
                        || blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {
                    if (id.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter id ... ");

                    } else if (f_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter f _ name");

                    } else if (l_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter l _ name");

                    } else if (mobil.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Mobile ");

                    } else if (email.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter email");

                    } else if (address.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter address");

                    } else if (year.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select year");

                    } else if (month.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select month");

                    } else if (day.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select day");

                    } else if (gender.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select gender");

                    } else if (blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select blood_group");

                    }

                } else {

                    try {
                        // check id for xray table 

                        if (data.check_id_xray(id.getText())) {
                            JOptionPane.showMessageDialog(null, "This member exist ..");

                        } else {

                            // insert into xray table in database
                            GregorianCalendar v = new GregorianCalendar();

                            int m = Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());

                            v.set(Integer.parseInt(year.getSelectionModel().getSelectedItem().toString()),
                                    --m,
                                    Integer.parseInt(day.getSelectionModel().getSelectedItem().toString()));

                            java.util.Date date = v.getTime();
//                         date

                            Date dd = new Date(date.getTime());

                            //                            Date d = null;
                            data.insert_xray(Integer.parseInt(id.getText()), f_name.getText(), l_name.getText(), mobil.getText(), email.getText(), address.getText(), dd, specialization.getSelectionModel().getSelectedItem().toString(), gender.getSelectionModel().getSelectedItem().toString(), blood_group.getSelectionModel().getSelectedItem().toString());

                            System.out.println("Done ........................................");
                            reset();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            } // check if the specialization is lab 
            else if (specialization.getSelectionModel().getSelectedItem().toString().equals("lab")) {

                if (id.getText().equals("")
                        || f_name.getText().equals("")
                        || l_name.getText().equals("")
                        || mobil.getText().equals("")
                        || email.getText().equals("")
                        || address.getText().equals("")
                        || year.getSelectionModel().getSelectedItem().toString().equals("")
                        || month.getSelectionModel().getSelectedItem().toString().equals("")
                        || day.getSelectionModel().getSelectedItem().toString().equals("")
                        || gender.getSelectionModel().getSelectedItem().toString().equals("")
                        || blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {
                    if (id.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter id ... ");

                    } else if (f_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter f _ name");

                    } else if (l_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter l _ name");

                    } else if (mobil.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Mobile ");

                    } else if (email.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter email");

                    } else if (address.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter address");

                    } else if (year.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select year");

                    } else if (month.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select month");

                    } else if (day.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select day");

                    } else if (gender.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select gender");

                    } else if (blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select blood_group");

                    }

                } else {

                    try {
                        // check id for lab table 

                        if (data.check_id_lab(id.getText())) {
                            JOptionPane.showMessageDialog(null, "This member exist ..");

                        } else {

                            // insert into lab table in database
                            GregorianCalendar v = new GregorianCalendar();

                            int m = Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());

                            v.set(Integer.parseInt(year.getSelectionModel().getSelectedItem().toString()),
                                    --m,
                                    Integer.parseInt(day.getSelectionModel().getSelectedItem().toString()));

                            java.util.Date date = v.getTime();
//                         date

                            Date dd = new Date(date.getTime());

                            //                            Date d = null;
                            data.insert_lab(Integer.parseInt(id.getText()), f_name.getText(), l_name.getText(), mobil.getText(), email.getText(), address.getText(), dd, specialization.getSelectionModel().getSelectedItem().toString(), gender.getSelectionModel().getSelectedItem().toString(), blood_group.getSelectionModel().getSelectedItem().toString());

                            System.out.println("Done ........................................");
                            reset();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        } // if DElete circle and text d
        else if (event.getSource() == delete || event.getSource() == d) {
            delete.setFill(Color.GRAY);
// if id or specialization is empty (null)
            if (id.getText().equals("") || specialization.getSelectionModel().getSelectedItem().toString().equals("")) {
                if (id.getText().equals("")) {

                    JOptionPane.showMessageDialog(null, "Please Enter id .... ");

                } else if (specialization.getSelectionModel().getSelectedItem().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please select specialization .... ");

                }

            } // id id and specialization is entered 
            else {
                //  if specialization = admin
                if (specialization.getSelectionModel().getSelectedItem().toString().equals("admin")) {
                    try {
                        if (data.check_id_admin(id.getText())) {
                            int number = JOptionPane.showConfirmDialog(null, "Do you want to delete ?");
                            // if 0 this is button ok action 
                            if (number == 0) {

                                data.delete_admin(Integer.parseInt(id.getText()));
                                reset();

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Admin member not found ... ");

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } // if specialization = reciption
                else if (specialization.getSelectionModel().getSelectedItem().toString().equals("reciption")) {

                    try {
                        if (data.check_id_reciption(id.getText())) {
                            int number = JOptionPane.showConfirmDialog(null, "Do you want to delete ?");
                            // if 0 this is button ok action 
                            if (number == 0) {

                                data.delete_reciption(Integer.parseInt(id.getText()));
                                reset();

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "reciption member not found ... ");

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } //  if specialization = doctor
                else if (specialization.getSelectionModel().getSelectedItem().toString().equals("doctor")) {
                    try {
                        if (data.check_id_doctor(id.getText())) {
                            int number = JOptionPane.showConfirmDialog(null, "Do you want to delete ?");
                            // if 0 this is button ok action 
                            if (number == 0) {

                                data.delete_doctor(Integer.parseInt(id.getText()));
                                reset();

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "doctor member not found ... ");

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } //  if specialization = accountant
                else if (specialization.getSelectionModel().getSelectedItem().toString().equals("accountant")) {
                    try {
                        if (data.check_id_accountant(id.getText())) {
                            int number = JOptionPane.showConfirmDialog(null, "Do you want to delete ?");
                            // if 0 this is button ok action 
                            if (number == 0) {

                                data.delete_accountant(Integer.parseInt(id.getText()));
                                reset();

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "accountant member not found ... ");

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } //  if specialization = nurse
                else if (specialization.getSelectionModel().getSelectedItem().toString().equals("nurse")) {
                    try {
                        if (data.check_id_nurse(id.getText())) {
                            int number = JOptionPane.showConfirmDialog(null, "Do you want to delete ?");
                            // if 0 this is button ok action 
                            if (number == 0) {

                                data.delete_nurse(Integer.parseInt(id.getText()));
                                reset();

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "nurse member not found ... ");

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } //  if specialization = pharmasist
                else if (specialization.getSelectionModel().getSelectedItem().toString().equals("pharmasist")) {
                    try {
                        if (data.check_id_pharmasist(id.getText())) {
                            int number = JOptionPane.showConfirmDialog(null, "Do you want to delete ?");
                            // if 0 this is button ok action 
                            if (number == 0) {

                                data.delete_pharmasist(Integer.parseInt(id.getText()));
                                reset();

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "pharmasist member not found ... ");

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } //  if specialization = xray
                else if (specialization.getSelectionModel().getSelectedItem().toString().equals("xray")) {
                    try {
                        if (data.check_id_xray(id.getText())) {
                            int number = JOptionPane.showConfirmDialog(null, "Do you want to delete ?");
                            // if 0 this is button ok action 
                            if (number == 0) {

                                data.delete_xray(Integer.parseInt(id.getText()));
                                reset();

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "xray member not found ... ");

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } //  if specialization = lab
                else if (specialization.getSelectionModel().getSelectedItem().toString().equals("lab")) {
                    try {
                        if (data.check_id_lab(id.getText())) {
                            int number = JOptionPane.showConfirmDialog(null, "Do you want to delete ?");
                            // if 0 this is button ok action 
                            if (number == 0) {

                                data.delete_lab(Integer.parseInt(id.getText()));
                                reset();

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "lab member not found ... ");

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        } // if update circle and text u
        else if (event.getSource() == update || event.getSource() == u) {
            update.setFill(Color.GRAY);

            if (specialization.getSelectionModel().getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Select specialization ");

            } // check if the specialization = admin
            else if (specialization.getSelectionModel().getSelectedItem().toString().equals("admin")) {

                if (id.getText().equals("")
                        || f_name.getText().equals("")
                        || l_name.getText().equals("")
                        || mobil.getText().equals("")
                        || email.getText().equals("")
                        || address.getText().equals("")
                        || year.getSelectionModel().getSelectedItem().toString().equals("")
                        || month.getSelectionModel().getSelectedItem().toString().equals("")
                        || day.getSelectionModel().getSelectedItem().toString().equals("")
                        || gender.getSelectionModel().getSelectedItem().toString().equals("")
                        || blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {
                    if (id.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter id ... ");

                    } else if (f_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter f _ name");

                    } else if (l_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter l _ name");

                    } else if (mobil.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Mobile ");

                    } else if (email.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter email");

                    } else if (address.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter address");

                    } else if (year.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select year");

                    } else if (month.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select month");

                    } else if (day.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select day");

                    } else if (gender.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select gender");

                    } else if (blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select blood_group");

                    }

                } // check the id for admin page 
                else {

                    try {
                        if (!data.check_id_admin(id.getText())) {

                            JOptionPane.showMessageDialog(null, "The user admin not found ... ");

                        } else {
                            GregorianCalendar v = new GregorianCalendar();

                            int m = Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());

                            v.set(Integer.parseInt(year.getSelectionModel().getSelectedItem().toString()),
                                    --m,
                                    Integer.parseInt(day.getSelectionModel().getSelectedItem().toString()));

                            java.util.Date date = v.getTime();
//                         date

                            Date dd = new Date(date.getTime());

                            data.update_admin(Integer.parseInt(id.getText()), f_name.getText(), l_name.getText(), mobil.getText(), email.getText(), address.getText(), dd, specialization.getSelectionModel().getSelectedItem().toString(), gender.getSelectionModel().getSelectedItem().toString(), blood_group.getSelectionModel().getSelectedItem().toString());
                            System.out.println("Done .....................................");
                            reset();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            } else if (specialization.getSelectionModel().getSelectedItem().toString().equals("reciption")) {

                if (id.getText().equals("")
                        || f_name.getText().equals("")
                        || l_name.getText().equals("")
                        || mobil.getText().equals("")
                        || email.getText().equals("")
                        || address.getText().equals("")
                        || year.getSelectionModel().getSelectedItem().toString().equals("")
                        || month.getSelectionModel().getSelectedItem().toString().equals("")
                        || day.getSelectionModel().getSelectedItem().toString().equals("")
                        || gender.getSelectionModel().getSelectedItem().toString().equals("")
                        || blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {
                    if (id.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter id ... ");

                    } else if (f_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter f _ name");

                    } else if (l_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter l _ name");

                    } else if (mobil.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Mobile ");

                    } else if (email.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter email");

                    } else if (address.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter address");

                    } else if (year.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select year");

                    } else if (month.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select month");

                    } else if (day.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select day");

                    } else if (gender.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select gender");

                    } else if (blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select blood_group");

                    }

                } // check the id for admin page 
                else {

                    try {
                        if (!data.check_id_reciption(id.getText())) {

                            JOptionPane.showMessageDialog(null, "The user reciption not found ... ");

                        } else {
                            GregorianCalendar v = new GregorianCalendar();

                            int m = Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());

                            v.set(Integer.parseInt(year.getSelectionModel().getSelectedItem().toString()),
                                    --m,
                                    Integer.parseInt(day.getSelectionModel().getSelectedItem().toString()));

                            java.util.Date date = v.getTime();
//                         date

                            Date dd = new Date(date.getTime());

                            data.update_reciption(Integer.parseInt(id.getText()), f_name.getText(), l_name.getText(), mobil.getText(), email.getText(), address.getText(), dd, specialization.getSelectionModel().getSelectedItem().toString(), gender.getSelectionModel().getSelectedItem().toString(), blood_group.getSelectionModel().getSelectedItem().toString());
                            System.out.println("Done .....................................");
                            reset();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } else if (specialization.getSelectionModel().getSelectedItem().toString().equals("doctor")) {
                if (id.getText().equals("")
                        || f_name.getText().equals("")
                        || l_name.getText().equals("")
                        || mobil.getText().equals("")
                        || email.getText().equals("")
                        || address.getText().equals("")
                        || year.getSelectionModel().getSelectedItem().toString().equals("")
                        || month.getSelectionModel().getSelectedItem().toString().equals("")
                        || day.getSelectionModel().getSelectedItem().toString().equals("")
                        || gender.getSelectionModel().getSelectedItem().toString().equals("")
                        || blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {
                    if (id.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter id ... ");

                    } else if (f_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter f _ name");

                    } else if (l_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter l _ name");

                    } else if (mobil.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Mobile ");

                    } else if (email.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter email");

                    } else if (address.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter address");

                    } else if (year.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select year");

                    } else if (month.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select month");

                    } else if (day.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select day");

                    } else if (gender.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select gender");

                    } else if (blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select blood_group");

                    }

                } // check the id for admin page 
                else {

                    try {
                        if (!data.check_id_doctor(id.getText())) {

                            JOptionPane.showMessageDialog(null, "The user doctor not found ... ");

                        } else {
                            GregorianCalendar v = new GregorianCalendar();

                            int m = Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());

                            v.set(Integer.parseInt(year.getSelectionModel().getSelectedItem().toString()),
                                    --m,
                                    Integer.parseInt(day.getSelectionModel().getSelectedItem().toString()));

                            java.util.Date date = v.getTime();
//                         date

                            Date dd = new Date(date.getTime());

                            data.update_doctor(Integer.parseInt(id.getText()), f_name.getText(), l_name.getText(), mobil.getText(), email.getText(), address.getText(), dd, specialization.getSelectionModel().getSelectedItem().toString(), gender.getSelectionModel().getSelectedItem().toString(), blood_group.getSelectionModel().getSelectedItem().toString());
                            System.out.println("Done .....................................");
                            reset();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (specialization.getSelectionModel().getSelectedItem().toString().equals("accountant")) {
                if (id.getText().equals("")
                        || f_name.getText().equals("")
                        || l_name.getText().equals("")
                        || mobil.getText().equals("")
                        || email.getText().equals("")
                        || address.getText().equals("")
                        || year.getSelectionModel().getSelectedItem().toString().equals("")
                        || month.getSelectionModel().getSelectedItem().toString().equals("")
                        || day.getSelectionModel().getSelectedItem().toString().equals("")
                        || gender.getSelectionModel().getSelectedItem().toString().equals("")
                        || blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {
                    if (id.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter id ... ");

                    } else if (f_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter f _ name");

                    } else if (l_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter l _ name");

                    } else if (mobil.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Mobile ");

                    } else if (email.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter email");

                    } else if (address.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter address");

                    } else if (year.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select year");

                    } else if (month.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select month");

                    } else if (day.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select day");

                    } else if (gender.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select gender");

                    } else if (blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select blood_group");

                    }

                } // check the id for admin page 
                else {

                    try {
                        if (!data.check_id_accountant(id.getText())) {

                            JOptionPane.showMessageDialog(null, "The user accountant not found ... ");

                        } else {
                            GregorianCalendar v = new GregorianCalendar();

                            int m = Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());

                            v.set(Integer.parseInt(year.getSelectionModel().getSelectedItem().toString()),
                                    --m,
                                    Integer.parseInt(day.getSelectionModel().getSelectedItem().toString()));

                            java.util.Date date = v.getTime();
//                         date

                            Date dd = new Date(date.getTime());

                            data.update_accountant(Integer.parseInt(id.getText()), f_name.getText(), l_name.getText(), mobil.getText(), email.getText(), address.getText(), dd, specialization.getSelectionModel().getSelectedItem().toString(), gender.getSelectionModel().getSelectedItem().toString(), blood_group.getSelectionModel().getSelectedItem().toString());
                            System.out.println("Done .....................................");
                            reset();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } else if (specialization.getSelectionModel().getSelectedItem().toString().equals("nurse")) {
                if (id.getText().equals("")
                        || f_name.getText().equals("")
                        || l_name.getText().equals("")
                        || mobil.getText().equals("")
                        || email.getText().equals("")
                        || address.getText().equals("")
                        || year.getSelectionModel().getSelectedItem().toString().equals("")
                        || month.getSelectionModel().getSelectedItem().toString().equals("")
                        || day.getSelectionModel().getSelectedItem().toString().equals("")
                        || gender.getSelectionModel().getSelectedItem().toString().equals("")
                        || blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {
                    if (id.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter id ... ");

                    } else if (f_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter f _ name");

                    } else if (l_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter l _ name");

                    } else if (mobil.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Mobile ");

                    } else if (email.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter email");

                    } else if (address.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter address");

                    } else if (year.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select year");

                    } else if (month.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select month");

                    } else if (day.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select day");

                    } else if (gender.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select gender");

                    } else if (blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select blood_group");

                    }

                } // check the id for admin page 
                else {

                    try {
                        if (!data.check_id_nurse(id.getText())) {

                            JOptionPane.showMessageDialog(null, "The user nurse not found ... ");

                        } else {
                            GregorianCalendar v = new GregorianCalendar();

                            int m = Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());

                            v.set(Integer.parseInt(year.getSelectionModel().getSelectedItem().toString()),
                                    --m,
                                    Integer.parseInt(day.getSelectionModel().getSelectedItem().toString()));

                            java.util.Date date = v.getTime();
//                         date

                            Date dd = new Date(date.getTime());

                            data.update_nurse(Integer.parseInt(id.getText()), f_name.getText(), l_name.getText(), mobil.getText(), email.getText(), address.getText(), dd, specialization.getSelectionModel().getSelectedItem().toString(), gender.getSelectionModel().getSelectedItem().toString(), blood_group.getSelectionModel().getSelectedItem().toString());
                            System.out.println("Done .....................................");
                            reset();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (specialization.getSelectionModel().getSelectedItem().toString().equals("pharmasist")) {
                if (id.getText().equals("")
                        || f_name.getText().equals("")
                        || l_name.getText().equals("")
                        || mobil.getText().equals("")
                        || email.getText().equals("")
                        || address.getText().equals("")
                        || year.getSelectionModel().getSelectedItem().toString().equals("")
                        || month.getSelectionModel().getSelectedItem().toString().equals("")
                        || day.getSelectionModel().getSelectedItem().toString().equals("")
                        || gender.getSelectionModel().getSelectedItem().toString().equals("")
                        || blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {
                    if (id.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter id ... ");

                    } else if (f_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter f _ name");

                    } else if (l_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter l _ name");

                    } else if (mobil.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Mobile ");

                    } else if (email.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter email");

                    } else if (address.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter address");

                    } else if (year.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select year");

                    } else if (month.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select month");

                    } else if (day.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select day");

                    } else if (gender.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select gender");

                    } else if (blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select blood_group");

                    }

                } // check the id for admin page 
                else {

                    try {
                        if (!data.check_id_pharmasist(id.getText())) {

                            JOptionPane.showMessageDialog(null, "The user pharmasist not found ... ");

                        } else {
                            GregorianCalendar v = new GregorianCalendar();

                            int m = Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());

                            v.set(Integer.parseInt(year.getSelectionModel().getSelectedItem().toString()),
                                    --m,
                                    Integer.parseInt(day.getSelectionModel().getSelectedItem().toString()));

                            java.util.Date date = v.getTime();
//                         date

                            Date dd = new Date(date.getTime());

                            data.update_pharmasist(Integer.parseInt(id.getText()), f_name.getText(), l_name.getText(), mobil.getText(), email.getText(), address.getText(), dd, specialization.getSelectionModel().getSelectedItem().toString(), gender.getSelectionModel().getSelectedItem().toString(), blood_group.getSelectionModel().getSelectedItem().toString());
                            System.out.println("Done .....................................");
                            reset();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (specialization.getSelectionModel().getSelectedItem().toString().equals("xray")) {
                if (id.getText().equals("")
                        || f_name.getText().equals("")
                        || l_name.getText().equals("")
                        || mobil.getText().equals("")
                        || email.getText().equals("")
                        || address.getText().equals("")
                        || year.getSelectionModel().getSelectedItem().toString().equals("")
                        || month.getSelectionModel().getSelectedItem().toString().equals("")
                        || day.getSelectionModel().getSelectedItem().toString().equals("")
                        || gender.getSelectionModel().getSelectedItem().toString().equals("")
                        || blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {
                    if (id.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter id ... ");

                    } else if (f_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter f _ name");

                    } else if (l_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter l _ name");

                    } else if (mobil.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Mobile ");

                    } else if (email.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter email");

                    } else if (address.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter address");

                    } else if (year.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select year");

                    } else if (month.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select month");

                    } else if (day.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select day");

                    } else if (gender.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select gender");

                    } else if (blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select blood_group");

                    }

                } // check the id for admin page 
                else {

                    try {
                        if (!data.check_id_xray(id.getText())) {

                            JOptionPane.showMessageDialog(null, "The user xray not found ... ");

                        } else {
                            GregorianCalendar v = new GregorianCalendar();

                            int m = Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());

                            v.set(Integer.parseInt(year.getSelectionModel().getSelectedItem().toString()),
                                    --m,
                                    Integer.parseInt(day.getSelectionModel().getSelectedItem().toString()));

                            java.util.Date date = v.getTime();
//                         date

                            Date dd = new Date(date.getTime());

                            data.update_xray(Integer.parseInt(id.getText()), f_name.getText(), l_name.getText(), mobil.getText(), email.getText(), address.getText(), dd, specialization.getSelectionModel().getSelectedItem().toString(), gender.getSelectionModel().getSelectedItem().toString(), blood_group.getSelectionModel().getSelectedItem().toString());
                            System.out.println("Done .....................................");
                            reset();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (specialization.getSelectionModel().getSelectedItem().toString().equals("lab")) {
                if (id.getText().equals("")
                        || f_name.getText().equals("")
                        || l_name.getText().equals("")
                        || mobil.getText().equals("")
                        || email.getText().equals("")
                        || address.getText().equals("")
                        || year.getSelectionModel().getSelectedItem().toString().equals("")
                        || month.getSelectionModel().getSelectedItem().toString().equals("")
                        || day.getSelectionModel().getSelectedItem().toString().equals("")
                        || gender.getSelectionModel().getSelectedItem().toString().equals("")
                        || blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {
                    if (id.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter id ... ");

                    } else if (f_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter f _ name");

                    } else if (l_name.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter l _ name");

                    } else if (mobil.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Mobile ");

                    } else if (email.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter email");

                    } else if (address.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Enter address");

                    } else if (year.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select year");

                    } else if (month.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select month");

                    } else if (day.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select day");

                    } else if (gender.getSelectionModel().getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "select gender");

                    } else if (blood_group.getSelectionModel().getSelectedItem().toString().equals("")) {

                        JOptionPane.showMessageDialog(null, "select blood_group");

                    }

                } // check the id for admin page 
                else {

                    try {
                        if (!data.check_id_lab(id.getText())) {

                            JOptionPane.showMessageDialog(null, "The user lab not found ... ");

                        } else {
                            GregorianCalendar v = new GregorianCalendar();

                            int m = Integer.parseInt(month.getSelectionModel().getSelectedItem().toString());

                            v.set(Integer.parseInt(year.getSelectionModel().getSelectedItem().toString()),
                                    --m,
                                    Integer.parseInt(day.getSelectionModel().getSelectedItem().toString()));

                            java.util.Date date = v.getTime();
//                         date

                            Date dd = new Date(date.getTime());

                            data.update_lab(Integer.parseInt(id.getText()), f_name.getText(), l_name.getText(), mobil.getText(), email.getText(), address.getText(), dd, specialization.getSelectionModel().getSelectedItem().toString(), gender.getSelectionModel().getSelectedItem().toString(), blood_group.getSelectionModel().getSelectedItem().toString());
                            System.out.println("Done .....................................");
                            reset();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } // if new circle and text n
        else if (event.getSource() == nnew || event.getSource() == n) {

            reset();

        } // if get circle and text g
        else if (event.getSource() == get || event.getSource() == g) {
            get.setFill(Color.GRAY);

//           
            stuff.stage.close();
            try {
                //            another a=new another();
                new table();
            } catch (IOException ex) {
                Logger.getLogger(StuffController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void reset() {

        nnew.setFill(Color.GRAY);
        id.setText("");
        f_name.setText("");
        l_name.setText("");
        mobil.setText("");
        address.setText("");
        email.setText("");
        month.setValue("");
        day.setValue("");
        year.setValue("");
        gender.setValue("");
        blood_group.setValue("");
        specialization.setValue("");

    }

 
}
