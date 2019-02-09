package Controllers;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public  class JavafxLoader<Pane extends Parent, ControllerClass> {
    private Pane pane;
    private ControllerClass controllerCLass;
    private String location;
    private Scene scene;
    private Stage stage = new Stage();

    public JavafxLoader(String location)  {
        try {
            this.location = location;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/" + location));
            this.pane = loader.load();
            this.scene = new Scene(pane);
            this.controllerCLass = loader.getController();
            this.stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        stage.close();
    }

    public void show() {
        stage.show();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        stage.setScene(scene);
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public Stage getStage() {
        return stage;
    }

    public ControllerClass getControllerCLass() {
        return controllerCLass;
    }
}

