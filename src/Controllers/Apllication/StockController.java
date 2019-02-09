package Controllers.Apllication;

import Controllers.Apllication.Orders.FactoriesMenuController;
import Controllers.Apllication.Orders.LaboratoriesMenuController;
import Controllers.Apllication.Orders.CurrentOrdersController;
import Controllers.Apllication.Stock.Add.AddCategoryController;
import Controllers.Apllication.Stock.CategoryMenuController;
import Controllers.Apllication.Stock.CurrentStockController;
import Controllers.Apllication.Stock.MarketMenuController;
import Controllers.Apllication.Stock.SmallFirmMenuController;
import Controllers.JavafxLoader;
import Controllers.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class StockController implements Initializable{

    private Main main;
    private Stage currentStage;
    @FXML
    private StackPane spMain;
    public void setMain(Main main, Stage stage){

        this.main=main;
        this.currentStage=stage;
    }
    @FXML
    public void btnStock(){
        JavafxLoader<AnchorPane,CurrentStockController> ordersMenu=new JavafxLoader<>("Application/Stock/CurrentStock.fxml");
        ordersMenu.getControllerCLass();
        spMain.getChildren().clear();
        spMain.getChildren().add(ordersMenu.getPane());
    }
    @FXML
    public void btnMarket()
    {
         JavafxLoader<AnchorPane,MarketMenuController> labMenu=new JavafxLoader<>("Application/Stock/ViewMarket.fxml");
        labMenu.getControllerCLass();
        spMain.getChildren().clear();
        spMain.getChildren().add(labMenu.getPane());

    }
    @FXML
    public void btnSmallFirm()
    {

        JavafxLoader<AnchorPane,SmallFirmMenuController>facMenu=new JavafxLoader<>("Application/Stock/ViewSmallFirm.fxml");
        facMenu.getControllerCLass();
        spMain.getChildren().clear();
        spMain.getChildren().add(facMenu.getPane());
    }
    @FXML
    public void btnCategory(){

        JavafxLoader<AnchorPane, CategoryMenuController> productMenu=new JavafxLoader<>("Application/Stock/ViewCategory.fxml");
        productMenu.getControllerCLass();
        spMain.getChildren().clear();
        spMain.getChildren().add(productMenu.getPane());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnStock();
    }
}