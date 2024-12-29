package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Default extends Application {

  @Override
  public void start(Stage stage) {
    Label title = new Label("Port Scanner");


    String javaVersion = System.getProperty("java.version");
    String javafxVersion = System.getProperty("javafx.version");
    Label debug = new Label("JavaFX Version " + javafxVersion + " | Java Version: " + javaVersion);

    /* vbox is like a div in HTML - here you can place  */
    VBox centerDiv = new VBox(debug);
    centerDiv.setAlignment(Pos.CENTER);

    /* place the vbox on the bottom (it's already centered) */
    BorderPane topContainer = new BorderPane();
    topContainer.setBottom(centerDiv);

    /* required - creates the "scene" which is just a window */
    Scene scene = new Scene(topContainer, 640, 480);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }

}