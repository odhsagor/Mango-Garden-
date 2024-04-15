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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class FXML_gm_InternalCommunicationController implements Initializable {

    @FXML
    private TextArea inboxField;
    @FXML
    private TextArea msgBodyField;
    @FXML
    private TextField from;
    @FXML
    private TextField to;
    @FXML
    private TextField subjectField;
    @FXML
    private DatePicker date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClickHomeSceneButton(ActionEvent event) {
    }

    @FXML
    private void onClickSendButton(ActionEvent event) {
    }
    
}
