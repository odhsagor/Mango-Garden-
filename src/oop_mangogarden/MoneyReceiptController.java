
package oop_mangogarden;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MoneyReceiptController implements Initializable {

    @FXML
    private TableView<MoneyReceipt> tableview;
    @FXML
    private TableColumn<MoneyReceipt, String> dateColumn;
    @FXML
    private TableColumn<MoneyReceipt, String> totalpriceColumn;
    @FXML
    private TableColumn<MoneyReceipt, String> drivernameColumn;
    @FXML
    private TableColumn<MoneyReceipt, String> contactColumn;

    ArrayList<MoneyReceipt> receiptList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        receiptList = new ArrayList<MoneyReceipt>();
        
        drivernameColumn.setCellValueFactory(new PropertyValueFactory<MoneyReceipt,String>("driverName"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<MoneyReceipt,String>("ContactNumber"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<MoneyReceipt,String>("date"));
        totalpriceColumn.setCellValueFactory(new PropertyValueFactory<MoneyReceipt,String>("totalprice"));    } 
    
    private void loadreportFile(){
        ObjectInputStream ois = null;
        try{
            MoneyReceipt i;
            ois = new ObjectInputStream(new FileInputStream("MoneyReceipt.bin"));
            while(true){
                i = (MoneyReceipt) ois.readObject();
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
    private void backOnclick(ActionEvent event) throws Exception{
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("AccountantDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();        
    }

    @FXML
    private void showallreciptOnclick(ActionEvent event) {
        loadreportFile();
    }
    
}
