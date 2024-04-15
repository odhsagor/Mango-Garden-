/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mango_garden;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class FXML_gm_GardenAnalysis_TableController implements Initializable {

    @FXML
    private TableView<GardenAnalysis> TableView;
    @FXML
    private TableColumn<GardenAnalysis,String > NewPlantedTress;
    @FXML
    private TableColumn<GardenAnalysis, String> OldNumberOfTrees;
    @FXML
    private TableColumn<GardenAnalysis, String> TotalQuantityOfMango;
    @FXML
    private TableColumn<GardenAnalysis, String> TotalWaste;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        NewPlantedTress.setCellValueFactory(new PropertyValueFactory<GardenAnalysis,String>("new_planted_trees"));
        OldNumberOfTrees.setCellValueFactory(new PropertyValueFactory<GardenAnalysis,String>("old_number_of_trees"));
         TotalQuantityOfMango.setCellValueFactory(new PropertyValueFactory<GardenAnalysis,String>("total_quantity_of_mango"));
        TotalWaste.setCellValueFactory(new PropertyValueFactory<GardenAnalysis,String>("total_waste")); 
        ArrayList<GardenAnalysis>u = GardenAnalysis.ListOfGardenAnalysis();
        if(u != null){
            for(GardenAnalysis i: u){
                    TableView.getItems().add(i);
                
            }
        }
        
    }    

    @FXML
    private void OnClickToGoBack(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_gm_GardenAnalysis.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_gm_GardenAnalysisController controller1 = loader1.getController();
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
}
