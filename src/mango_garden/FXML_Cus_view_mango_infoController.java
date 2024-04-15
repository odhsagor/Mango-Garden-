/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mango_garden;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class FXML_Cus_view_mango_infoController implements Initializable {

    @FXML
    private TextArea mango_info;
    @FXML
    private TextField code;
    
    ArrayList<product>cartItem = new ArrayList<product>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ArrayList<product>mList = product.listOfProductInfo();
        
        mango_info.setText("");
        for(product m: mList){
            mango_info.appendText(m.toString());
//            System.out.println(m.toString());
        }
    }    

    @FXML
    private void onClickAddButton(ActionEvent event) {
        ArrayList<product>mlist = product.listOfProductInfo();
        for(product m: mlist){
            if(m.getProd_code()==Integer.parseInt(code.getText())){
                cartItem.add(m);
            }
        }
        code.setText(null);
    }

    @FXML
    private void onClickViewCart(ActionEvent event) {
        
    }

    @FXML
    private void onClickBackButton(ActionEvent event) {
        
    }
    
}
