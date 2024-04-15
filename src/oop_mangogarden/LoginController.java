
package oop_mangogarden;

import SupplyChainManager_Sagor.SupplyChainManager;
import horticulturist_Sagor.horticulturist;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mango_garden.gardenmanager;


public class LoginController implements Initializable {

    @FXML
    private TextField nameTextfield;
    @FXML
    private TextField idTextfield;
    @FXML
    private ComboBox<String> employeetypeCombobox;
    @FXML
    private TextField passwordTextfield;
    

 

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        employeetypeCombobox.getItems().addAll("Accountant", "Transport Operator",
                "Garden Manager", "Supply Chain Manager", "IT Admin", "Horticulturist","CEO");

    }    

    @FXML
    private void loginOnclick(ActionEvent event) throws Exception{
        try{
            ObjectInputStream log = new ObjectInputStream(new FileInputStream("Login.bin"));
            Employee emp;
            while(true){
                emp = (Employee) log.readObject();
                
                if (emp.isemployeeType(employeetypeCombobox.getValue()) && 
                        emp.isemployeeName(nameTextfield.getText()) && 
                        emp.isemployeeID(idTextfield.getText()) &&
                        emp.isPassword(passwordTextfield.getText()))
                {
                    System.out.println("Log in Successful");
                    String option = this.employeetypeCombobox.getValue();
                    if(option.equalsIgnoreCase("Accountant")){
                        accountant a1 = new accountant(emp.getEmployeeType(),
                        emp.getEmployeeName(), emp.getEmployeeID(), emp.getPassword());
                        loginAccountant(a1);
                    }
                    
                    if(option.equalsIgnoreCase("Transport Operator")){
                        transportOperator b1 = new transportOperator(emp.getEmployeeType(),
                        emp.getEmployeeName(), emp.getEmployeeID(), emp.getPassword());
                        loginTransportOperator(b1);
                        
                    }
                    
                    if(option.equalsIgnoreCase("Supply Chain Manager")){
                        SupplyChainManager c1 = new SupplyChainManager(emp.getEmployeeType(),
                        emp.getEmployeeName(), emp.getEmployeeID(), emp.getPassword());
                        loginSupplyChainManager(c1);
                        
                    }
                    
                    if(option.equalsIgnoreCase("Horticulturist")){
                        horticulturist d1 = new horticulturist(emp.getEmployeeType(),
                        emp.getEmployeeName(), emp.getEmployeeID(), emp.getPassword());
                        loginHorticulturist(d1);
                        
                    }
                    
                    if(option.equalsIgnoreCase("Garden Manager")){
                        gardenmanager e1 = new gardenmanager(emp.getEmployeeType(),
                        emp.getEmployeeName(), emp.getEmployeeID(), emp.getPassword());
                        loginGardenManager(e1);
                        
                    }

                }
            }
        }
        catch(Exception e){
            
        }
   }
    
    public void loginGardenManager(gardenmanager a)throws Exception{
       Stage stage = (Stage) idTextfield.getScene().getWindow();
       stage.close();
       Stage primarystage = new Stage();
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("/mango_garden/FXML_gm_Dashboard.fxml"));
       Parent root = loader.load();
       primarystage.setTitle("Garden Manager");
       Scene scene = new Scene(root,630,430);
       primarystage.setScene(scene);
       primarystage.show();
   }
    
    public void loginHorticulturist(horticulturist a)throws Exception{
       Stage stage = (Stage) idTextfield.getScene().getWindow();
       stage.close();
       Stage primarystage = new Stage();
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("/horticulturist_Sagor/mainHorticulturist.fxml"));
       Parent root = loader.load();
       primarystage.setTitle("Horticulturist");
       Scene scene = new Scene(root,630,430);
       primarystage.setScene(scene);
       primarystage.show();
   }
    
    public void loginSupplyChainManager(SupplyChainManager a)throws Exception{
       Stage stage = (Stage) idTextfield.getScene().getWindow();
       stage.close();
       Stage primarystage = new Stage();
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("/SupplyChainManager_Sagor/mainSupplyChainManager.fxml"));
       Parent root = loader.load();
       primarystage.setTitle("Supply Chain Manager");
       Scene scene = new Scene(root,630,430);
       primarystage.setScene(scene);
       primarystage.show();
   }
    
    public void loginAccountant(accountant a)throws Exception{
       Stage stage = (Stage) idTextfield.getScene().getWindow();
       stage.close();
       Stage primarystage = new Stage();
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("AccountantDashboard.fxml"));
       Parent root = loader.load();
       primarystage.setTitle("Accountant");
       Scene scene = new Scene(root,630,430);
       primarystage.setScene(scene);
       primarystage.show();
   } 
   
    public void loginTransportOperator(transportOperator a) throws Exception{
        Stage stage = (Stage) idTextfield.getScene().getWindow();
        stage.close();
        Stage primarystage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TransportOperatorDashboard.fxml"));
        Parent root = loader.load();
        primarystage.setTitle("Transport Operator");
        Scene scene = new Scene(root,630,430);
        primarystage.setScene(scene);
        primarystage.show();
        
    }
   
    @FXML
    private void createaccOnclick(ActionEvent event) throws Exception{
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("FXMLCreateAccount.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }
    
}

