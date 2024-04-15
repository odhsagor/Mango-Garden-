/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SupplyChainManager_Sagor;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
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

/**
 * FXML Controller class
 *
 * @author md.obidulhuqsagor
 */
public class ReportingAndAnalyticsController implements Initializable {

    @FXML
    private TableView<TransferBinFile> tabelviewraafxid;
    @FXML
    private TableColumn<TransferBinFile, String> raaNamefxid;
    @FXML
    private TableColumn<TransferBinFile, String> raaOrderfxid;
    @FXML
    private TableColumn<TransferBinFile, String> raaFromfxid;
    @FXML
    private TableColumn<TransferBinFile, String> raaTofxid;
    @FXML
    private TableColumn<TransferBinFile, String> raaAmountfxid;
    @FXML
    private TableColumn<TransferBinFile, String> raaMoveDafxid;
    
    
    ArrayList<TransferBinFile> TransferFileList;
    ObservableList<TransferBinFile> tempList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TransferFileList = new ArrayList <TransferBinFile>();
        
        raaNamefxid.setCellValueFactory(new PropertyValueFactory<TransferBinFile, String>("Name"));
        raaOrderfxid.setCellValueFactory(new PropertyValueFactory<TransferBinFile, String>("From"));
        raaFromfxid.setCellValueFactory(new PropertyValueFactory<TransferBinFile, String>("TO"));
        raaTofxid.setCellValueFactory(new PropertyValueFactory<TransferBinFile, String>("OrderID"));
        raaAmountfxid.setCellValueFactory(new PropertyValueFactory<TransferBinFile, String>("Amount"));
        raaMoveDafxid.setCellValueFactory(new PropertyValueFactory<TransferBinFile, String>("Amount"));
        
    }
    private void loadTransferFile(){
        ObjectInputStream ois = null;
        try{
            TransferBinFile i;
            ois = new ObjectInputStream(new FileInputStream("Transfer.bin"));
            while(true){
                try {
                    TransferBinFile ms = (TransferBinFile) ois.readObject();
                    tempList.add(ms);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Class not Found");
                }
            }
            for(TransferBinFile y : tempList){
                 tabelviewraafxid.getItems().add(y);
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
    private void raabackOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("mainSupplyChainManager.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void raaShowReport(ActionEvent event) {
                    ObjectInputStream ois = null;
        try{
            TransferBinFile i;
            ois = new ObjectInputStream(new FileInputStream("Transfer.bin"));
            while(true){
                i = (TransferBinFile) ois.readObject();
                tabelviewraafxid.getItems().add(i);
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
