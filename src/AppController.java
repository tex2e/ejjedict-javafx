package com.tex2e;

import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.collections.*;


public class AppController implements Initializable {
    private static AppController instance;
    private MainApp app;

    @FXML TextField field1;
    // @FXML ListView<String> list1;

    @FXML TableView<Word> dictTable;
    @FXML TableColumn<Word, String> wordColumn;
    @FXML TableColumn<Word, String> definitionColumn;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        //
    }

    public void setMainApp(MainApp app) {
        this.app = app;
        ObservableList<Word> dict = app.getDictData();

        dictTable.setItems(dict);
    }

    public AppController() {
        instance = this;
    }

    public static AppController getInstance() {
        return instance;
    }

}
