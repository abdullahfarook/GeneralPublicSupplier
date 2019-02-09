package Controllers;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;


public class Main extends Application {

    Stage primaryStage;
    Database database;

    @Override
    public void start(Stage primaryStage)  {
        JavafxLoader<Parent, LoginController> login = new JavafxLoader<>("Login.fxml");
        login.setStage(primaryStage);
        Database db=new Database();
        db.DatabaseConnect();
        this.primaryStage=login.getStage();
        login.getControllerCLass().setMain(this,database);
        login.getStage().setResizable(false);
        login.show();


    }
    public static void main(String[] args)
    {

        launch(args);
    }
}
