/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package SupplyChainManager_Sagor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author md.obidulhuqsagor
 */
public class TransferManagementController implements Initializable {

    @FXML
    private Button backTmfxid;
    @FXML
    private TextField tmNamefxid;
    @FXML
    private TextField tmFromfxid;
    @FXML
    private TextField tmTofxid;
    @FXML
    private TextField tmOrderidfxid;
    @FXML
    private TextField tmAmountfxid;
    @FXML
    private TextField tmMoveDatefxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backTmOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("mainSupplyChainManager.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void tmSubmitOnClick(ActionEvent event)throws IOException {

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f = new File("Transfer.bin");
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            TransferBinFile d = new TransferBinFile(tmNamefxid.getText(), tmFromfxid.getText(),
                    tmTofxid.getText(), tmOrderidfxid.getText(),tmAmountfxid.getText(), 
                    tmMoveDatefxid.getText());
                    
            oos.writeObject(d);

            tmNamefxid.clear(); tmFromfxid.clear(); tmTofxid.clear();
            tmOrderidfxid.clear(); tmAmountfxid.clear();tmMoveDatefxid.clear();
            
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
