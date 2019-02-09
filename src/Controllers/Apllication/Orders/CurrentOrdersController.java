package Controllers.Apllication.Orders;


import Controllers.Apllication.Orders.Add.AddOrderController;
import Controllers.Database;
import Controllers.JavafxLoader;
import TableModels.CurrentOrdersTable;
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
import java.util.List;
import java.util.ResourceBundle;


public class CurrentOrdersController implements Initializable {


    @FXML
    TableView<Object> tvCurrentOrders;
    @FXML
    TableColumn<Object, Object> tcOrderId;
    @FXML
    TableColumn<Object, Object> tcCategory;


    @FXML
    TableColumn<Object, Object> tcDate;

    @FXML
    TableColumn<Object, Object> tcFactoryName;

    @FXML
    TableColumn<Object, Object> tcLaboratory;

    @FXML
    TableColumn<Object, Object> tcPriceUnit;

    @FXML
    TableColumn<Object, Object> tcProductName;
    @FXML
    TableColumn<Object, Object> tcQuantity;


    @FXML
    public void btnRefreshOnACtion() {
//        ObservableList<Object> tableData= FXCollections.observableArrayList();
//        Query query= Database.getEntityManager().createQuery("select po.orderId, pr.productName,l.laboratoryName,f.factoryName from Factories f, PurchaseOrder po, OrderDetails od, Products pr,Sample s,Laboratories l where f.factoryId=po.factoryId and po.orderId=s.orderId and s.laboratoryId=l.laboratoryId\n" +
//                "and po.orderId=od.orderId and od.productId=pr.productId");
//        List<PurchaseOrder> purchaseOrderlist=query.getResultList();
//
//
//        for(PurchaseOrder objects: purchaseOrderlist ){
//            tableData.add(new PurchaseOrder(objects.getOrderId(),objects.getEmployeeId(),objects.getFactoryId()));
//            tableData.add(objects[1]);
//            tableData.add(objects[2]);
//            tableData.add(objects[3]);
//        }
//
//        tvCurrentOrders.setItems(tableData);
//        tcOrderId.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
//        tcProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
//        tcLaboratory.setCellValueFactory(new PropertyValueFactory<> ("laboratoryName"));
//        tcFactoryName.setCellValueFactory(new PropertyValueFactory<>("factoryName"));


        ObservableList<Object> tableData = FXCollections.observableArrayList();
        Query query = Database.getEntityManager().createQuery("select distinct  f.factoryName, pr.productName,od.orderQuantity, od.unitPrice,  l.laboratoryName, po.orderDate  from Factories f, PurchaseOrder po, OrderDetails od, Products pr,Sample s,Laboratories l where pr.productId=od.productId and f.factoryId=po.factoryId and po.orderId=s.orderId and s.laboratoryId=l.laboratoryId");
        List<Object[]> list = query.getResultList();

        for (Object[] e : list) {
            String o = e[0].toString();
            String fn = e[1].toString();
            String p = e[2].toString();
            String q = e[3].toString();
            String pu = e[4].toString();
            String c = e[5].toString();
//            String l=e[6].toString();


            tableData.add(new CurrentOrdersTable(o, fn, p, q, pu, c));
        }
        tvCurrentOrders.setItems(tableData);
        tcFactoryName.setCellValueFactory(new PropertyValueFactory<>("factoryName"));
        tcProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tcQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tcPriceUnit.setCellValueFactory(new PropertyValueFactory<>("PricUnit"));
        tcLaboratory.setCellValueFactory(new PropertyValueFactory<>("laboratory"));
        tcDate.setCellValueFactory(new PropertyValueFactory<>("Date"));

    }


    @FXML
    public void btnUpdateOnAction() {

    }

    @FXML
    public void btnDeleteOnAction() {

    }

    @FXML
    public void btnSearch() {

    }

    @FXML
    public void btnAddNewOnAction() {
        JavafxLoader<AnchorPane, AddOrderController> addOrder = new JavafxLoader<>("Application/Orders/Add/AddOrder.fxml");
        addOrder.getStage().initModality(Modality.APPLICATION_MODAL);
        addOrder.show();
        addOrder.getStage().setResizable(false);


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnRefreshOnACtion();

    }
}
