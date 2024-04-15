
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


public class FXMLmoneyreceiptController implements Initializable {

    @FXML
    private TextField drivernameTextfield;
    @FXML
    private TextField contactTextfield;
    @FXML
    private TextField dateTextfield;
    @FXML
    private TextField priceTextfield;

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
    private void saveOnclick(ActionEvent event) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f = new File("MoneyReceipt.bin");
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
    
    
            MoneyReceipt d = new MoneyReceipt(dateTextfield.getText(), Integer.parseInt(priceTextfield.getText()),
                    drivernameTextfield.getText(), contactTextfield.getText());
            
            oos.writeObject(d); 
            
            dateTextfield.clear(); priceTextfield.clear();
            drivernameTextfield.clear(); contactTextfield.clear();
            
            fos.close();
            oos.close();
            
        }
        catch(IOException e){
            Logger.getLogger(FXMLmoneyreceiptController.class.getName()).log(Level.SEVERE, null, e);
    
        }
        finally{
            try{
                if(oos != null) oos.close();
            }
            catch(IOException e){
                Logger.getLogger(FXMLmoneyreceiptController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }    
    
}
