package main.java.com.anubiscode.teamrandomizer.model.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadWindow {

    public static void load(FXMLLoader loader, String header, Node elem) {
        try {
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(header);
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            ((Stage) elem.getScene().getWindow()).close();
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
