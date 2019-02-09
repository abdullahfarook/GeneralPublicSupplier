package Controllers.Apllication.Stock;

import Controllers.Apllication.Orders.Add.AddOrderController;
import Controllers.Database;
import Controllers.JavafxLoader;
import Models.Categores;
import Models.Factories;
import TableModels.CategoryTable;
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

public class CategoryMenuController implements Initializable {

    @FXML
    TableView<CategoryTable> tvCategory;
    @FXML
    TableColumn<Object,Object> tcCategoryName;
    @FXML
    TableColumn<Object,Object> tcProductName ;
    @FXML
    TableColumn<Object,Object> tcDimensions;
    @FXML
    TableColumn<Object,Object> tcWeightUnit;
    @FXML
    TableColumn<Object,Object> tcColor ;

    @FXML
    public void btnRefreshOnAction(){

        ObservableList<CategoryTable> tableData = FXCollections.observableArrayList();
        Query query= Database.getEntityManager().createQuery("select c.categoryName, p.productName,cd.dimensions,cd.weightPerUnit,cd.colors from Products p, Categores c, CategoryDesc cd where c.productId=p.productId and c.categoryId=cd.categoryId");
        List<Object[]> list=query.getResultList();
for(Object[] l:list){

    tableData.add(new CategoryTable(l[0].toString(),l[1].toString(),l[2].toString(),l[3].toString(),l[4].toString()));
}

        tvCategory.setItems(tableData);
        tcCategoryName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        tcProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tcDimensions.setCellValueFactory(new PropertyValueFactory<>("dimensions"));
        tcWeightUnit.setCellValueFactory(new PropertyValueFactory<>("weightPerUnit"));
        tcColor.setCellValueFactory(new PropertyValueFactory<>("colors"));


    }

    @FXML
    public void btnAddOnAction(){
        JavafxLoader<AnchorPane,AddOrderController> addCategory=new JavafxLoader<>("Application/Stock/Add/AddCategory.fxml");
        addCategory.getStage().initModality(Modality.APPLICATION_MODAL);
        addCategory.show();
        addCategory.getStage().setResizable(false);

    }
    @FXML
    public void btnUpdateOnAction(){

    }

    @FXML
    public void btnSearch(){

    }

    @FXML
    public void btnDeleteOnAction(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnRefreshOnAction();

    }
}
