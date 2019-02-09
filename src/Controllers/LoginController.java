package Controllers;


import Models.Employees;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.persistence.Query;
import java.util.List;


public class LoginController {
    private Main main;
    private Database database;
    private Stage currentStage;

    private Employees employee;
    @FXML
    private TextField usertextField;
    @FXML
    private PasswordField passField;
    @FXML
    private ProgressIndicator progressIndicator=new ProgressIndicator();

    public void setMain(Main main, Database database) {

        this.main = main;
        this.database = database;
        this.currentStage=main.primaryStage;
    }


    @FXML
    public void btnLogin() throws Exception {
        boolean validate=validateLogin();
        Stage applicationStage;
        if (validate == true) {
            JavafxLoader<AnchorPane,ApplicationController> app=new JavafxLoader<>("Application.fxml");
            app.getStage().setMaximized(true);
            applicationStage =app.getStage();

            Alert alert= new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Login Successfull");
            alert.setContentText("Welcome "+ employee.getEmployeeFirstName());

            main.primaryStage.close();
            app.getControllerCLass().setMain(main, applicationStage, employee);
            app.show();
            alert.showAndWait();

        }
        if (validate == false) {
            System.out.printf("Either Username or Password is incorrect");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Login Error");
            alert.setContentText("Either Username or Password is incorrect");
            alert.showAndWait();
        }
    }

    public boolean validateLogin() {
        String user = this.usertextField.getText();
        String pass = this.passField.getText();



        Query query = Database.getEntityManager().createQuery("select e from Employees e");
        List<Employees> employeesCollection =query.getResultList();
        for (Employees employees : employeesCollection) {
            if (user.equals(employees.getEmployeeUser()) && pass.equals(employees.getEmployeePass())) {
                System.out.printf("ID match for " + employees.getEmployeeFirstName());
                this.employee = employees;
                return true;

            } else {
                System.out.println("ID failed for " + employees.getEmployeeFirstName());
            }
        }
        return false;
    }

    @FXML
    public void btnRegister(){

        JavafxLoader<AnchorPane,RegisterController> register=new JavafxLoader<>("Register.fxml");
        Stage registerStage=register.getStage();
        register.getControllerCLass().setMain(main,registerStage);
        currentStage.close();
        register.show();

    }
}

