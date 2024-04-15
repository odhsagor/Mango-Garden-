/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class UserProfileManagementController implements Initializable {

    @FXML
    private TextField userIdFXID;
    @FXML
    private TextField currentUserIdFXID;
    @FXML
    private TextField newUserIdFXID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void updateButtonOnAction(ActionEvent event) {
    }
    
}
