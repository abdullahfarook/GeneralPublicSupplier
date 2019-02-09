package Controllers.Apllication.Stock;

import Controllers.Apllication.Orders.Add.AddOrderController;
import Controllers.Database;
import Controllers.JavafxLoader;
import Models.Factories;
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

public class SmallFirmMenuController implements Initializable {



    @FXML
    TableView<SmallFirms> tvSmallFirms;
    @FXML
    TableColumn<Object,Object> tcSmallFirmName;
    @FXML TableColumn<Object,Object> tcContractor;
    @FXML TableColumn<Object,Object> tcPhoneNumber;
    @FXML TableColumn<Object,Object> tcCity;
    @FXML TableColumn<Object,Object> tcState;
    @FXML TableColumn<Object,Object> tcLocation;



    @FXML
    public void btnRefreshOnAction(){
        ObservableList<SmallFirms> tableData = FXCollections.observableArrayList();
        Query query= Database.getEntityManager().createQuery("select sf from SmallFirms sf");
        List<SmallFirms> list=query.getResultList();
        tableData.addAll(list);

        tvSmallFirms.setItems(tableData);
        tcSmallFirmName.setCellValueFactory(new PropertyValueFactory<>("smallFirmName"));
        tcContractor.setCellValueFactory(new PropertyValueFactory<>("smallFirmContactorName"));
        tcPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("smallFirmNo"));
        tcCity.setCellValueFactory(new PropertyValueFactory<>("smallFirmCity"));
        tcState.setCellValueFactory(new PropertyValueFactory<>("smallFirmState"));
        tcLocation.setCellValueFactory(new PropertyValueFactory<>("smallFirmLocation"));
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
        JavafxLoader<AnchorPane,AddOrderController> addSmallFirm=new JavafxLoader<>("Application/Stock/Add/AddSmallFirm.fxml");
        addSmallFirm.getStage().initModality(Modality.APPLICATION_MODAL);
        addSmallFirm.show();
        addSmallFirm.getStage().setResizable(false);



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnRefreshOnAction();
    }
}
