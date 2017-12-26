package com.tex2e;

import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;

public class AppController implements Initializable {
    private static AppController instance;
    private MainApp app;

    ObservableList<Word> dict;

    @FXML TextField searchWordField;
    @FXML TableView<Word> dictTable;
    @FXML TableColumn<Word, String> wordColumn;
    @FXML TableColumn<Word, String> definitionColumn;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        // searchWordField.setPromptText("&#128269;  search");
        // searchWordField.setFocusTraversable(false);

        searchWordField.textProperty().addListener((observable, oldValue, newValue) -> {
            String searchWord = searchWordField.getText();
            if (searchWord.length() == 0) {
                dictTable.setItems(FXCollections.observableArrayList());
            } else {
                FilteredList<Word> result = dict.filtered(row -> row.getWord().startsWith(searchWord));
                dictTable.setItems(result);
            }
        });

    }

    public void setMainApp(MainApp app) {
        this.app = app;
        dict = app.getDictData();

        // dictTable.setItems(result);
    }

    public AppController() {
        instance = this;
    }

    public static AppController getInstance() {
        return instance;
    }

}
