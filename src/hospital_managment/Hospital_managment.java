package hospital_managment;

import database.database;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import user.usercontroller;

public class Hospital_managment {

    Stage stage;
    Scene s;
//    FXMLDocumentController c;
//    FXMLDocumentController c;
    String nname;

    public Hospital_managment(String name) throws IOException {
        nname = name;
//        c = new FXMLDocumentController();
        stage = new Stage();
        FXMLLoader load = new FXMLLoader();
        Parent p = load.load(getClass().getResource("FXMLDocument.fxml").openStream());
        FXMLDocumentController user = (FXMLDocumentController) load.getController();
        // test thw specialization to active the menues 
        if (name.equals("doctor")) {
            user.admin_disable(true);
            user.nurse_disable(true);
            user.accountant_disable(true);
            user.lab_disable(true);
            user.pharmasist_disable(true);

            user.xray_disable(true);
            user.reciptionist_disable(true);
        } else if (name.equals("admin")) {
            user.doctor_disable(true);
            user.nurse_disable(true);
            user.accountant_disable(true);
            user.lab_disable(true);
            user.pharmasist_disable(true);

            user.xray_disable(true);
            user.reciptionist_disable(true);

        }
         else if (name.equals("reciption")) {
            user.doctor_disable(true);
            user.nurse_disable(true);
            user.accountant_disable(true);
            user.lab_disable(true);
            user.pharmasist_disable(true);

            user.xray_disable(true);
            user.admin_disable(true);

        }
          else if (name.equals("nurse")) {
            user.doctor_disable(true);
            user.reciptionist_disable(true);
            user.accountant_disable(true);
            user.lab_disable(true);
            user.pharmasist_disable(true);

            user.xray_disable(true);
            user.admin_disable(true);

        }
        
          else if (name.equals("pharmasist")) {
            user.doctor_disable(true);
            user.reciptionist_disable(true);
            user.accountant_disable(true);
            user.lab_disable(true);
            user.nurse_disable(true);

            user.xray_disable(true);
            user.admin_disable(true);

        }
          else if (name.equals("xray")) {
            user.doctor_disable(true);
            user.reciptionist_disable(true);
            user.accountant_disable(true);
            user.lab_disable(true);
            user.nurse_disable(true);

            user.pharmasist_disable(true);
            user.admin_disable(true);

        }
          else if (name.equals("lab")) {
            user.doctor_disable(true);
            user.reciptionist_disable(true);
            user.accountant_disable(true);
            user.xray_disable(true);
            user.nurse_disable(true);

            user.xray_disable(true);
            user.admin_disable(true);

        }
         else if (name.equals("accountant")) {
            user.doctor_disable(true);
            user.reciptionist_disable(true);
            user.lab_disable(true);
            user.xray_disable(true);
            user.nurse_disable(true);

            user.xray_disable(true);
            user.admin_disable(true);

        }
        s = new Scene(p);

        stage.setScene(s);
        stage.setResizable(false);
//            stage.initOwner(c.button.getScene().getWindow());
//            stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {

                System.exit(0);

            }
        });
        stage.setTitle("Hospital management .... ! ");
        stage.showAndWait();
    }

}
