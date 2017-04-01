package room;

import com.sun.javafx.tk.Toolkit;
import database.database;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

public class RoomController implements Initializable, EventHandler<MouseEvent> {
    
    @FXML
    TextField room_id;
    @FXML
    TextField cost;
    @FXML
    TextField service_cost;
    @FXML
    ComboBox type;
    @FXML
    ComboBox department;
    @FXML
    ComboBox state;
    @FXML
    Ellipse add;
    @FXML
    Ellipse update;
    @FXML
    Ellipse getdata;
    @FXML
    Ellipse delete;
    @FXML
    Ellipse nnew;
    // text fielda inside ellipse 
    @FXML
    Text a;
    @FXML
    Text u;
    
    @FXML
    Text g;
    
    @FXML
    Text n;
    
    @FXML
    Text d;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        state.getItems().addAll(FXCollections.observableArrayList("empty"));
        type.getItems().addAll(FXCollections.observableArrayList("1", "2", "3", "4", "5"));
        department.getItems().addAll(FXCollections.observableArrayList("orthopedic surgery", "cardiac surgery", "dermatology", "chest diseases", "obsetetric surgery", "dental", "internal medican"));
        state.setValue("");
        type.setValue("");
        department.setValue("");
        update.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                
                update.setFill(Color.DARKKHAKI);
            }
        });
        add.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                System.out.println("..............");
                add.setFill(Color.DARKKHAKI);
            }
        });
        getdata.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                
                getdata.setFill(Color.DARKKHAKI);
            }
        });
        nnew.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                
                nnew.setFill(Color.DARKKHAKI);
            }
        });
        delete.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                
                delete.setFill(Color.DARKKHAKI);
            }
        });
        a.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                
                add.setFill(Color.DARKKHAKI);
            }
        });
        u.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                
                update.setFill(Color.DARKKHAKI);
            }
        });
        g.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                
                getdata.setFill(Color.DARKKHAKI);
            }
        });
        n.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                
                nnew.setFill(Color.DARKKHAKI);
            }
        });
        g.setOnMousePressed(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                
                getdata.setFill(Color.DARKKHAKI);
            }
        });
        cost.setOnKeyTyped(new EventHandler<KeyEvent>() {
            
            @Override
            public void handle(KeyEvent event) {
                String content = event.getCharacter();
                if ("0123456789".contains(content)) {
                } else {
               
                    event.consume();
                }
                
            }
        });
        room_id.setOnKeyTyped(new EventHandler<KeyEvent>() {
            
            @Override
            public void handle(KeyEvent event) {
                String content = event.getCharacter();
                if ("0123456789".contains(content)) {
                } else {
                    room_id.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                    event.consume();
                }
                
            }
        });
        service_cost.setOnKeyTyped(new EventHandler<KeyEvent>() {
            
            @Override
            public void handle(KeyEvent event) {
                String content = event.getCharacter();
                if ("0123456789".contains(content)) {
                } else {
                    event.consume();
                }
                
            }
        });
        
    }
    
    @Override
    public void handle(MouseEvent event) {

        // add button mouse click 
        if (event.getSource() == add || event.getSource() == a) {
            // if any component is null when click add
            add.setFill(Color.CHARTREUSE);
            if (room_id.getText().equals("")
                    || type.getSelectionModel().getSelectedItem().toString().equals("")
                    || department.getSelectionModel().getSelectedItem().toString().equals("")
                    || state.getSelectionModel().getSelectedItem().toString().equals("")
                    || cost.getText().equals("")
                    || service_cost.getText().equals("")) {
                if (room_id.getText().equals("")) {
                    
                    JOptionPane.showMessageDialog(null, "Enter room id ");
                    
                } else if (type.getSelectionModel().getSelectedItem().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Select type");
                    
                } else if (department.getSelectionModel().getSelectedItem().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "select department");
                    
                } else if (state.getSelectionModel().getSelectedItem().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "select state");
                    
                } else if (cost.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter cost ");
                    
                } else if (service_cost.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter service cost");
                    
                }
                
            } // if all component is fill we want to test and add this room 
            else {
                try {
                    database data = new database();
                    
                    if (data.re()) {

                        // if this id dont exist in database 
                        if (!data.check_id_room(room_id.getText())) {

                            // insert romm into database 
                            data.insert_room(Integer.parseInt(room_id.getText()), type.getSelectionModel().getSelectedItem().toString(), department.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(cost.getText()), state.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(service_cost.getText()));
                            JOptionPane.showMessageDialog(null, "Done add room ...");
                            
                        } else {
                            
                            JOptionPane.showMessageDialog(null, "Room is fill");
                            
                        }
                        
                    } else {
                        
                        JOptionPane.showMessageDialog(null, "Error database connection");
                        
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        } else if (event.getSource() == update || event.getSource() == u) {
            update.setFill(Color.CHARTREUSE);
            
            if (room_id.getText().equals("")
                    || type.getSelectionModel().getSelectedItem().toString().equals("")
                    || department.getSelectionModel().getSelectedItem().toString().equals("")
                    || state.getSelectionModel().getSelectedItem().toString().equals("")
                    || cost.getText().equals("")
                    || service_cost.getText().equals("")) {
                if (room_id.getText().equals("")) {
                    
                    JOptionPane.showMessageDialog(null, "Enter room id ");
                    
                } else if (type.getSelectionModel().getSelectedItem().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Select type");
                    
                } else if (department.getSelectionModel().getSelectedItem().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "select department");
                    
                } else if (state.getSelectionModel().getSelectedItem().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "select state");
                    
                } else if (cost.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter cost ");
                    
                } else if (service_cost.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter service cost");
                    
                }
                
            } // if all data is done insert into component 
            else {
                try {
                    database data = new database();
                    if (data.re()) {
                        
                        if (data.check_id_room(room_id.getText())) {
                            
                            data.update_room(Integer.parseInt(room_id.getText()), type.getSelectionModel().getSelectedItem().toString(), department.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(cost.getText()), state.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(service_cost.getText()));
                            JOptionPane.showMessageDialog(null, "Done update .....");
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "The room dont exist ");
                            
                        }
                    } else {
                        
                        JOptionPane.showMessageDialog(null, "Error database connection ");
                    }
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(RoomController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        } else if (event.getSource() == getdata || event.getSource() == g) {
            getdata.setFill(Color.CHARTREUSE);
            
        } else if (event.getSource() == nnew || event.getSource() == n) {
            nnew.setFill(Color.CHARTREUSE);
            room_id.setText("");
            department.setValue("");
            type.setValue("");
            state.setValue("");
            cost.setText("");
            service_cost.setText("");
            
        } 
        // delete button action 
        else if (event.getSource() == delete || event.getSource() == d) {
            delete.setFill(Color.CHARTREUSE);
            
        }
        
    }
    
}
