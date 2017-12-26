package com.tex2e;

import java.util.*;
import java.net.URL;
import java.nio.file.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.io.IOException;
import javafx.fxml.*;
import javafx.collections.*;


public class MainApp extends Application {
    private AppController controller;

    String ejdictPath = "data/edict/edict.txt";
    String jedictPath = "data/ejdic/ejdic.txt";
    private ObservableList<Word> observableDict;

    public ObservableList<Word> getDictData() {
        return observableDict;
    }

    public MainApp() {
        this.observableDict = loadAllDict();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("FXML TableView Example");
        Pane myPane = (Pane)FXMLLoader.load(getClass().getClassLoader().getResource("fxml/main.fxml"));
        Scene myScene = new Scene(myPane, 700, 500);
        primaryStage.setScene(myScene);
        AppController.getInstance().setMainApp(this);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private ObservableList<Word> loadAllDict() {
        String ejdictContent;
        String jedictContent;
        try {
            ejdictContent = new String(Files.readAllBytes(Paths.get(this.ejdictPath)));
            jedictContent = new String(Files.readAllBytes(Paths.get(this.jedictPath)));
        } catch (IOException e) {
            throw new RuntimeException("Error: cannot find dictionary.");
        }

        String[] ejdict = ejdictContent.split("\n");
        String[] jedict = jedictContent.split("\n");
        ArrayList<Word> dict = new ArrayList<>();

        for (int i = 0; i < ejdict.length; i++) {
            String[] row = ejdict[i].split("\t| /");
            dict.add(new Word(row[0], row[1]));
        }
        for (int i = 0; i < jedict.length; i++) {
            String[] row = jedict[i].split("\t| /");
            dict.add(new Word(row[0], row[1]));
        }
        return FXCollections.observableArrayList(dict);
    }

}
