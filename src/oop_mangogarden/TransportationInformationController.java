
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

public class TransportationInformationController implements Initializable {

    @FXML
    private TextField drivernameTextfield;
    @FXML
    private TextField productidTextfield;
    @FXML
    private TextField dispatchdateTextfield;
    @FXML
    private TextField chassisnoTextfield;
    @FXML
    private TextField platenoTextfield;
    @FXML
    private TextField destinationTextfield;
    @FXML
    private TableView<Transport> tableview;
    @FXML
    private TableColumn<Transport, String> productidColumn;
    @FXML
    private TableColumn<Transport, String> drivernameColumn;
    @FXML
    private TableColumn<Transport, String> dispatchdateColumn;
    @FXML
    private TableColumn<Transport, String> chassisnoOnclick;
    @FXML
    private TableColumn<Transport, String> platenoOnclick;
    @FXML
    private TableColumn<Transport, String> destinationOnclick;

    ArrayList<Transport> transportInfoList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        transportInfoList = new ArrayList<Transport>();
        
        productidColumn.setCellValueFactory(new PropertyValueFactory<Transport,String>("productID"));
        drivernameColumn.setCellValueFactory(new PropertyValueFactory<Transport,String>("driverName"));
        dispatchdateColumn.setCellValueFactory(new PropertyValueFactory<Transport,String>("dispatchDate"));
        chassisnoOnclick.setCellValueFactory(new PropertyValueFactory<Transport,String>("chassisNo"));
        platenoOnclick.setCellValueFactory(new PropertyValueFactory<Transport,String>("plateNo"));
        destinationOnclick.setCellValueFactory(new PropertyValueFactory<Transport,String>("destination"));

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
    private void confirminfoOnclick(ActionEvent event) throws IOException{
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f = new File("TransportInformation.bin");
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

                      
//String DriverName, String productID, String dispatchDate, String destination, String chassisNo, String plateNo
            Transport d = new Transport(drivernameTextfield.getText(), productidTextfield.getText(),
                    dispatchdateTextfield.getText(), destinationTextfield.getText(),
            chassisnoTextfield.getText(), platenoTextfield.getText());
            
            oos.writeObject(d); 
              
            drivernameTextfield.clear(); productidTextfield.clear();
            dispatchdateTextfield.clear(); destinationTextfield.clear();
            chassisnoTextfield.clear(); platenoTextfield.clear();
            
            fos.close();
            oos.close();
            
        }
        catch(IOException e){
            Logger.getLogger(TransportationInformationController.class.getName()).log(Level.SEVERE, null, e);
    
        }
        finally{
            try{
                if(oos != null) oos.close();
            }
            catch(IOException e){
                Logger.getLogger(TransportationInformationController.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }
    
    @FXML
    private void loadTransportInfoFile(){
        ObjectInputStream ois = null;
        try{
            Transport i;
            ois = new ObjectInputStream(new FileInputStream("TransportInformation.bin"));
            while(true){
                i = (Transport) ois.readObject();
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
    private void showallinfoOnclick(ActionEvent event){
        loadTransportInfoFile();
    }
    
}
