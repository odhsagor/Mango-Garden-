
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
//import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class SalaryReportController implements Initializable {
    @FXML
    private TableView<Salary> tableview;
    @FXML
    private TableColumn<Salary, String> employeetypeColumn;
    @FXML
    private TableColumn<Salary, String> idColumn;
    @FXML
    private TableColumn<Salary, String> salaryColumn;
    @FXML
    private TableColumn<Salary, String> employeenameColmun;
 
    ArrayList<Salary> salaryList;   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        salaryList = new ArrayList<Salary>();

        
        employeetypeColumn.setCellValueFactory(new PropertyValueFactory<Salary,String>("employeeType"));
        employeenameColmun.setCellValueFactory(new PropertyValueFactory<Salary,String>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Salary,String>("ID"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Salary,String>("salary"));

    }
    
    @FXML
    private void backOnclick(ActionEvent event) throws Exception{
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("AccountantDashboard.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1);
        window.show();
    }

        private void loadSalaryFile(){
        ObjectInputStream ois = null;
        try{
            Salary i;
            ois = new ObjectInputStream(new FileInputStream("Salary.bin"));
            while(true){
                i = (Salary) ois.readObject();
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
        loadSalaryFile();
    }
    
}
