
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


public class ProductRequestController implements Initializable {

    @FXML
    private TextField employeeidTextfield;
    @FXML
    private TextField contactTextfield;
    @FXML
    private TableView<ProductRequest> tableview;
    @FXML
    private TableColumn<ProductRequest, String> employeeidColumn;
    @FXML
    private TableColumn<ProductRequest, String> contactColumn;
    @FXML
    private TableColumn<ProductRequest, String> productidColumn;
    @FXML
    private TableColumn<ProductRequest, String> quantityColumn;
    @FXML
    private TableColumn<ProductRequest, String> dateColumn;
    @FXML
    private TextField productidTextfield;
    @FXML
    private TextField quantityTextfield;
    @FXML
    private TextField dateTextfield;

    ArrayList<ProductRequest> productReqList;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productReqList = new ArrayList<ProductRequest>();
        
        employeeidColumn.setCellValueFactory(new PropertyValueFactory<ProductRequest,String>("EmployeeID"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<ProductRequest,String>("Contact"));
        productidColumn.setCellValueFactory(new PropertyValueFactory<ProductRequest,String>("productID"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<ProductRequest,String>("quantity"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<ProductRequest,String>("date"));
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
            f = new File("ProductRequest.bin");
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            
            //String EmployeeID, String Contact, String productID, String quantity, String date
            
            ProductRequest d = new ProductRequest(employeeidTextfield.getText(), contactTextfield.getText(),
                    productidTextfield.getText(), quantityTextfield.getText(), dateTextfield.getText());
            
            oos.writeObject(d); 
            
            employeeidTextfield.clear(); contactTextfield.clear();
            productidTextfield.clear(); quantityTextfield.clear();
            dateTextfield.clear();
            
            fos.close();
            oos.close();
            
        }
        catch(IOException e){
            Logger.getLogger(ProductRequestController.class.getName()).log(Level.SEVERE, null, e);
    
        }
        finally{
            try{
                if(oos != null) oos.close();
            }
            catch(IOException e){
                Logger.getLogger(ProductRequestController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @FXML
    private void loadProductRequestFile(){
        ObjectInputStream ois = null;
        try{
            ProductRequest i;
            ois = new ObjectInputStream(new FileInputStream("ProductRequest.bin"));
            while(true){
                i = (ProductRequest) ois.readObject();
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
    private void showproductsOnclick(ActionEvent event) {
        loadProductRequestFile();
    }

    @FXML
    private void sendOnclick(ActionEvent event) throws Exception{
                Parent mainSceneParent = FXMLLoader.load(getClass().getResource("TransportOperatorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }
    
}
