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
            FONT_PATH = String.valueOf(new File(ClassLoader.getSystemResource("kenvector_future.ttf").toURI()));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    private final static String BACKGROUND_IMAGE = "yellow_label.png";

    /**
     * Creates an information label.
     * @param text The text that it will display.
     */
    public InfoLabel(String text){
        setPrefWidth(380);
        setPrefHeight(30);
        setPadding(new Insets(10,10,10,20));
        setText(text);
        setWrapText(true);
        setLabelFont();

        BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND_IMAGE, 320, 45, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        setBackground(new Background(backgroundImage));
    }

    /**
     * Sets fort type and size.
     */
    private void setLabelFont(){
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
        } catch (FileNotFoundException e) {
            setFont(Font.font("Verdana", 23));
        }
    }
}
















