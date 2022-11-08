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
    private static final String boxNotChosen = "grey_box.png";
    private static final String boxChosen = "checkmark.png";
    private final Ship ship;
    private boolean isBoxChosen;

    /**
     * Creates a player character picker.
     * @param ship The player character.
     */
    public ShipPicker(Ship ship){
        boxImage = new ImageView(boxNotChosen);
        ImageView shipImage = new ImageView(ship.getUrl());
        this.ship = ship;
        isBoxChosen = false;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.getChildren().add(boxImage);
        this.getChildren().add(shipImage);
    }

    /**
     * Gets the player character chosen.
     * @return The player character.
     */
    public Ship getShip(){
        return ship;
    }

    /**
     * Sets if option is chosen.
     * @param isBoxChosen Is option chosen.
     */
    public void setIsBoxChosen(boolean isBoxChosen){
        this.isBoxChosen = isBoxChosen;
        String imageToSet = this.isBoxChosen ? boxChosen: boxNotChosen;
        boxImage.setImage(new Image(imageToSet));
    }


}
