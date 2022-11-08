package com.example.mainmenu;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * Responsible for the picking player character.
 */
public class ShipPicker extends VBox {
    private final ImageView boxImage;
    private static final String BOX_NOT_CHOSEN = "grey_box.png";
    private static final String BOX_CHOSEN = "checkmark.png";
    private static final int SPACING = 10;
    private final Ship ship;
    private boolean isBoxChosen;

    /**
     * Creates a player character picker.
     * @param shipCharacter The player character.
     */
    public ShipPicker(Ship shipCharacter) {
        boxImage = new ImageView(BOX_NOT_CHOSEN);
        ImageView shipImage = new ImageView(shipCharacter.getUrl());
        this.ship = shipCharacter;
        isBoxChosen = false;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(SPACING);
        this.getChildren().add(boxImage);
        this.getChildren().add(shipImage);
    }

    /**
     * Gets the player character chosen.
     * @return The player character.
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * Sets if option is chosen.
     * @param isBoxChosenParam Is option chosen.
     */
    public void setIsBoxChosen(boolean isBoxChosenParam) {
        this.isBoxChosen = isBoxChosenParam;
        String imageToSet = this.isBoxChosen ? BOX_CHOSEN : BOX_NOT_CHOSEN;
        boxImage.setImage(new Image(imageToSet));
    }


}
