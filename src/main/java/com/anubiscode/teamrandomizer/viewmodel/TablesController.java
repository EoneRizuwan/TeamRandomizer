package main.java.com.anubiscode.teamrandomizer.viewmodel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class TablesController implements Initializable {

    @FXML
    private ListView<String> tableView1;
    @FXML
    private ListView<String> tableView2;
    @FXML
    private ListView<String> tableView3;
    @FXML
    private ListView<String> tableView4;
    @FXML
    private ListView<String> tableView5;
    @FXML
    private ListView<String> tableView6;

    private List<ListView<String>> listViews;
    private List<String> playerList;
    private Random random;
    private int groupCounts;

    public TablesController(List<String> playerList, int groupCounts) {
        this.playerList = playerList;
        this.groupCounts = groupCounts;
        random = new Random();
        listViews = new ArrayList<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // listViews = new ArrayList<>();
        groupListViews();
    }

    private void groupListViews() {
        listViews.add(tableView1);
        listViews.add(tableView2);
        listViews.add(tableView3);
        listViews.add(tableView4);
        listViews.add(tableView5);
        listViews.add(tableView6);
    }

    @FXML
    private void rerandomize() {
        System.out.println(playerList);
    }
}
