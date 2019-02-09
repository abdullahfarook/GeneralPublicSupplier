package Controllers.Apllication.Stock;


import Controllers.Database;
import Models.Categores;
import Models.Factories;
import Models.Products;
import TableModels.CategoryTable;
import TableModels.CurrentStockTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.Query;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CurrentStockController implements Initializable {


    @FXML
    TableView<CurrentStockTable> tvCurrentStock;
    @FXML
    TableColumn<Object,Object> tcOrderID;
    @FXML
    TableColumn<Object,Object> tcProductID;
    @FXML
    TableColumn<Object,Object> tcProductName;
    @FXML
    TableColumn<Object,Object> tcQuantityStock;
    @FXML
    TableColumn<Object,Object> tcStockPriceUnit;
    @FXML
    TableColumn<Object,Object> tcQuantityOrder;
    @FXML
    TableColumn<Object,Object> tcOrderPrice;
    @FXML
    TableColumn<Object,Object> tcCategory;


    @FXML
    private ComboBox<Factories> cbFactoryName;
    @FXML
    private ComboBox<Products> cbProductName;
    @FXML
    private ComboBox cbManufacture;
    @FXML
    private ComboBox<Categores> cbCategory;

    @FXML
    public void btnRefreshOnACtion(){
        ObservableList<CurrentStockTable> tableData = FXCollections.observableArrayList();
        Query query= Database.getEntityManager().createQuery("select od.orderId, p.productId," +
                "p.productName,p.unitsInStock,p.pricePerUnit, p.unitsOnOrder,p.pricePerUnit,c.categoryName\n" +
                " from Products p,OrderDetails od,Categores c");
        List<Object[]> list=query.getResultList();
        for(Object[] l:list) {

            tableData.add(new CurrentStockTable(l[0].toString(),l[1].toString(),
                    l[2].toString(),l[3].toString(),l[4].toString(),l[5].toString(),
                    l[6].toString(),l[7].toString()));
        }

        tvCurrentStock.setItems(tableData);
        tcOrderID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        tcProductID.setCellValueFactory(new PropertyValueFactory<>("productID"));
        tcProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tcQuantityStock.setCellValueFactory(new PropertyValueFactory<>("quantityStock"));
        tcStockPriceUnit.setCellValueFactory(new PropertyValueFactory<>("stockPriceUnit"));
        tcQuantityOrder.setCellValueFactory(new PropertyValueFactory<>("quantityOrder"));
        tcOrderPrice.setCellValueFactory(new PropertyValueFactory<>("orderPriceUnit"));
        tcCategory.setCellValueFactory(new PropertyValueFactory<>("category"));


    }

    @FXML
    public void btnComplete(){

    }
    @FXML
    public void btnUpdateOnAction(){

    }


    @FXML
    public void btnSearch(){

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnRefreshOnACtion();

    }

}
