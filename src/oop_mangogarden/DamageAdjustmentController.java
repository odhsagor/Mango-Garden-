
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


public class DamageAdjustmentController implements Initializable {

    @FXML
    private TextField drivernameTextfield;
    @FXML
    private TextField platenoTextfield;
    @FXML
    private TextField dateTextfield;
    @FXML
    private TextField destinationTextfield;
    @FXML
    private TextField productidTextfield;
    @FXML
    private TextField quantityTextfield;
    @FXML
    private TextField damageTextfield;
    @FXML
    private TextField adjustmentTextfield;
    
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
    private void saveOnclick(ActionEvent event) throws IOException{
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f = new File("Damage.bin");
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            DamageAdjust d = new DamageAdjust(drivernameTextfield.getText(), platenoTextfield.getText(),
                    dateTextfield.getText(), destinationTextfield.getText(),
                    productidTextfield.getText(), quantityTextfield.getText(), damageTextfield.getText(),
                    adjustmentTextfield.getText());
            
            oos.writeObject(d); 
            
            drivernameTextfield.clear(); platenoTextfield.clear();
            dateTextfield.clear(); destinationTextfield.clear();
            productidTextfield.clear(); quantityTextfield.clear();
            damageTextfield.clear(); adjustmentTextfield.clear();
            
            fos.close();
            oos.close();
            
        }
        catch(IOException e){
            Logger.getLogger(DamageAdjustmentController.class.getName()).log(Level.SEVERE, null, e);
    
        }
        finally{
            try{
                if(oos != null) oos.close();
            }
            catch(IOException e){
                Logger.getLogger(DamageAdjustmentController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
}
