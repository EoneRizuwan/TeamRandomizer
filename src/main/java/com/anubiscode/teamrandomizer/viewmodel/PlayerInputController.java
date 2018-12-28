package main.java.com.anubiscode.teamrandomizer.viewmodel;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PlayerInputController implements Initializable {

    @FXML
    private JFXComboBox<String> teamCountBox;
    @FXML
    private JFXComboBox<String> playerCountBox;
    @FXML
    private JFXTextField playersTextField;
    @FXML
    private Text counterText;
    @FXML
    private Text moreText;

    private List<String> players;
    private int groupCount;
    private int playerCount;
    private int counter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        players = new ArrayList<>();
        initGroupCountBox();
        counterText.setText("");
    }

    private void initGroupCountBox() {
        for (int i = 2; i <= 6; i++) teamCountBox.getItems().add(i + "");
    }

    private void initPlayerCountBox() {
        for (int i = groupCount + 1; i <= (groupCount * 10); i++) {
            if (i % groupCount == 0) playerCountBox.getItems().add(i + "");
        }
    }

    @FXML
    private void selectedTeamCount() {
        groupCount = Integer.parseInt(teamCountBox.getValue());
        if (playerCountBox.isDisable()) playerCountBox.setDisable(false);
        playerCountBox.setValue(null);
        playerCount = 0;
        playerCountBox.getItems().clear();
        initPlayerCountBox();
        players.clear();
    }

    @FXML
    private void selectedPlayerCount() {
        if (playerCountBox.getValue() == null) return;
        playerCount = Integer.parseInt(playerCountBox.getValue());
        counter = playerCount;
        counterText.setText(counter + "");
    }

    @FXML
    private void addPlayer() {
        if (counter < 1) {
            playersTextField.setText("");
            System.out.println(players);
            return;
        }
        players.add(playersTextField.getText());
        counter--;
        if (counter == 0) {
            counterText.setText("");
            moreText.setText("Pressed Randomize!");
        }
        else counterText.setText(counter + "");
        playersTextField.setText("");
    }

    @FXML
    private void randomize() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/tables.fxml"));

        TablesController tablesController = new TablesController(players, groupCount);
        loader.setController(tablesController);
        try {
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            closeWindow();
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


        // FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/tables.fxml"));
        // TablesController tablesController;
        // try {
        //     Parent root = loader.load();
        //     tablesController = loader.getController();
        //     tablesController.setData(players, groupCount);
        //
        //     Stage stage = new Stage();
        //     stage.setScene(new Scene(root));
        //     stage.setResizable(false);
        //
        //     closeWindow();
        //     stage.show();
        //
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }

    private void closeWindow() {
        ((Stage) teamCountBox.getScene().getWindow()).close();
    }
}
