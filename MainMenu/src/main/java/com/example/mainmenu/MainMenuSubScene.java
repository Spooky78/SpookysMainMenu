package com.example.mainmenu;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

/**
 * Responsible for the main menu sub scene.
 */
public class MainMenuSubScene extends SubScene {

    private final static String BACKGROUND_IMAGE = "yellow_panel.png";
    private boolean isHidden;

    /**
     * Creates a main menu sub scene off-screen to the right.
     */
    public MainMenuSubScene() {
        super(new AnchorPane(), 450, 400);
        prefWidth(450);
        prefHeight(400);

        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 450, 400, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(image));

        isHidden = true;
        setLayoutX(800);
        setLayoutY(150);
    }

    /**
     * Moves sub scene to new position. If off-screen move to on-screen. If on-screen moves off-screen.
     */
    public void moveSubScene(){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);

        if (isHidden) {
            transition.setToX(-500);
            isHidden = false;
        } else {
            transition.setToX(0);
            isHidden = true;
        }
        transition.play();
    }

    /**
     * Gets the pane.
     * @return Returns the pane.
     */
    public AnchorPane getPane(){
        return (AnchorPane) this.getRoot();
    }
}

















