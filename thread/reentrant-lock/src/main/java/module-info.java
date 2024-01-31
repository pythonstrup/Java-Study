module com.thread.reentrantlock {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.thread.reentrantlock to javafx.fxml;
  exports com.thread.reentrantlock;
}