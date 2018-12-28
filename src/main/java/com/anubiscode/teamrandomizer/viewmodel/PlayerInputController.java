package main.java.com.anubiscode.teamrandomizer.viewmodel;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerInputController implements Initializable {

    @FXML
    private JFXComboBox<String> teamCountBox;
    @FXML
    private JFXComboBox<String> playerCountBox;
    @FXML
    private JFXTextField playersName;
    @FXML
    private Text counter;

    private int groupCount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initGroupCountBox();
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
    private void selectedTeamCount(ActionEvent event) {
        groupCount = Integer.parseInt(teamCountBox.getValue());
        if (playerCountBox.isDisable()) playerCountBox.setDisable(false);
        playerCountBox.setValue(null);
        playerCountBox.getItems().clear();
        initPlayerCountBox();
    }

    @FXML
    private void randomize(ActionEvent event) {

    }
}
