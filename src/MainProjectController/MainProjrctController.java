
package MainProjectController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainProjrctController extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/oop_mangogarden/Login.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/SupplyChainManager_Sagor/inventoryTrackingDashboard.fxml"));        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
