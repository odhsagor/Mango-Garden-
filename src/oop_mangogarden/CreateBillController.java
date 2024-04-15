
package oop_mangogarden;

//import com.sun.istack.internal.logging.Logger;
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


public class CreateBillController implements Initializable {

    @FXML
    private TextField addressTextfield;
    @FXML
    private TextField issuedateTextfield;
    @FXML
    private TextField productnameTextfield;
    @FXML
    private TextField quantityTextfield;
    @FXML
    private TextField invoiceTextfield;
    @FXML
    private TableView<Bill> tableview;
    @FXML
    private TableColumn<Bill, String> invoiceColumn;
    @FXML
    private TableColumn<Bill, String> productnameColumn;
    @FXML
    private TableColumn<Bill, String> issuedateColumn;
    @FXML
    private TableColumn<Bill, String> quantityColumn;
    @FXML
    private TableColumn<Bill, String> totalpriceColumn;
    
    ArrayList<Bill> createbillList;
    @FXML
    private TextField customernameTextfield;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createbillList = new ArrayList<Bill>();
        
        invoiceColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("invoiceNo"));
        productnameColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("productname"));
        issuedateColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("issueDate"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("quantity"));
        totalpriceColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("totalPrice"));
            
    }    

    @FXML
    private void backOnclick(ActionEvent event) throws Exception{
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("AccountantDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void creatOnclick(ActionEvent event) throws IOException{
        
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f = new File("Createbill.bin");
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            

// String customerName, String address, int issueDate, String productname, int quantity, int invoiceNo, Float totalPrice
            Float total = 100.00f;
            Bill d = new Bill(customernameTextfield.getText(), addressTextfield.getText(),
                    issuedateTextfield.getText(), productnameTextfield.getText(),
            Integer.parseInt(quantityTextfield.getText()),Integer.parseInt(invoiceTextfield.getText()), total );
            
            oos.writeObject(d); 
            
            customernameTextfield.clear(); addressTextfield.clear();
            issuedateTextfield.clear(); productnameTextfield.clear();
            quantityTextfield.clear(); invoiceTextfield.clear();
            
            fos.close();
            oos.close();
            
        }
        catch(IOException e){
            Logger.getLogger(CreateBillController.class.getName()).log(Level.SEVERE, null, e);
    
        }
        finally{
            try{
                if(oos != null) oos.close();
            }
            catch(IOException e){
                Logger.getLogger(CreateBillController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
    }
    

    private void loadCreatbillFile(){
        ObjectInputStream ois = null;
        try{
            Bill i;
            ois = new ObjectInputStream(new FileInputStream("CreateBill.bin"));
            while(true){
                i = (Bill) ois.readObject();
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
    private void shownewbillOnclick(ActionEvent event){
        loadCreatbillFile();
        
    }
    
    }

