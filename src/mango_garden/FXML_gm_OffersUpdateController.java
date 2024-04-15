/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mango_garden;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class FXML_gm_OffersUpdateController implements Initializable {

    @FXML
    private TextArea UpdateOf1;
    @FXML
    private TextArea UpdateOf2;
    @FXML
    private TextArea UpdateOf3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnClickToUpload(ActionEvent event) {
        OfferUpdate p = new OfferUpdate(
               UpdateOf1.getText()
        );
        
        p.addOfferInfo();
        
         OfferUpdate p2 = new OfferUpdate(
               UpdateOf2.getText()
        );
        
        p2.addOfferInfo();
        
         OfferUpdate p3 = new OfferUpdate(
               UpdateOf3.getText()
        );
        
        p3.addOfferInfo();
        
        
        UpdateOf1.setText(null);
        UpdateOf2.setText(null);
        UpdateOf3.setText(null);
    }

    @FXML
    private void OnClickToGoBack(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_gm_Dashboard.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_gm_DashboardController controller1 = loader1.getController();
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
    
    
}
