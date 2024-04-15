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
    private TableView<orderManagementBin> ItTablefxid;
    @FXML
    private TableColumn<orderManagementBin, String> datefxid;
    @FXML
    private Button BackItfxid;
    @FXML
    private TableColumn<orderManagementBin, String> customerNamefxid;
    @FXML
    private TableColumn<orderManagementBin, String> productNamefxid;
    @FXML
    private TableColumn<orderManagementBin, String> quantityfxid;
    @FXML
    private TableColumn<orderManagementBin, String> amountfxid;

    ArrayList<orderManagementBin> orderManagementList;
    ObservableList<orderManagementBin> tempList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        orderManagementList = new ArrayList <orderManagementBin>();
        
        datefxid.setCellValueFactory(new PropertyValueFactory<orderManagementBin,String>("Date"));
        customerNamefxid.setCellValueFactory(new PropertyValueFactory<orderManagementBin,String>("CoustomerName"));
        productNamefxid.setCellValueFactory(new PropertyValueFactory<orderManagementBin,String>("product"));
        quantityfxid.setCellValueFactory(new PropertyValueFactory<orderManagementBin,String>("quantity"));
        amountfxid.setCellValueFactory(new PropertyValueFactory<orderManagementBin,String>("Amount"));
        
    }    
    private void loadOrderManagementFile(){
        ObjectInputStream ois = null;
        try{
            orderManagementBin i;
            ois = new ObjectInputStream(new FileInputStream("Order.bin"));
            while(true){
                try {
                    orderManagementBin ms = (orderManagementBin) ois.readObject();
                    tempList.add(ms);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Class not Found");
                }
            }
            for(orderManagementBin y : tempList){
                 ItTablefxid.getItems().add(y);
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
            orderManagementBin i;
            ois = new ObjectInputStream(new FileInputStream("Order.bin"));
            while(true){
                i = (orderManagementBin) ois.readObject();
                ItTablefxid.getItems().add(i);
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
    
}
