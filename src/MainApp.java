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
        String ejdictContent;
        String jedictContent;
        try {
            ejdictContent = new String(Files.readAllBytes(Paths.get(ejdictPath)));
            jedictContent = new String(Files.readAllBytes(Paths.get(jedictPath)));
        } catch (IOException e) {
            throw new RuntimeException("Error: cannot find dictionary.");
        }
        String[] ejdict = ejdictContent.split("\n");
        String[] jedict = jedictContent.split("\n");
        ArrayList<Word> dict = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            dict.add(new Word(ejdict[i].split("\t| /")[0], ejdict[i].split("\t| /")[1]));
        }
        observableDict = FXCollections.observableArrayList(dict);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("FXML TableView Example");
        Pane myPane = (Pane)FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
        Scene myScene = new Scene(myPane, 600, 400);
        primaryStage.setScene(myScene);

        AppController.getInstance().setMainApp(this);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
