
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.File;

public class FileExplorer extends Application {
  private ListView<String> listView = new ListView<>();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    Button openBtn = new Button("Open Folder");
    openBtn.setOnAction(e -> openDirectory());

    VBox root = new VBox(10, openBtn, listView);
    Scene scene = new Scene(root, 400, 500);
    stage.setScene(scene);
    stage.setTitle("JavaFX File Explorer");
    stage.show();
  }

  private void openDirectory() {
    DirectoryChooser chooser = new DirectoryChooser();
    File folder = chooser.showDialog(null);
    if (folder != null && folder.isDirectory()) {
      listView.getItems().clear();
      for (File f : folder.listFiles()) {
        listView.getItems().add(f.getName());
      }
    }
  }
}
