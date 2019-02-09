package Controllers.Apllication;

import Controllers.Apllication.Orders.FactoriesMenuController;
import Controllers.Apllication.Orders.LaboratoriesMenuController;
import Controllers.Apllication.Orders.CurrentOrdersController;
import Controllers.JavafxLoader;
import Controllers.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class OrdersController implements Initializable {

    private Main main;
    private Stage currentStage;
    @FXML
    private StackPane spMain;
    public void setMain(Main main, Stage stage){

        this.main=main;
        this.currentStage=stage;
        btnOrders();
    }
    @FXML
    public void btnOrders(){
        JavafxLoader<AnchorPane,CurrentOrdersController> ordersMenu=new JavafxLoader<>("Application/Orders/CurrentOrders.fxml");
        spMain.getChildren().clear();
        spMain.getChildren().add(ordersMenu.getPane());
    }
    @FXML
    public void btnLaboratories()
    {
        JavafxLoader<AnchorPane,LaboratoriesMenuController> labMenu=new JavafxLoader<>("Application/Orders/ViewLaboratories.fxml");
        labMenu.getControllerCLass().setMain(main);
        spMain.getChildren().clear();
        spMain.getChildren().add(labMenu.getPane());

    }
    @FXML
    public void btnFactories()
    {

        JavafxLoader<AnchorPane,FactoriesMenuController>facMenu=new JavafxLoader<>("Application/Orders/ViewFactories.fxml");
        facMenu.getControllerCLass().setMain(main);
        spMain.getChildren().clear();
        spMain.getChildren().add(facMenu.getPane());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnOrders();
    }
}