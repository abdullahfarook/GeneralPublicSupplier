package Controllers.Apllication.Orders;

import Controllers.Apllication.Orders.Add.AddOrderController;
import Controllers.Database;
import Controllers.JavafxLoader;
import Controllers.Main;
import Models.Factories;
import Models.Laboratories;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class LaboratoriesMenuController {


    @FXML
    TableView<Laboratories> tvLaboratory;
    @FXML
    TableColumn<Object,Object> tcLaboratoryName;
    @FXML TableColumn<Object,Object> tcCity;
    @FXML TableColumn<Object,Object> tcState;
    @FXML TableColumn<Object,Object> tcLocation;
    @FXML TableColumn<Object,Object> tcSampleReport;

    private Main main;
    public void setMain(Main main)
    {
        this.main=main;
        btnRefreshOnAction();
    }
    @FXML
    public void btnRefreshOnAction(){
        ObservableList<Laboratories> tableData = FXCollections.observableArrayList();
        Query query= Database.getEntityManager().createQuery("select l from Laboratories  l");
        List<Laboratories> list=query.getResultList();

        tableData.addAll(list);



        tvLaboratory.setItems(tableData);
        tcLaboratoryName.setCellValueFactory(new PropertyValueFactory<>("laboratoryName"));
        tcCity.setCellValueFactory(new PropertyValueFactory<>("laboratoryCity"));
        tcState.setCellValueFactory(new PropertyValueFactory<>("laboratoryState"));
        tcLocation.setCellValueFactory(new PropertyValueFactory<>("laboratoryLocation"));
        tcSampleReport.setCellValueFactory(new PropertyValueFactory<>("sampleReport"));


    }
    @FXML
    public void btnAddOnAction(){
        JavafxLoader<AnchorPane,AddOrderController> addLaboratory=new JavafxLoader<>("Application/Orders/Add/AddLaboratory.fxml");
        addLaboratory.getStage().initModality(Modality.APPLICATION_MODAL);
        addLaboratory.show();
        addLaboratory.getStage().setResizable(false);
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

}
