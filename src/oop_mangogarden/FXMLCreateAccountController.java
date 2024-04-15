
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User-pc
 */
public class FXMLCreateAccountController implements Initializable {

    @FXML
    private ComboBox<String> employeetypeCombobox;
    @FXML
    private TextField nameTextfield;
    @FXML
    private TextField idTextfield;
    @FXML
    private TextField contactTextfield;
    @FXML
    private RadioButton maleRadio;
    @FXML
    private RadioButton femaleRadio;
    @FXML
    private RadioButton othersRadio;
    @FXML
    private TextField passwordTextfield;
    
    ToggleGroup tg;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            employeetypeCombobox.getItems().addAll("Accountant", "Transport Operator",
            "Garden Manager", "Supply Chain Manager", "IT Admin", "Horticulturist","CEO");
            
            tg = new ToggleGroup();
            maleRadio.setToggleGroup(tg);
            femaleRadio.setToggleGroup(tg);
            othersRadio.setToggleGroup(tg);

    }    

    @FXML
    private void backOnclick(ActionEvent event) throws Exception{
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
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
            f = new File("Login.bin");
            if(f.exists()){
                //System.out.println("File Exists");
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                
                
            }
            else{
                //System.out.println("Not exsits");
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            

//String employeeType, String employeeName, int employeeID, String gender, String contactNumber
            String gender="";
            if(maleRadio.isSelected())
                gender="Male";
            else if(femaleRadio.isSelected())
                gender="Female";
            else if (othersRadio.isSelected())
                gender="Others";
        
            Employee e = new Employee(employeetypeCombobox.getValue(), nameTextfield.getText(), 
                    idTextfield.getText(), gender, contactTextfield.getText(),
                    passwordTextfield.getText());
            
            oos.writeObject(e);
            
            nameTextfield.clear(); idTextfield.clear();
            contactTextfield.clear(); passwordTextfield.clear();
            
            fos.close();
            oos.close();
            
        }
        catch(IOException e){
            Logger.getLogger(FXMLCreateAccountController.class.getName()).log(Level.SEVERE, null, e);
    
        }
        finally{
            try{
                if(oos != null) oos.close();
            }
            catch(IOException e){
                Logger.getLogger(FXMLCreateAccountController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
}
