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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class FXML_Cus_PaymentController implements Initializable {

    @FXML
    private RadioButton RadioPayOnline;
    @FXML
    private RadioButton RadioCashOnDelivary;
    @FXML
    private TextField address;
    @FXML
    private TextField mobileNumber;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnClickBackToCartButton(ActionEvent event) {
    }

    @FXML
    private void OnClickPaymentButton(ActionEvent event) {
    }
    
}
