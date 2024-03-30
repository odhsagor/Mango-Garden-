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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class FXML_gm_GardenAnalysisController implements Initializable {

    @FXML
    private TextField NewPlantedTress;
    @FXML
    private TextField OldNumberofTrees;
    @FXML
    private TextField TotalQuantityOfMango;
    @FXML
    private TextField TotalWaste;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnClickToUpload(ActionEvent event) {
    }

    @FXML
    private void OnCLickToViewGraph(ActionEvent event) {
    }

    @FXML
    private void OnClickToGoBack(ActionEvent event) {
    }
    
}
