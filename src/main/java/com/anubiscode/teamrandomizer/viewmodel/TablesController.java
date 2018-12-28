package main.java.com.anubiscode.teamrandomizer.viewmodel;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import main.java.com.anubiscode.teamrandomizer.model.util.LoadWindow;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class TablesController implements Initializable {

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @FXML
    private ObservableList<ListView<String>> listViews;
    @FXML
    private JFXButton rerandBtn;

    private List<String> playerList;
    private Random random;
    private int groupCounts;

    TablesController(List<String> playerList, int groupCounts) {
        this.playerList = playerList;
        this.groupCounts = groupCounts;
        random = new Random();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        allocateEnableList();
        populateListView();
    }

    private void allocateEnableList() {
        for (int i = groupCounts; i < listViews.size(); i++) {
            listViews.get(i).setDisable(true);
        }
    }

    private void populateListView() {
        int playerPerList = playerList.size() / groupCounts;
        for (int i = 0; i < groupCounts; i++) {
            ListView<String> listView = listViews.get(i);
            for (int j = 0; j < playerPerList; j++) {
                listView.getItems().add(getRandomPlayer());
            }
        }
    }

    @FXML
    private void rerandomize() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/payer_input.fxml"));
        LoadWindow.load(loader, null, rerandBtn);
    }

    private String getRandomPlayer() {
        int index = random.nextInt(playerList.size());
        return playerList.remove(index);
    }
}
