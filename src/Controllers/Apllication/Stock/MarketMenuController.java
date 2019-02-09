package Controllers.Apllication.Stock;

import Controllers.Apllication.Orders.Add.AddOrderController;
import Controllers.Database;
import Controllers.JavafxLoader;
import Models.Factories;
import Models.Markets;
import Models.SmallFirms;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

import javax.persistence.Query;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarketMenuController implements Initializable{

    @FXML
    TableView<Markets> tvMarket;

    @FXML
    TableColumn<Object,Object> tcMarketName ;
    @FXML
    TableColumn<Object,Object> tcCity;

    @FXML
    TableColumn<Object,Object> tcGoods ;
    @FXML
    TableColumn<Object,Object> tcLocation ;

    @FXML
    public void btnRefreshOnAction(){
        ObservableList<Markets> tableData = FXCollections.observableArrayList();
        Query query= Database.getEntityManager().createQuery("select m from Markets m");
        List<Markets> list=query.getResultList();
        tableData.addAll(list);
        tvMarket.setItems(tableData);
        tcMarketName.setCellValueFactory(new PropertyValueFactory<>("marketName"));
        tcCity.setCellValueFactory(new PropertyValueFactory<>("marketCity"));
        tcLocation.setCellValueFactory(new PropertyValueFactory<>("marketLocation"));
        tcGoods.setCellValueFactory(new PropertyValueFactory<>("goodsAvailable"));
    }

    @FXML
    public void btnUpdateOnAction(){

    }
    @FXML
    public void btnDeleteOnAction(){

    }
    @FXML
    public void btnSearch(){

    }
    @FXML
    public void btnAddOnAction(){
        JavafxLoader<AnchorPane,AddOrderController> addMarket=new JavafxLoader<>("Application/Stock/Add/AddMarket.fxml");
        addMarket.getStage().initModality(Modality.APPLICATION_MODAL);
        addMarket.show();
        addMarket.getStage().setResizable(false);


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnRefreshOnAction();
    }
}
