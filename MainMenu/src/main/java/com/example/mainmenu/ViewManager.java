package com.example.mainmenu;

import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for the main menu window.
 */
public class ViewManager {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private final AnchorPane mainPane;
    private final Scene mainScene;
    private final Stage mainStage;
    private static final int MENU_BUTTONS_START_X = 50;
    private static final int MENU_BUTTONS_START_Y = 200;
    private static final int BACKGROUND_START_X = 50;
    private static final int BACKGROUND_START_Y = 200;
    private static final int POSITION_X = 75;
    private static final int POSITION_Y = 25;
    private static final int CHARACTER_POSITION_X = 20;
    private static final int CHARACTER_POSITION_Y = 125;
    private static final int BUTTON_POSITION_X = 125;
    private static final int BUTTON_POSITION_Y = 300;
    private static final int LOGO_POSITION_X = 125;
    private static final int LOGO_POSITION_Y = 300;
    private static final int SPACING = 5;
    private static final int BUTTON_SPACING_OFFSET = 100;
    private MainMenuSubScene creditsSubScene;
    private MainMenuSubScene helpSubScene;
    private MainMenuSubScene scoreSubScene;
    private MainMenuSubScene shipChooserSubScene;
    private MainMenuSubScene sceneToHide;
    private int buttonTotal = 0;
    private List<ShipPicker> shipsList;
    private Ship chosenShip;

    /**
     * Creates a main menu window.
     */
    public ViewManager() {
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createSubScenes();
        createBackground();
        createLogo();
        createButtons();

    }

    /**
     * If sub scene is hidden then move it.
     * @param subScene The sub scene to be moved.
     */
    private void showSubScene(MainMenuSubScene subScene) {
        if (sceneToHide != null) {
            sceneToHide.moveSubScene();
        }

        subScene.moveSubScene();
        sceneToHide = subScene;
    }

    /**
     * Creates the sub scenes for the main menu.
     */
    private void createSubScenes() {
        creditsSubScene = new MainMenuSubScene();
        mainPane.getChildren().add(creditsSubScene);

        helpSubScene = new MainMenuSubScene();
        mainPane.getChildren().add(helpSubScene);

        scoreSubScene = new MainMenuSubScene();
        mainPane.getChildren().add(scoreSubScene);

        shipChooserSubScene = new MainMenuSubScene();
        mainPane.getChildren().add(shipChooserSubScene);

        createPlayerCharacterChooserSubScene();
    }

    /**
     * Creates the player character chooser.
     */
    private void createPlayerCharacterChooserSubScene() {
        shipChooserSubScene = new MainMenuSubScene();
        mainPane.getChildren().add(shipChooserSubScene);

        InfoLabel chooseShipLabel = new InfoLabel("Choose your ship!");
        chooseShipLabel.setLayoutX(POSITION_X);
        chooseShipLabel.setLayoutY(POSITION_Y);
        shipChooserSubScene.getPane().getChildren().add(chooseShipLabel);
        shipChooserSubScene.getPane().getChildren().add(createPlayerCharacterToChoose());
        shipChooserSubScene.getPane().getChildren().add(createButtonToStart());
    }

    /**
     * Creates the player character to choose.
     * @return The HBox of the player character.
     */
    private HBox createPlayerCharacterToChoose() {
        HBox box = new HBox();
        box.setSpacing(SPACING);
        shipsList = new ArrayList<>();
        for (Ship ship: Ship.values()) {
            ShipPicker shipToPick = new ShipPicker(ship);
            shipsList.add(shipToPick);
            box.getChildren().add(shipToPick);
            shipToPick.setOnMouseClicked(mouseEvent -> {
                for (ShipPicker ship1 : shipsList) {
                    ship1.setIsBoxChosen(false);
                }
                shipToPick.setIsBoxChosen(true);
                chosenShip = shipToPick.getShip();
            });
        }
        box.setLayoutX(CHARACTER_POSITION_X);
        box.setLayoutY(CHARACTER_POSITION_Y);
        return box;
    }

    /**
     * Creates the start button.
     * @return The start button.
     */
    private MainMenuButton createButtonToStart() {
        MainMenuButton startButton = new MainMenuButton("START");
        startButton.setLayoutX(BUTTON_POSITION_X);
        startButton.setLayoutY(BUTTON_POSITION_Y);

        startButton.setOnAction(actionEvent -> {
            if (chosenShip != null) {
                GameViewManager gameManager = new GameViewManager();
                gameManager.createNewGame(mainStage, chosenShip);
            }
        });

        return startButton;
    }

    /**
     * Gets main stage.
     * @return The main stage.
     */
    public Stage getMainStage() {
        return mainStage;
    }

    /**
     * Adds menu buttons to screen.
     * @param button The button to be added.
     */
    private void addMenuButtons(MainMenuButton button) {
        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y + buttonTotal * BUTTON_SPACING_OFFSET);
        buttonTotal++;
        mainPane.getChildren().add(button);
    }

    /**
     * Creates all main menu buttons.
     */
    private void createButtons() {
        createStartButton();
        createScoreButton();
        createHelpButton();
        createCreditsButton();
        createExitButton();
    }

    /**
     * Creates the play button.
     */
    private void createStartButton() {
        MainMenuButton startButton = new MainMenuButton("PLAY");
        addMenuButtons(startButton);

        startButton.setOnAction(actionEvent -> showSubScene(shipChooserSubScene));
    }

    /**
     * Creates the score button.
     */
    private void createScoreButton() {
        MainMenuButton scoreButton = new MainMenuButton("Scores");
        addMenuButtons(scoreButton);

        scoreButton.setOnAction(actionEvent -> showSubScene(scoreSubScene));
    }

    /**
     * Creates the help button.
     */
    private void createHelpButton() {
        MainMenuButton helpButton = new MainMenuButton("Help");
        addMenuButtons(helpButton);

        helpButton.setOnAction(actionEvent -> showSubScene(helpSubScene));
    }

    /**
     * Creates the credits button.
     */
    private void createCreditsButton() {
        MainMenuButton creditsButton = new MainMenuButton("Credits");
        addMenuButtons(creditsButton);

        creditsButton.setOnAction(actionEvent -> showSubScene(creditsSubScene));
    }

    /**
     * Creates the exit button, that exits the application.
     */
    private void createExitButton() {
        MainMenuButton exitButton = new MainMenuButton("Exit");
        addMenuButtons(exitButton);

        exitButton.setOnAction(actionEvent -> mainStage.close());
    }

    /**
     * Sets the background to images.
     */
    private void createBackground() {
        Image backgroundImage = new Image("background_clouds.png", BACKGROUND_START_X,
            BACKGROUND_START_Y, false, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,
            BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));
    }

    /**
     * Creates the game logo.
     */
    private void createLogo() {

        ImageView logo = new ImageView("logo.png");
        logo.setLayoutX(LOGO_POSITION_X);
        logo.setLayoutY(LOGO_POSITION_Y);

        logo.setOnMouseEntered(mouseEvent -> logo.setEffect(new DropShadow()));

        logo.setOnMouseExited(mouseEvent -> logo.setEffect(null));

        mainPane.getChildren().add(logo);
    }
}