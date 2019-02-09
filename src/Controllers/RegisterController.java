package Controllers;

import Models.Employees;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.persistence.EntityTransaction;
import java.net.URL;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {


    private Main main;
    private Stage currentStage;
    private Database database;



    @FXML
    private TextField tfUserName;
    @FXML
    private TextField tfPassword;
    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;
    @FXML
    private TextField tfPhoneNumber;
    @FXML
    private TextField tfCity;

    @FXML
    private TextField tfState;
    @FXML
    private TextField tfTitle;
    @FXML
    private TextField tfSalary;

    @FXML
    private TextField tfDateofJoin;


    @FXML
    private TextArea tfAddress;
    @FXML
    private ImageView usrImage;
    @FXML
    private Rectangle UsrImage;


    public void setMain(Main main, Stage currentStage)
    {
        this.main=main;
        this.currentStage =currentStage;
        this.database=main.database;
        tfDateofJoin.setText(new java.util.Date().toString());
    }


    @FXML
    public void btnAttacImage(){

    }

    @FXML
   public void btnRegister(){
        try {
            EntityTransaction tx= database.getEntityManager().getTransaction();
            tx.begin();
            Employees employees = new Employees();
            employees.setEmployeeFirstName(tfFirstName.getText());
            employees.setEmployeeLastName(tfLastName.getText());
            employees.setEmployeeHireDate(new java.sql.Date(new java.util.Date().getTime()));
            employees.setEmployeeCity(tfCity.getText());
            employees.setEmployeeLocation(tfAddress.getText());
            employees.setEmployeeTitle(tfTitle.getText());
            employees.setEmployeeNo(tfPhoneNumber.getText());
            employees.setEmployeeSallery(Integer.parseInt(tfSalary.getText()));
            employees.setEmployeeUser(tfUserName.getText());
            employees.setEmployeePass(tfPassword.getText());
            database.getEntityManager().persist(employees);
            tx.commit();

            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Register Successfull");
            alert.setContentText("Employee has been addeed with Name "+ employees.getEmployeeFirstName());
            alert.showAndWait();


        } catch (Exception e) {
            database.getEntityManager().getTransaction().rollback();
            e.printStackTrace();
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Registration Failed");
            alert.showAndWait();
        }

    }
    @FXML
   public void btnCancel(){
        main.primaryStage.show();
        currentStage.close();


    }

    public void clearFields()
    {
        tfSalary.clear();
        tfFirstName.clear();
        tfLastName.clear();
        tfAddress.clear();
        tfCity.clear();
        tfState.clear();
        tfPhoneNumber.clear();
        tfPassword.clear();
        tfUserName.clear();
        tfTitle.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfDateofJoin.setText(new java.util.Date().toString());
    }
}
