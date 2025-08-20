package com.lab4.exercise1.UI;

import com.lab4.exercise1.model.Game;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * Configuration screen for game settings
 * Allows users to modify game parameters
 */
public class ConfigurationScreen extends Screen {
    
    public ConfigurationScreen(Frame frame, Game game) {
        super(frame, game);
    }
    
    @Override
    public Parent createLayout() {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(20);
        layout.getStyleClass().add("config-screen");
        
        // Title
        Label title = new Label("Game Configuration");
        title.getStyleClass().add("config-title");
        
        // Ball Color Selection
        Label colorLabel = new Label("Ball Color:");
        colorLabel.getStyleClass().add("config-label");
        
        ToggleGroup colorGroup = new ToggleGroup();
        HBox colorBox = new HBox();
        colorBox.setSpacing(15);
        colorBox.setAlignment(Pos.CENTER);
        colorBox.getStyleClass().add("color-box");
        
        RadioButton redRadio = new RadioButton("Red");
        redRadio.setToggleGroup(colorGroup);
        redRadio.setSelected(true);
        redRadio.getStyleClass().add("config-radio");
        redRadio.setOnAction(e -> game.setBallColor(Color.RED));
        
        RadioButton blueRadio = new RadioButton("Blue");
        blueRadio.setToggleGroup(colorGroup);
        blueRadio.getStyleClass().add("config-radio");
        blueRadio.setOnAction(e -> game.setBallColor(Color.BLUE));
        
        RadioButton greenRadio = new RadioButton("Green");
        greenRadio.setToggleGroup(colorGroup);
        greenRadio.getStyleClass().add("config-radio");
        greenRadio.setOnAction(e -> game.setBallColor(Color.GREEN));
        
        colorBox.getChildren().addAll(redRadio, blueRadio, greenRadio);
        
        // Ball Size Slider
        Label sizeLabel = new Label("Ball Size:");
        sizeLabel.getStyleClass().add("config-label");
        
        Slider sizeSlider = new Slider(5, 25, game.getBallSize());
        sizeSlider.setShowTickLabels(true);
        sizeSlider.setShowTickMarks(true);
        sizeSlider.setMajorTickUnit(5);
        sizeSlider.getStyleClass().add("config-slider");
        sizeSlider.valueProperty().addListener((obs, oldVal, newVal) -> 
            game.setBallSize(newVal.doubleValue()));
        
        // Shadow Option
        CheckBox shadowCheckBox = new CheckBox("Enable Shadow Effect");
        shadowCheckBox.getStyleClass().add("config-checkbox");
        shadowCheckBox.setSelected(game.isShadowEnabled());
        shadowCheckBox.setOnAction(e -> game.setShadowEnabled(shadowCheckBox.isSelected()));
        
        // Back Button
        Button backButton = new Button("Back to Main");
        backButton.getStyleClass().add("back-button");
        backButton.setOnAction(e -> frame.showMainScreen());
        
        layout.getChildren().addAll(
            title, 
            colorLabel, colorBox,
            sizeLabel, sizeSlider,
            shadowCheckBox,
            backButton
        );
        
        // Apply CSS styling
        applyStyles(layout);
        
        return layout;
    }
}
