
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class IssueBillReportController implements Initializable {

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
    private void showissuebillOnclick(ActionEvent event) {
        loadCreatbillFile();
    }
    
}
