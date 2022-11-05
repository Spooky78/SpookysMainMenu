package com.example.mainmenu;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class GameViewManager {

    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 800;
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private Stage menuStage;

    private ImageView[] background;
    private final Random randomPositionGenerator;

    public GameViewManager(){
        initializeStage();
        randomPositionGenerator = new Random();
    }

    public void createNewGame(Stage menuStage, Ship chosenShip){
        this.menuStage = menuStage;
        this.menuStage.hide();
        createBackground();
        gameStage.show();
    }

    private void initializeStage(){
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
    }



    private void createBackground(){
        Background background = new Background(new BackgroundFill(Color.DODGERBLUE, CornerRadii.EMPTY , Insets.EMPTY));
        gamePane.setBackground(background);
    }


}
