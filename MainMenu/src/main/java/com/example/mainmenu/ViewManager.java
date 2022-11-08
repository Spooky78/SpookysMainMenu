package com.example.mainmenu;

import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ViewManager {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private final AnchorPane mainPane;
    private final Scene mainScene;
    private final Stage mainStage;
    private final static int MENU_BUTTONS_START_X = 50;
    private final static int MENU_BUTTONS_START_Y = 200;
    private MainMenuSubScene creditsSubScene;
    private MainMenuSubScene helpSubScene;
    private MainMenuSubScene scoreSubScene;
    private MainMenuSubScene shipChooserSubScene;
    private MainMenuSubScene sceneToHide;
    private int buttonTotal = 0;
    private List<ShipPicker> shipsList;
    private Ship chosenShip;
    public ViewManager(){
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createSubScenes();
        createBackground();
        createLogo();
        createButtons();

    }
    private void showSubScene(MainMenuSubScene subScene){
        if (sceneToHide != null){
            sceneToHide.moveSubScene();
        }

        subScene.moveSubScene();
        sceneToHide = subScene;
    }

    private void createSubScenes(){
        creditsSubScene = new MainMenuSubScene();
        mainPane.getChildren().add(creditsSubScene);

        helpSubScene = new MainMenuSubScene();
        mainPane.getChildren().add(helpSubScene);

        scoreSubScene = new MainMenuSubScene();
        mainPane.getChildren().add(scoreSubScene);

        shipChooserSubScene = new MainMenuSubScene();
        mainPane.getChildren().add(shipChooserSubScene);

        createShipChooserSubScene();
    }

    private void createShipChooserSubScene(){
        shipChooserSubScene = new MainMenuSubScene();
        mainPane.getChildren().add(shipChooserSubScene);

        InfoLabel chooseShipLabel = new InfoLabel("Choose your ship!");
        chooseShipLabel.setLayoutX(75);
        chooseShipLabel.setLayoutY(25);
        shipChooserSubScene.getPane().getChildren().add(chooseShipLabel);
        shipChooserSubScene.getPane().getChildren().add(createShipsToChoose());
        shipChooserSubScene.getPane().getChildren().add(createButtonToStart());
    }

    private HBox createShipsToChoose(){
        HBox box = new HBox();
        box.setSpacing(5);
        shipsList = new ArrayList<>();
        for(Ship ship: Ship.values()){
            ShipPicker shipToPick = new ShipPicker(ship);
            shipsList.add(shipToPick);
            box.getChildren().add(shipToPick);
            shipToPick.setOnMouseClicked(mouseEvent -> {
                for (ShipPicker ship1 : shipsList){
                    ship1.setIsBoxChosen(false);
                }
                shipToPick.setIsBoxChosen(true);
                chosenShip = shipToPick.getShip();
            });
        }
        box.setLayoutX(160 - (70*2));
        box.setLayoutY(125);
        return box;
    }

    private MainMenuButton createButtonToStart(){
        MainMenuButton startButton = new MainMenuButton("START");
        startButton.setLayoutX(125);
        startButton.setLayoutY(300);

        startButton.setOnAction(actionEvent -> {
            if(chosenShip != null){
                GameViewManager gameManager = new GameViewManager();
                gameManager.createNewGame(mainStage, chosenShip);
            }
        });

        return startButton;
    }

    public Stage getMainStage(){
        return mainStage;
    }

    private void addMenuButtons(MainMenuButton button){
        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y + buttonTotal *100);
        buttonTotal++;
        mainPane.getChildren().add(button);
    }

    private void createButtons(){
        createStartButton();
        createScoreButton();
        createHelpButton();
        createCreditsButton();
        createExitButton();
    }

    private void createStartButton(){
        MainMenuButton startButton = new MainMenuButton("PLAY");
        addMenuButtons(startButton);

        startButton.setOnAction(actionEvent -> showSubScene(shipChooserSubScene));
    }

    private void createScoreButton(){
        MainMenuButton scoreButton = new MainMenuButton("Scores");
        addMenuButtons(scoreButton);

        scoreButton.setOnAction(actionEvent -> showSubScene(scoreSubScene));
    }

    private void createHelpButton(){
        MainMenuButton helpButton = new MainMenuButton("Help");
        addMenuButtons(helpButton);

        helpButton.setOnAction(actionEvent -> showSubScene(helpSubScene));
    }

    private void createCreditsButton(){
        MainMenuButton creditsButton = new MainMenuButton("Credits");
        addMenuButtons(creditsButton);

        creditsButton.setOnAction(actionEvent -> showSubScene(creditsSubScene));
    }

    private void createExitButton(){
        MainMenuButton exitButton = new MainMenuButton("Exit");
        addMenuButtons(exitButton);

        exitButton.setOnAction(actionEvent -> mainStage.close());
    }
    private void createBackground(){
        Image backgroundImage = new Image("background_clouds.png", 800, 600, false, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        //BackgroundFill background =new BackgroundFill(Color.ROYALBLUE, CornerRadii.EMPTY , Insets.EMPTY);
        mainPane.setBackground(new Background(background));
    }

    private void createLogo(){

        ImageView logo = new ImageView("logo.png");
        logo.setLayoutX(25);
        logo.setLayoutY(40);

        logo.setOnMouseEntered(mouseEvent -> logo.setEffect(new DropShadow()));

        logo.setOnMouseExited(mouseEvent -> logo.setEffect(null));

        mainPane.getChildren().add(logo);
    }
}