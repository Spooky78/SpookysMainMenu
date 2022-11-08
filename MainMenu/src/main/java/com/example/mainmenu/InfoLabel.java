package com.example.mainmenu;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/**
 * Responsible for the information label used on main menu.
 */
public class InfoLabel extends Label {
    private final String FONT_PATH;
    {
        try {
            FONT_PATH = String.valueOf(new File(ClassLoader.getSystemResource(
                "kenvector_future.ttf").toURI()));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    private static final String BACKGROUND_IMAGE = "yellow_label.png";
    private static final int PREF_WIDTH = 380;
    private static final int PREF_HEIGHT = 30;
    private static final int PADDING_LEFT_UP_DOWN = 10;
    private static final int PADDING_RIGHT = 20;
    private static final int BACKGROUND_WIDTH = 320;
    private static final int BACKGROUND_HEIGHT = 45;
    private static final int FONT_SIZE = 23;

    /**
     * Creates an information label.
     * @param text The text that it will display.
     */
    public InfoLabel(String text) {
        setPrefWidth(PREF_WIDTH);
        setPrefHeight(PREF_HEIGHT);
        setPadding(new Insets(PADDING_LEFT_UP_DOWN, PADDING_LEFT_UP_DOWN,
            PADDING_LEFT_UP_DOWN, PADDING_RIGHT));
        setText(text);
        setWrapText(true);
        setLabelFont();

        BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND_IMAGE,
            BACKGROUND_WIDTH, BACKGROUND_HEIGHT, false, true),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            null);
        setBackground(new Background(backgroundImage));
    }

    /**
     * Sets fort type and size.
     */
    private void setLabelFont() {
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), FONT_SIZE));
        } catch (FileNotFoundException e) {
            setFont(Font.font("Verdana", FONT_SIZE));
        }
    }
}
















