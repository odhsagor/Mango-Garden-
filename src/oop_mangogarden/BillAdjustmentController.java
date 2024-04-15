
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


public class BillAdjustmentController implements Initializable {

    @FXML
    private TextField orderidTextfield;
    @FXML
    private TableView<Adjustment> tableview;
    @FXML
    private TableColumn<Adjustment, String> quantityColumn;
    @FXML
    private TableColumn<Adjustment, Float> totalpriceColumn;
    @FXML
    private TableColumn<Adjustment, String> paidColumn;
    @FXML
    private TableColumn<Adjustment, String> dueColumn;
    @FXML
    private TextField quantityTextfield;
    @FXML
    private TextField paidTYextfield;
    @FXML
    private TextField dueTextfield;
    @FXML
    private TableColumn<Adjustment, String> invoiceColumn;
    
    ArrayList<Adjustment> adjustList;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        adjustList = new ArrayList<Adjustment>();
        
        invoiceColumn.setCellValueFactory(new PropertyValueFactory<Adjustment,String>("invoiceno"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Adjustment,String>("quantity"));
        totalpriceColumn.setCellValueFactory(new PropertyValueFactory<Adjustment,Float>("total"));
        paidColumn.setCellValueFactory(new PropertyValueFactory<Adjustment,String>("paid"));
        dueColumn.setCellValueFactory(new PropertyValueFactory<Adjustment,String>("due"));
        
   }    

    @FXML
    private void backOnclick(ActionEvent event) throws Exception {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("AccountantDashboard.fxml"));
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
            f = new File("BillAdjust.bin");
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
//String invoiceno, String quantity, int paid, int due
            Float total = 100.00f;

            Adjustment d = new Adjustment(orderidTextfield.getText(), quantityTextfield.getText(),total,
                    Integer.parseInt(paidTYextfield.getText()), Integer.parseInt(dueTextfield.getText()));
            System.out.println(  d);
            oos.writeObject(d); 
            
            orderidTextfield.clear(); quantityTextfield.clear();
            paidTYextfield.clear(); dueTextfield.clear();
            
            fos.close();
            oos.close();
            
        }
        catch(IOException e){
            Logger.getLogger(BillAdjustmentController.class.getName()).log(Level.SEVERE, null, e);
    
        }
        finally{
            try{
                if(oos != null) oos.close();
            }
            catch(IOException e){
                Logger.getLogger(BillAdjustmentController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    
    private void loadAdjustFile(){
        ObjectInputStream ois = null;
        try{
            Adjustment i;
            ois = new ObjectInputStream(new FileInputStream("BillAdjust.bin"));
            while(true){
                i = (Adjustment) ois.readObject();
                System.out.println(i);
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
    private void showadjustbillOnclick(ActionEvent event) throws IOException{
        loadAdjustFile();

    }

    
}
