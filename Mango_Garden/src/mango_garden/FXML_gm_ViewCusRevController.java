/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mango_garden;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class FXML_gm_ViewCusRevController implements Initializable {

    @FXML
    private TableView<?> CustomerfeedBackTable;
    @FXML
    private TableColumn<?, ?> CusNameCol;
    @FXML
    private TableColumn<?, ?> MobNameCol;
    @FXML
    private TableColumn<?, ?> RatingCol;
    @FXML
    private TableColumn<?, ?> CommentCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnClickeGoBack(ActionEvent event) {
    }
    
}
