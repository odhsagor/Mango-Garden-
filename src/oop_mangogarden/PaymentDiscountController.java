
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


public class PaymentDiscountController implements Initializable {

    @FXML
    private TableView<PaymentDiscount> tableview;
    @FXML
    private TableColumn<PaymentDiscount, String> invoicenoColumn;
    @FXML
    private TableColumn<PaymentDiscount, String> quantityColumn;
    @FXML
    private TableColumn<PaymentDiscount, String> priceColumn;
    @FXML
    private TableColumn<PaymentDiscount, String> discountColumn;
    @FXML
    private TableColumn<PaymentDiscount, String> totalpriceColumn;
    @FXML
    private TextField invoiceTextfield;
    @FXML
    private TextField quantityTextfield;
    @FXML
    private TextField discountTextfield;
    
    ArrayList<PaymentDiscount> discountList;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        discountList = new ArrayList<PaymentDiscount>();
        
        invoicenoColumn.setCellValueFactory(new PropertyValueFactory<PaymentDiscount,String>("invoiceNo"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<PaymentDiscount,String>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<PaymentDiscount,String>("price"));
        discountColumn.setCellValueFactory(new PropertyValueFactory<PaymentDiscount,String>("discount"));
        totalpriceColumn.setCellValueFactory(new PropertyValueFactory<PaymentDiscount,String>("totalprice"));

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
    private void saveOnclick(ActionEvent event) throws IOException{
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f = new File("Discount.bin");
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            //int price = 1000;
            int Quantity = Integer.parseInt(quantityTextfield.getText());
            int Discount = Integer.parseInt(discountTextfield.getText());
            int price = 1000*Quantity;
            int totalprice = price - Discount;
            
            PaymentDiscount d = new PaymentDiscount(invoiceTextfield.getText(), 
                    Integer.parseInt(quantityTextfield.getText()), price,
                    Integer.parseInt(discountTextfield.getText()), totalprice );
            
            oos.writeObject(d); 
            
            invoiceTextfield.clear(); quantityTextfield.clear();
            discountTextfield.clear();
            
            fos.close();
            oos.close();
            
        }
        catch(IOException e){
            Logger.getLogger(PaymentDiscountController.class.getName()).log(Level.SEVERE, null, e);
    
        }
        finally{
            try{
                if(oos != null) oos.close();
            }
            catch(IOException e){
                Logger.getLogger(PaymentDiscountController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    private void loadDiscountFile(){
        ObjectInputStream ois = null;
        try{
            PaymentDiscount i;
            ois = new ObjectInputStream(new FileInputStream("Discount.bin"));
            while(true){
                i = (PaymentDiscount) ois.readObject();
                tableview.getItems().add(i);
                System.out.println(i);
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
    private void showpaymentOnclick(ActionEvent event) {
        loadDiscountFile();
 
    }
    
}
