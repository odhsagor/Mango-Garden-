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
public class FXML_gm_StufAttendaceController implements Initializable {

    @FXML
    private TableView<StuffAttendance> SutffAttendaceTable;
    @FXML
    private TableColumn<StuffAttendance, String> StuffNameCol;
    @FXML
    private TableColumn<StuffAttendance, String> MobNumCol;
    @FXML
    private TableColumn<StuffAttendance, String> AttendanceCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         StuffNameCol.setCellValueFactory(new PropertyValueFactory<StuffAttendance,String>("StufName"));
        MobNumCol.setCellValueFactory(new PropertyValueFactory<StuffAttendance,String>("MobileNumber"));
         AttendanceCol.setCellValueFactory(new PropertyValueFactory<StuffAttendance,String>("Attendace"));
        
         StuffAttendance s1=new StuffAttendance("Lazin","01901920","Present");
         StuffAttendance s2=new StuffAttendance("Rafiul","0191244","Absent");
         StuffAttendance s3=new StuffAttendance("Obama","01901920","Present");
         StuffAttendance s4=new StuffAttendance("Bilal","01901920","Present");
         SutffAttendaceTable.getItems().add(s1);
         SutffAttendaceTable.getItems().add(s2);
         SutffAttendaceTable.getItems().add(s3);
         SutffAttendaceTable.getItems().add(s4);
         
//         ArrayList<StuffAttendance>u = StuffAttendance.listOfUser();
//        if(u != null){
//                    tableView.getItems().add(c);
//                
//            
//        }
    
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
