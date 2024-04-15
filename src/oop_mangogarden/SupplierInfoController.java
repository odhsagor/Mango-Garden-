
package oop_mangogarden;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class SupplierInfoController implements Initializable {

    @FXML
    private TextField nameTextfield;
    @FXML
    private TextField contactTextfield;
    @FXML
    private TextField addressTextfield;
    @FXML
    private TableView<Supplier> tableview;
    @FXML
    private TableColumn<Supplier, String> nameColumn;
    @FXML
    private TableColumn<Supplier, String> contactColumn;
    @FXML
    private TableColumn<Supplier, String> addressColumn;

    ArrayList<Supplier> SupplierList;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SupplierList = new ArrayList<Supplier>();
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<Supplier,String>("supplierName"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<Supplier,String>("contact"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Supplier,String>("address"));
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
    private void saveinfoOnclick(ActionEvent event) throws IOException{
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f = new File("Supplier.bin");
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            Supplier d = new Supplier(nameTextfield.getText(), contactTextfield.getText(),
                    addressTextfield.getText());
            
            oos.writeObject(d); 
            
            nameTextfield.clear(); contactTextfield.clear();
            addressTextfield.clear();
            
            fos.close();
            oos.close();
            
        }
        catch(IOException e){
            Logger.getLogger(SupplierInfoController.class.getName()).log(Level.SEVERE, null, e);
    
        }
        finally{
            try{
                if(oos != null) oos.close();
            }
            catch(IOException e){
                Logger.getLogger(SupplierInfoController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @FXML
    private void loadSupplierInfoFile(){
        ObjectInputStream ois = null;
        try{
            Supplier i;
            ois = new ObjectInputStream(new FileInputStream("Supplier.bin"));
            while(true){
                i = (Supplier) ois.readObject();
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
    private void showinfoOnclick(ActionEvent event) {
        loadSupplierInfoFile();
    }
    
}
