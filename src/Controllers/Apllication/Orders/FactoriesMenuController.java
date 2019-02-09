package Controllers.Apllication.Orders;

import Controllers.Apllication.Orders.Add.AddOrderController;
import Controllers.Database;
import Controllers.JavafxLoader;
import Controllers.Main;
import Models.Employees;
import Models.Factories;
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
import javax.persistence.criteria.CriteriaBuilder;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Sunny on 2/14/2016.
 */
public class FactoriesMenuController implements Initializable {

    @FXML
    TableView<Factories> tvFactory;
    @FXML
    TableColumn<Object,Object> tcPhoneNumber;
    @FXML
    TableColumn<Object,Object> tcFactoryName ;
    @FXML
    TableColumn<Object,Object> tcCity;
    @FXML
    TableColumn<Object,Object> tcMajor;
    @FXML
    TableColumn<Object,Object> tcContractor ;
    @FXML
    TableColumn<Object,Object> tcLocation ;








    private Main main;
    public void setMain(Main main)
    {
        this.main=main;
        btnRefreshOnAction();
    }
    @FXML
    public void btnRefreshOnAction(){

        ObservableList<Factories> tableData = FXCollections.observableArrayList();
        Query query= Database.getEntityManager().createQuery("select f from Factories f");
        List<Factories> list=query.getResultList();
        ArrayList<Factories> factories =new ArrayList<>(list);
        tableData.addAll(factories);



        tvFactory.setItems(tableData);
        tcFactoryName.setCellValueFactory(new PropertyValueFactory<>("factoryName"));
        tcContractor.setCellValueFactory(new PropertyValueFactory<>("factoryContractorName"));
        tcPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("factoryNo"));
        tcCity.setCellValueFactory(new PropertyValueFactory<>("factoryCity"));
        tcLocation.setCellValueFactory(new PropertyValueFactory<>("factoryLocation"));
        tcMajor.setCellValueFactory(new PropertyValueFactory<>("factoryMajor"));


    }
    @FXML
    public void btnAddBrandOnAction(){

    }
    @FXML
    public void btnUpdateOnAction(){

    }
    @FXML
    public void btnDeleteOnAction(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public void btnSearch(){


    }
    @FXML
    public void btnAddOnAction(){
        JavafxLoader<AnchorPane,AddOrderController> addFactory=new JavafxLoader<>("Application/Orders/Add/AddFactory.fxml");
        addFactory.getStage().initModality(Modality.APPLICATION_MODAL);
        addFactory.show();
        addFactory.getStage().setResizable(false);
    }
}
