/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SupplyChainManager_Sagor;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author md.obidulhuqsagor
 */
public class OrderManagementController implements Initializable {

    @FXML
    private TextField customerNamefxid;
    @FXML
    private ComboBox<String> quantityfxid;
    @FXML
    private ComboBox<String> productfxid;
    @FXML
    private TextField Amountfxid;
    @FXML
    private TextField datetextfxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productfxid.getItems().addAll("Langra", "Fazli", "Himsagar",
                "Khirsapat", "Gopalbhog", "Amrapali", "Ashwina",
                "Bombai", "Hari Bhanga");

        quantityfxid.getItems().addAll(
                "1Kg", "2Kg", "3Kg", "4Kg", "5Kg",
                "6Kg", "7Kg", "8Kg", "9Kg", "10Kg",
                "11Kg", "12Kg", "13Kg", "14Kg", "15Kg",
                "16Kg", "17Kg", "18Kg", "19Kg", "20Kg", "30Kg","40Kg"
        );
       
    }

    @FXML
    private void omBackOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("mainSupplyChainManager.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void omAddOnClick(ActionEvent event) throws IOException{

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f = new File("Order.bin");
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            orderManagementBin d = new orderManagementBin(customerNamefxid.getText(), quantityfxid.getValue(),
                    productfxid.getValue(), Amountfxid.getText(), datetextfxid.getText());

            oos.writeObject(d);

            customerNamefxid.clear(); quantityfxid.getSelectionModel().clearSelection(); productfxid.getSelectionModel().clearSelection();
            Amountfxid.clear(); datetextfxid.clear();
            
            fos.close();
            oos.close();
            
        }
        catch(IOException e){
            Logger.getLogger(OrderManagementController.class.getName()).log(Level.SEVERE, null, e);
    
        }
        finally{
            try{
                if(oos != null) oos.close();
            }
            catch(IOException e){
                Logger.getLogger(OrderManagementController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    
    }



}
