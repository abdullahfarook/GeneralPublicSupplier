package Controllers.Apllication;

import Controllers.Database;
import Controllers.JavafxLoader;
import Controllers.Main;
import Controllers.RegisterController;
import Models.Employees;
import Models.Factories;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeesController implements Initializable {

    @FXML
    TextArea taAddress;
    @FXML Button btnDelete;
    @FXML
    TableView<Employees> tvEmployee;
    @FXML
    TableColumn<Object,Object> tcID;
    @FXML
    TableColumn<Object,Object> tcEmployeeList;


    @FXML TextField tfTitle;
    @FXML TextField tfLocation;
    @FXML
    private TextField tfSearch;
    @FXML
    private TextField tfUserName ;

    @FXML
    private TextField tfFullName ;
    @FXML
    private TextField tfPhoneNumber ;
    @FXML
    private TextField tfSalary;
    @FXML
    private TextField tfDateofJoin ;
    @FXML
    public void btnSearch(){
        String variable=tfSearch.getText().toString();
        ObservableList<Employees> tableData = FXCollections.observableArrayList();
        Query query= Database.getEntityManager().createQuery("select e from Employees e where e.employeeFirstName=?1");
        query.setParameter(1,variable);
        List<Employees> employeeList=query.getResultList();
        tableData.addAll(employeeList);

        tvEmployee.setItems(tableData);
        tcID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        tcEmployeeList.setCellValueFactory(new PropertyValueFactory<>("employeeFirstName"));


    }
    public void btnCreate(){

    }

    public void main(){

        ObservableList<Employees> tableData = FXCollections.observableArrayList();
        Query query= Database.getEntityManager().createQuery("select e from Employees e");
        List<Employees> employeeList=query.getResultList();
        tableData.addAll(employeeList);

        tvEmployee.setItems(tableData);
        tcID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        tcEmployeeList.setCellValueFactory(new PropertyValueFactory<>("employeeFirstName"));
        tvEmployee.getSelectionModel().selectedItemProperty().addListener(
                (v,oldValue,newValue)->employeeDetails(newValue)

        );

    }
    public void tfSearchOnAction(){

    }
    @FXML
    public void btnAttachImageOnAction(){

    }
    @FXML
    public void hlChangePasswordOnAction(){

    }
    @FXML
    public void btnUpdateOnAction()  {
//        tvEmployee.getSelectionModel().selectedItemProperty().addListener(
//                (observable,oldValue,newValue)->( update(newValue))
//
//
//        );

    }

    @FXML
    public void btnDeleteOnAction() {


//        tvEmployee.getSelectionModel().selectedItemProperty().addListener(
//                (o,oldValue,newValue)-> delete(newValue));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        main();
    }
    public void employeeDetails(Employees employees){

        tfSearch.setText(employees.getEmployeeFirstName());
        tfUserName.setText(employees.getEmployeeUser());
        tfFullName.setText(employees.getEmployeeFirstName()+ " " +employees.getEmployeeLastName());
        tfPhoneNumber.setText(employees.getEmployeeNo());
        tfSalary.setText(employees.getEmployeeSallery().toString());
        tfDateofJoin.setText(employees.getEmployeeHireDate().toString());
        tfTitle.setText(employees.getEmployeeTitle());
        tfLocation.setText(employees.getEmployeeCity());
        taAddress.setText(employees.getEmployeeLocation());
    }

    public void update(Employees employees)
   {
//        Database.getEntityManager().getTransaction().begin();
//        Database.getEntityManager().find(employees.getClass(),employees.getEmployeeId());
//        employees.setEmployeeFirstName();
//
//
   }

    public void delete(Employees employees)
    {
        try{
        EntityTransaction tx= Database.getEntityManager().getTransaction();
                tx.begin();
            System.out.println(Database.getEntityManager().contains(employees));
           Database.getEntityManager().remove(employees);

        tx.commit();
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Employees Removed Successfully");
            alert.showAndWait();
            main();


    } catch (Exception e) {
        Database.getEntityManager().getTransaction().rollback();
        e.printStackTrace();
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Removing Failed");
        alert.showAndWait();
    }
    }
}
