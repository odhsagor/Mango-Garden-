
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


public class TransportableProductInfoController implements Initializable {

    @FXML
    private TableView<ProductInfo> tableview;
    @FXML
    private TableColumn<ProductInfo, String> productnameColumn;
    @FXML
    private TableColumn<ProductInfo, String> productidColumn;
    @FXML
    private TableColumn<ProductInfo, String> orderedColumn;
    @FXML
    private TableColumn<ProductInfo, String> destinationColmun;
    @FXML
    private TableColumn<ProductInfo, String> totalpriceColumn;

    ObservableList<ProductInfo> list = FXCollections.observableArrayList( 
            
        new ProductInfo( "Mango", "0001", "Confirm","Dhaka", "50,0000"),
        new ProductInfo("Mango", "0002", "Confirm", "Dhaka", "55,0000"),
        new ProductInfo("Mango", "0003", "Confirm", "Dhaka", "42,0000"),
        new ProductInfo("Mango", "0004", "Confirm", "Cumilla", "40,0000"),
        new ProductInfo("Mango", "0005", "Confirm", "Dhaka", "60,0000"),
        new ProductInfo("Mango", "0006", "Confirm", "Dhaka", "60,0000")

    );
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productnameColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo, String>("name"));
        productidColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo,String>("id"));
        orderedColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo,String>("oreder"));
        destinationColmun.setCellValueFactory(new PropertyValueFactory<ProductInfo,String>("destination"));
        totalpriceColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo,String>("totalprice"));
    }    

    @FXML
    private void backOnClick(ActionEvent event) throws Exception{
                                Parent mainSceneParent = FXMLLoader.load(getClass().getResource("TransportOperatorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void showproductOnclick(ActionEvent event) {
       tableview.setItems(list);

    }
    
}
