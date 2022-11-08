package com.example.mainmenu;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Responsible for the main game window.
 * @author Spooky78
 */
public class GameViewManager {

    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 800;
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private Stage menuStage;
    private final Random randomPositionGenerator;

    /**
     * Creates a GameViewManager.
     */
    public GameViewManager() {
        initializeStage();
        randomPositionGenerator = new Random();
    }

    /**
     * Creates a new game.
     * @param stage The previous stage (usually menuStage).
     * @param chosenShip The player character.
     */
    public void createNewGame(Stage stage, Ship chosenShip) {
        this.menuStage = stage;
        this.menuStage.hide();
        createBackground();
        gameStage.show();
    }

    /**
     * Initializes the stage, scene, & pane.
     */
    private void initializeStage() {
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
    }

    /**
     * Creates the background (Default DOGERBLUE).
     */
    private void createBackground() {
        Background background = new Background(new BackgroundFill(
            Color.DODGERBLUE, CornerRadii.EMPTY, Insets.EMPTY));
        gamePane.setBackground(background);
    }


}
