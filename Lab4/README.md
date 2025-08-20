# Lab 4 - Enhanced JavaAnimation with SOLID Principles

## Overview
Lab 4 refactors the JavaAnimation application to follow SOLID principles and enhance the user interface. All implementation has been organized into Exercise 1 for clear project structure.

## Exercise Structure

### Exercise 1: Complete Enhanced JavaAnimation Implementation
**Location**: `Exercise 1/` folder contains the complete standalone project with:
- SOLID principles implementation
- Enhanced UI with CSS styling  
- Improved arrow key controls
- Professional documentation
- Ready-to-run Maven project

**Quick Start**: Navigate to `Exercise 1/` folder and run `run.bat` or use Maven commands.

## Architecture

### SOLID Principles Implementation

1. **Single Responsibility Principle (SRP)**
   - `Game` class: Manages only game logic and state
   - `MainScreen`, `ConfigurationScreen`, `GameScreen`: Each handles only their specific UI concerns
   - `EnhancedJavaAnimation`: Only manages application lifecycle and screen coordination

2. **Open/Closed Principle (OCP)**
   - `Screen` abstract class: Open for extension, closed for modification
   - New screen types can be added by extending `Screen` or `ScreenWithGame`

3. **Liskov Substitution Principle (LSP)**
   - All screen implementations can be used interchangeably where `Screen` is expected
   - `ScreenWithGame` extends `Screen` without breaking its contract

4. **Interface Segregation Principle (ISP)**
   - `Frame` interface: Contains only methods needed for screen navigation
   - Screens only depend on the specific methods they need

5. **Dependency Inversion Principle (DIP)**
   - High-level modules (screens) depend on abstractions (`Frame` interface)
   - Low-level modules (concrete screens) depend on abstractions (`Screen` class)

### Class Structure

```
com.lab4.exercise1/
├── EnhancedJavaAnimation.java    # Main application class implementing Frame
├── model/
│   └── Game.java                 # Game logic and state management
└── UI/
    ├── Frame.java               # Interface for screen navigation
    ├── Screen.java              # Abstract base class for all screens
    ├── ScreenWithGame.java      # Abstract class for game-aware screens
    ├── MainScreen.java          # Main menu screen
    ├── ConfigurationScreen.java # Game settings screen
    └── GameScreen.java          # Game play screen
```

### Features

#### MainScreen
- Welcome interface with navigation buttons
- Start Game, Configuration, and Exit options
- Elegant gradient background with styled buttons

#### ConfigurationScreen
- Ball color selection (Red, Blue, Green)
- Ball size adjustment slider (5-25 pixels)
- Shadow effect toggle
- Real-time configuration updates

#### GameScreen
- Animated ball bouncing with physics
- Arrow key controls for speed adjustment
- Space bar to reset ball position
- ESC key to return to main menu
- Enhanced graphics with shadows and highlights

#### Enhanced UI Features
- Custom CSS styling for professional appearance
- Gradient backgrounds and button effects
- Hover animations and visual feedback
- Exit confirmation dialog
- Responsive layout design

## Key Improvements from Lab 3

1. **Modular Architecture**: Separated concerns into distinct classes and packages
2. **Interface-based Design**: Used interfaces to decouple dependencies
3. **Template Method Pattern**: `Screen` class provides common functionality
4. **Enhanced Graphics**: Professional styling with CSS and visual effects
5. **Better User Experience**: Intuitive navigation and confirmation dialogs
6. **Maintainable Code**: Clear separation of model, view, and controller logic

## Technical Details

### Design Patterns Used
- **Template Method**: `Screen` and `ScreenWithGame` classes
- **Strategy Pattern**: Different screen implementations
- **Observer Pattern**: Game state updates reflected in UI
- **Factory Pattern**: Screen creation and management

### CSS Styling
- Custom styles in `resources/styles.css`
- Gradient backgrounds and animations
- Professional button styling with hover effects
- Responsive layout elements

## Running the Application

### Requirements
- Java 17 or higher
- JavaFX 17 or higher
- Maven 3.6+ (for building)

### Development Setup
1. Ensure JavaFX is properly configured in your IDE
2. Add JavaFX modules to your run configuration:
   ```
   --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml
   ```

### Using Maven (if available)
```bash
mvn clean compile
mvn javafx:run -Djavafx.mainClass=com.lab4.exercise1.EnhancedJavaAnimation
```

### Direct Java Execution
```bash
java --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml \
     -cp target/classes com.lab4.exercise1.EnhancedJavaAnimation
```

## Controls

### Main Screen
- **Start Game**: Begin the animation
- **Configuration**: Modify game settings
- **Exit**: Quit application (with confirmation)

### Game Screen
- **Arrow Keys**: Adjust ball speed (up/down for Y-axis, left/right for X-axis)
- **Space Bar**: Reset ball to center position
- **ESC**: Return to main menu

### Configuration Screen
- **Radio Buttons**: Select ball color
- **Slider**: Adjust ball size
- **Checkbox**: Enable/disable shadow effect
- **Back Button**: Return to main menu

## Code Quality Features

1. **Comprehensive Documentation**: JavaDoc comments for all public methods
2. **Error Handling**: Graceful handling of edge cases and user inputs
3. **Resource Management**: Proper cleanup of animation timers
4. **Thread Safety**: Use of Platform.runLater for UI updates
5. **Consistent Naming**: Clear, descriptive variable and method names

This implementation demonstrates professional software development practices while maintaining the fun and interactive nature of the original JavaAnimation game.
