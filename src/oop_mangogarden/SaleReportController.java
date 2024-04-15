
package oop_mangogarden;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


public class SaleReportController implements Initializable {

    @FXML
    private TableView<SaleInfo> tableview;
    @FXML
    private TableColumn<SaleInfo, String> quantityColumn;
    @FXML
    private TableColumn<SaleInfo, String> invoiceColumn;
    @FXML
    private TableColumn<SaleInfo, String> productnameCloumn;
    @FXML
    private TableColumn<SaleInfo, String> saledateColumn;
    @FXML
    private TableColumn<SaleInfo, String> totalpriceColumn;
    ObservableList<SaleInfo> list = FXCollections.observableArrayList( 
            
        new SaleInfo( "24001", "Mango", "9","01.02.24", "50,0000"),
        new SaleInfo("24002", "Mango", "5", "11.02.24", "55,0000"),
        new SaleInfo("24003", "Mango", "3", "05.03.24", "42,0000"),
        new SaleInfo("24004", "Mango", "10", "15.03.24", "40,0000"),
        new SaleInfo("24005", "Mango", "6", "15.03.24", "60,0000"),
        new SaleInfo("24006", "Mango", "15", "15.03.24", "60,0000")

    );


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        quantityColumn.setCellValueFactory(new PropertyValueFactory<SaleInfo, String>("quantity"));
        invoiceColumn.setCellValueFactory(new PropertyValueFactory<SaleInfo,String>("invoiceNo"));
        productnameCloumn.setCellValueFactory(new PropertyValueFactory<SaleInfo,String>("productName"));
        saledateColumn.setCellValueFactory(new PropertyValueFactory<SaleInfo,String>("saleDate"));
        totalpriceColumn.setCellValueFactory(new PropertyValueFactory<SaleInfo,String>("totalPrice"));
        //tableview.setItems(list);
    }   
 
    @FXML
    private void backOnclick(ActionEvent event) throws Exception{
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("AccountantDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();        
    }

    @FXML
    private void showreportOnclick(ActionEvent event) {
       tableview.setItems(list);

    }
    
}