
package oop_mangogarden;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IssuePurchaseController implements Initializable {

    @FXML
    private TextField productnameTaxtfield;
    @FXML
    private TextField quantityTextfield;
    @FXML
    private TextField issuedateTextfield;
    @FXML
    private TextField priceTextfield;
    @FXML
    private TextField purchaseidTextfield;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

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
    private void confiemOnclick(ActionEvent event) throws IOException{
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f = new File("PurchaseOrder.bin");
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            PurchaseProduct i = new PurchaseProduct(purchaseidTextfield.getText(), productnameTaxtfield.getText(),
                    quantityTextfield.getText(), issuedateTextfield.getText(),
                    priceTextfield.getText());
            
            oos.writeObject(i); 
            
            purchaseidTextfield.clear(); productnameTaxtfield.clear();
            quantityTextfield.clear(); issuedateTextfield.clear();
            priceTextfield.clear();
            
            fos.close();
            oos.close();
            
        }
        catch(IOException e){
            Logger.getLogger(IssuePurchaseController.class.getName()).log(Level.SEVERE, null, e);
    
        }
        finally{
            try{
                if(oos != null) oos.close();
            }
            catch(IOException e){
                Logger.getLogger(IssuePurchaseController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
}
