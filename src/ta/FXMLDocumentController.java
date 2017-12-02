/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXPasswordField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



/**
 *
 * @author AdityaHarisCandra
 */
public class FXMLDocumentController implements Initializable {
    
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
  @FXML
    private JFXTextField username;

     @FXML
    private JFXPasswordField password;
    private Label tampilusername;
    private Label tampilpassword;
  
    String name, word;

    @FXML
    private JFXButton btnlogin;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;    }
    
    @FXML
    void login(ActionEvent event) throws SQLException {
        try {
            sql = "SELECT * FROM admin WHERE username='"+username.getText()+"' AND password='"+password.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(username.getText().equals(rs.getString("username")) && password.getText().equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "berhasil login");
                    // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("TitipSam");
            stage.show();
                }
            }else{
                    JOptionPane.showMessageDialog(null, "username atau password salah");
                }
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
        }
    }