/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mango_garden;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class FXML_cus_ReviewController implements Initializable {

    @FXML
    private TextArea ReviewTab;
    @FXML
    private RadioButton Rate_2;
    @FXML
    private RadioButton Rate_3;
    @FXML
    private RadioButton Rate_4;
    @FXML
    private RadioButton Rate_5;
    @FXML
    private RadioButton Rate_1;
    @FXML
    private Button OnClickGoBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnClickReview(ActionEvent event) {
    }
    
}
