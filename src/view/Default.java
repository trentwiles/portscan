package view;

import java.lang.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.*;
import model.InternetProtocolAddress;

public class Default extends Application {

  @Override
  public void start(Stage stage) {
    String javaVersion = System.getProperty("java.version");
    String javafxVersion = System.getProperty("javafx.version");
    Label debug = new Label("JavaFX Version " + javafxVersion + " | Java Version: " + javaVersion);

    VBox centerDiv = new VBox(debug);
    centerDiv.setAlignment(Pos.CENTER);

    BorderPane container = new BorderPane();
    container.setBottom(centerDiv);

    Label title = new Label("Port Scanner");
    title.setScaleX(2.0);
    title.setScaleY(2.0);
    title.setPadding(new Insets(20));
    Font font = Font.loadFont(getClass().getResourceAsStream("/resources/METRO-DF.TTF"), 24);
    title.setFont(font);

    VBox centerDivTitle = new VBox(title);
    centerDivTitle.setAlignment(Pos.CENTER);
    container.setTop(centerDivTitle);

    TextField b = new TextField();
    b.setScaleX(0.75);
    b.setScaleY(2.0);

    Label errors = new Label();
    errors.setTextFill(Color.RED);
    errors.setPadding(new Insets(20));

    // Group the TextField and errors label in a VBox
    VBox centerContent = new VBox(10, b, errors);
    centerContent.setAlignment(Pos.CENTER);

    container.setCenter(centerContent);

    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        String ip = b.getText();
        // Insert some regex to validate the IP address (you can add it later)
        b.setText("");
        boolean isValidIP = InternetProtocolAddress.validate(ip);
        if (!isValidIP) {
          errors.setText("Invalid IP Address");
        } else {
          errors.setText("");
        }

      }
    };

    b.setOnAction(event);

    Scene scene = new Scene(container, 640, 480);
    stage.setScene(scene);
    stage.show();
  }


  public static void main(String[] args) {
    launch();
  }

}