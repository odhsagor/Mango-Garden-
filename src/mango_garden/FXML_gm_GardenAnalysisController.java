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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        
        GardenAnalysis p = new GardenAnalysis(
               Integer.parseInt(NewPlantedTress.getText()),
               Integer.parseInt(OldNumberofTrees.getText()),
               Integer.parseInt(TotalQuantityOfMango.getText()),
               Integer.parseInt(TotalWaste.getText())
        );
        
        p.AddGardenAnalysis();
        NewPlantedTress.setText(null);
        OldNumberofTrees.setText(null);
        TotalQuantityOfMango.setText(null);
        TotalWaste.setText(null);
    }

    @FXML
    private void OnCLickToViewGraph(ActionEvent event) throws IOException {
         FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_gm_GardenAnalysis_Table.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_gm_GardenAnalysis_TableController controller1 = loader1.getController();
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
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
