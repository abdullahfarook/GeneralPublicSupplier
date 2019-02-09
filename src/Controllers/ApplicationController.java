package Controllers;

import Controllers.Apllication.EmployeesController;
import Controllers.Apllication.HomeController;
import Controllers.Apllication.OrdersController;
import Controllers.Apllication.StockController;
import Models.Employees;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class ApplicationController implements Initializable {
    private Main main;
    private Stage currentStage;
    private Database database;
    private Employees employee;


    @FXML
    private Label lblUsrName;
    @FXML
    private StackPane acContent;


    public void setMain(Main main, Stage currentStage, Employees employees)
    {
        this.main=main;
        this.currentStage =currentStage;
        this.database=main.database;
        this.employee=employees;
        String label=employee.getEmployeeFirstName()+" "+employee.getEmployeeLastName();
        lblUsrName.setText(label);
    }


    @FXML
     public void btnHomeOnClick() {
        JavafxLoader<AnchorPane,HomeController> home=new JavafxLoader<>("Application/Home.fxml");
        home.show();


    }

    @FXML
    public void btnOrdersOnClick() {
        JavafxLoader<AnchorPane,OrdersController> orders=new JavafxLoader<>("Application/Orders.fxml");
        acContent.getChildren().clear();
        acContent.getChildren().add(orders.getPane());

    }
    @FXML
    public void btnEmplopyeOnClick() {

JavafxLoader<AnchorPane,EmployeesController> employee =new JavafxLoader<>("Application/ViewEmployee.fxml");
       acContent.getChildren().clear();
        acContent.getChildren().add(employee.getPane());
    }
    @FXML
    public void btnStockOnClick() {
        JavafxLoader<AnchorPane,StockController> stock=new JavafxLoader<>("Application/Stock.fxml");
        acContent.getChildren().clear();
        acContent.getChildren().add(stock.getPane());

    }

    @FXML
    public void btnAboutOnClick() {

    }
    @FXML
    public void btnReportsOnClick() {

    }
    @FXML
    public void hlUpdateAccount() {

    }
    @FXML
    public void btnLogOut() {
        currentStage.close();
        main.primaryStage.show();

    }
    @FXML
    public void mbtnOnClick() {

    }
    @FXML
    public void sideMenuToogleBtnOnCLick() {

    }
    @FXML
    public void acMain() {

    }
    @FXML
    public void acMainOnMouseMove() {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
