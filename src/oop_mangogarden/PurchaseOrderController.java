
package oop_mangogarden;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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


public class PurchaseOrderController implements Initializable {

    @FXML
    private TableView<PurchaseProduct> tableview;
    @FXML
    private TableColumn<PurchaseProduct, String> productnameColumn;
    @FXML
    private TableColumn<PurchaseProduct, String> issuedateColumn;
    @FXML
    private TableColumn<PurchaseProduct, String> quantityColumn;
    @FXML
    private TableColumn<PurchaseProduct, String> priceColumn;
    @FXML
    private TableColumn<PurchaseProduct, String> purchaseidColumn;

    ArrayList<PurchaseProduct> orderList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        orderList = new ArrayList<PurchaseProduct>();
        
        purchaseidColumn.setCellValueFactory(new PropertyValueFactory<PurchaseProduct,String>("purchaseID"));
        productnameColumn.setCellValueFactory(new PropertyValueFactory<PurchaseProduct,String>("productName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<PurchaseProduct,String>("quantity"));
        issuedateColumn.setCellValueFactory(new PropertyValueFactory<PurchaseProduct,String>("issueDate"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<PurchaseProduct,String>("price"));
        
    }    

    @FXML
    private void backOnclick(ActionEvent event) throws Exception{
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("TransportOperatorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }
    
    @FXML
    private void loadPurchaseOrderFile(){
        //tableview.clear();
        ObjectInputStream ois = null;
        try{
            PurchaseProduct i;
            ois = new ObjectInputStream(new FileInputStream("PurchaseOrder.bin"));
            while(true){
                i = (PurchaseProduct) ois.readObject();
                tableview.getItems().add(i);
            }
        }
        catch(Exception e){
            try{
                if(ois != null)
                    ois.close();
            }
            catch(IOException x){
                x.printStackTrace();
            }
            e.printStackTrace();
        }
    }
    
    
    @FXML
    private void showallorderOnclick(ActionEvent event) {
        loadPurchaseOrderFile();
    }
    
}
