module JavaFX.tutorial {
  requires javafx.fxml;
  requires java.base;
  requires javafx.controls;
  requires java.net.http;

  opens view;
  opens model;
}