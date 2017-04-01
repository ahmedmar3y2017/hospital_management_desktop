package hospital_managment;

import accountant_patient.accountant_patient;
import change_password.change_password;
import doctor_pationt.doctor_pationt;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JComboBox;
import nurse_pationt.nurse_pationt;
import pharmacy_pationt.pharmacy_pationt;
import reciptionist.reciptionist;
import room.room;
import search_password.search_password;
import stuff.stuff;
import user.user;

public class FXMLDocumentController implements Initializable, EventHandler<ActionEvent> {

    //menus ides
    @FXML
    public Menu admin;
    @FXML
    public Menu recipitionist;
    @FXML
    public Menu doctor;
    @FXML
    public Menu nurse;
    @FXML
    public Menu pharmasist;
    @FXML
    public Menu xray;
    @FXML
    public Menu lab;
    @FXML
    public Menu accountant;
    @FXML
    public Menu about;

    // admin menu ids
    @FXML
    MenuItem user;
    @FXML
    MenuItem search_password;
    @FXML
    MenuItem change_password;
    @FXML
    MenuItem stuff;
    @FXML
    MenuItem room;
    // help menu ids
    @FXML
    MenuItem help;
    Button button;
    // reciptionist menu ids
    @FXML
    MenuItem reciption_patient;
    @FXML
    MenuItem reciption_changepassword;
    // coctor menu ids 
    @FXML
    MenuItem doctor_patient;
    @FXML
    MenuItem doctor_changepassword;
    // nurse menu ids
    @FXML
    MenuItem nurse_patient;
    @FXML
    MenuItem nurse_changepassword;
    // pharmssist menu ids 
    @FXML
    MenuItem pharmasist_patient;
    @FXML
    MenuItem pharmasist_changepassword;
    // xray menu ids 
    @FXML
    MenuItem xray_patient;
    @FXML
    MenuItem xray_changepassword;
//lab menu ids 
    @FXML
    MenuItem lab_patient;
    @FXML
    MenuItem lab_changepassword;
    // accountant menu ids
    @FXML
    MenuItem accountant_patient;
    @FXML
    MenuItem accountant_changepassword;
    @FXML
    private MenuBar menu;

    public FXMLDocumentController() {

        System.out.println("........................................ahmed.................................................");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//accountant=new Menu();
//        admin=new Menu();
//          admin.setDisable(true);admin_disable(true);

    }

    public void admin_disable(boolean t) {

        admin.setDisable(t);

    }

    public void reciptionist_disable(boolean t) {

        recipitionist.setDisable(t);

    }

    public void doctor_disable(boolean t) {

        doctor.setDisable(t);

    }

    public void nurse_disable(boolean t) {

        nurse.setDisable(t);

    }

    public void pharmasist_disable(boolean t) {

        pharmasist.setDisable(t);

    }

    public void xray_disable(boolean t) {

        xray.setDisable(t);

    }

    public void lab_disable(boolean t) {

        lab.setDisable(t);

    }

    public void accountant_disable(boolean t) {

        accountant.setDisable(t);

    }

    @Override
    @FXML
    public void handle(ActionEvent event) {
    //                                             action admin item 

        // user item
        if (event.getSource() == user) {

            try {
                user h = new user();
                System.out.println("open userframe ");

            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        // search_password item
        if (event.getSource() == search_password) {

            try {
                search_password s = new search_password();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        // change_password
        if (event.getSource() == change_password) {

            try {
                change_password c = new change_password();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // stuff item
        if (event.getSource() == stuff) {

            try {
                stuff ss = new stuff();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // room item
        if (event.getSource() == room) {

            try {
                room m = new room();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //                                        action reciption items

        // change password item 
        if (event.getSource() == reciption_changepassword) {
            try {
                change_password c = new change_password();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //                                         action doctor items 
        // change password item 
        if (event.getSource() == doctor_changepassword) {

            try {
                change_password c = new change_password();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        //                                          action nurse items
        // change password item 
        if (event.getSource() == nurse_changepassword) {
            try {
                change_password c = new change_password();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //                                          action pharmasist items
        // change password item 
        if (event.getSource() == pharmasist_changepassword) {
            try {
                change_password c = new change_password();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //                                action xray items
        // change password item 
        if (event.getSource() == xray_changepassword) {
            try {
                change_password c = new change_password();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //                                          action lab items
        // change password item 
        if (event.getSource() == lab_changepassword) {
            try {
                change_password c = new change_password();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //                                          action accountant items
        // change password item 
        if (event.getSource() == accountant_changepassword) {
            try {
                change_password c = new change_password();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (event.getSource() == reciption_patient) {
            try {
                reciptionist c = new reciptionist();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (event.getSource() == doctor_patient) {
            try {
                doctor_pationt c = new doctor_pationt();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
//            '10:30:00'
        }
        if (event.getSource() == nurse_patient) {
            try {
                nurse_pationt c = new nurse_pationt();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (event.getSource() == accountant_patient) {
            try {
                accountant_patient c = new accountant_patient();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (event.getSource() == pharmasist_patient) {
            try {
                pharmacy_pationt c = new pharmacy_pationt();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        //                                          action help items
        if (event.getSource() == help) {
            try {

                Stage stage;
                Scene s;
                FXMLDocumentController c;
                c = new FXMLDocumentController();
                stage = new Stage();

                Parent p = FXMLLoader.load(getClass().getResource("about.fxml"));
                s = new Scene(p);
                stage.setScene(s);
                stage.setResizable(false);
//            stage.initOwner(c.button.getScene().getWindow());
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("About  .... ! ");
                stage.showAndWait();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        // action button items inside help stage 
        if (event.getSource() == button) {
            System.out.println("Help");
            try {
                Desktop d = Desktop.getDesktop();

                d.browse(new URI(""));
            } catch (URISyntaxException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
