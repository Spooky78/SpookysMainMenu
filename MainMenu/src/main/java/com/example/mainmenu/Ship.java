package com.example.mainmenu;

/**
 * Responsible for all the possible ships.
 */
public enum Ship {
    BLUE("ship_blue.png", "blue_ship_life.png"),
    GREEN("ship_green.png", "green_ship_life.png"),
    ORANGE("ship_orange.png", "orange_ship_life.png"),
    RED("ship_red.png", "red_ship_life.png");

    private final String urlShip;
    private final String urlLife;

    /**
     * Creates a player character.
     * @param urlShipParam The player characters url.
     * @param urlLifeParam The player characters life's url
     */
    Ship(String urlShipParam, String urlLifeParam) {
        this.urlShip = urlShipParam;
        this.urlLife = urlLifeParam;
    }

    /**
     * Gets player character's url.
     * @return Player character's url.
     */
    public String getUrl() {
        return this.urlShip;
    }

    /**
     * Gets the player characters life's url.
     * @return The player characters life's url.
     */
    public String getUrlLife() {
        return this.urlLife;
    }
}
