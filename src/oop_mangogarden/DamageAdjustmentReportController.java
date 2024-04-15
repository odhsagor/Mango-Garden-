
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

public class DamageAdjustmentReportController implements Initializable {

    @FXML
    private TableView<DamageAdjust> tableview;
    @FXML
    private TableColumn<DamageAdjust, String> drivernameColumn;
    @FXML
    private TableColumn<DamageAdjust, String> platenoColumn;
    @FXML
    private TableColumn<DamageAdjust, String> dateColumn;
    @FXML
    private TableColumn<DamageAdjust, String> destinationColumn;
    @FXML
    private TableColumn<DamageAdjust, String> productidColumn;
    @FXML
    private TableColumn<DamageAdjust, String> quantityColumn;
    @FXML
    private TableColumn<DamageAdjust, String> damagequantityColumn;
    @FXML
    private TableColumn<DamageAdjust, String> adjustmentCOlumn;

    ArrayList<DamageAdjust> damageList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        damageList = new ArrayList<DamageAdjust>();
        
        drivernameColumn.setCellValueFactory(new PropertyValueFactory<DamageAdjust,String>("Drivername"));
        platenoColumn.setCellValueFactory(new PropertyValueFactory<DamageAdjust,String>("plateno"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<DamageAdjust,String>("date"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<DamageAdjust,String>("destination"));
        productidColumn.setCellValueFactory(new PropertyValueFactory<DamageAdjust,String>("productID"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<DamageAdjust,String>("quantity"));
        damagequantityColumn.setCellValueFactory(new PropertyValueFactory<DamageAdjust,String>("damagequantity"));
        adjustmentCOlumn.setCellValueFactory(new PropertyValueFactory<DamageAdjust,String>("adjustment"));
        
    }    

    @FXML
    private void backOnclick(ActionEvent event) throws Exception{
             Parent mainSceneParent = FXMLLoader.load(getClass().getResource("TransportOperatorDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();   
    }
    
    private void loadDamageFile(){
        ObjectInputStream ois = null;
        try{
            DamageAdjust i;
            ois = new ObjectInputStream(new FileInputStream("Damage.bin"));
            while(true){
                i = (DamageAdjust) ois.readObject();
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
    private void showreportOnclick(ActionEvent event) {
                loadDamageFile();

    }
    
}
