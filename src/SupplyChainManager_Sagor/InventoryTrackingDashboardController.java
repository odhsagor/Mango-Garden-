/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SupplyChainManager_Sagor;

import java.io.EOFException;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author md.obidulhuqsagor
 */
public class InventoryTrackingDashboardController implements Initializable {

    @FXML
    private TableView<orderManagement> ItTablefxid;
    @FXML
    private TableColumn<orderManagement, String> datefxid;
    @FXML
    private Button BackItfxid;
    @FXML
    private TableColumn<orderManagement, String> customerNamefxid;
    @FXML
    private TableColumn<orderManagement, String> productNamefxid;
    @FXML
    private TableColumn<orderManagement, String> quantityfxid;
    @FXML
    private TableColumn<orderManagement, String> amountfxid;

    ArrayList<orderManagement> orderManagementList;
    ObservableList<orderManagement> tempList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        orderManagementList = new ArrayList <orderManagement>();
        
        datefxid.setCellValueFactory(new PropertyValueFactory<orderManagement,String>("Date"));
        customerNamefxid.setCellValueFactory(new PropertyValueFactory<orderManagement,String>("CoustomerName"));
        productNamefxid.setCellValueFactory(new PropertyValueFactory<orderManagement,String>("product"));
        quantityfxid.setCellValueFactory(new PropertyValueFactory<orderManagement,String>("quantity"));
        amountfxid.setCellValueFactory(new PropertyValueFactory<orderManagement,String>("Amount"));
        
    }    
    private void loadOrderManagementFile(){
        ObjectInputStream ois = null;
        try{
            orderManagement i;
            ois = new ObjectInputStream(new FileInputStream("Order.bin"));
            while(true){
                try {
                    orderManagement ms = (orderManagement) ois.readObject();
                    tempList.add(ms);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Class not Found");
                }
            }
            for(orderManagement y : tempList){
                 ItTablefxid.getItems().add(y);
             }
        }
        catch(IOException e){
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
    private void BackItOnAction(ActionEvent event) throws IOException {
        
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("mainSupplyChainManager.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void itPrintOnClick(ActionEvent event) {
        
    }

    @FXML
    private void itShowOnClick(ActionEvent event) {
                ObjectInputStream ois = null;
        try{
            orderManagement i;
            ois = new ObjectInputStream(new FileInputStream("Order.bin"));
            while(true){
                i = (orderManagement) ois.readObject();
                ItTablefxid.getItems().add(i);
            }
        }
        catch(  IOException | ClassNotFoundException e){
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
    
}
