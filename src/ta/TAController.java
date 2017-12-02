/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


/**
 * FXML Controller class
 *
 * @author AdityaHarisCandra
 */
public class TAController implements Initializable {

     @FXML
    private JFXTextField nb;

    @FXML
    private JFXTextField kb;

    @FXML
    private JFXTextField nl;

     @FXML
    private JFXDatePicker tp;

    @FXML
    private JFXTextField np;

    @FXML
    private JFXButton btnadd;

    @FXML
    private JFXButton btnclr;

    @FXML
    
    private JFXTextField admin;
    
     @FXML
    void add(ActionEvent event) {

    }

    @FXML
    void clr(ActionEvent event) {
        admin.setText("Admin");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
