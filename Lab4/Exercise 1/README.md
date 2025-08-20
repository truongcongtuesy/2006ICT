# Lab 4 - Exercise 1: Enhanced JavaAnimation with SOLID Principles

## Overview
This exercise demonstrates the implementation of SOLID principles in a JavaFX application, featuring an enhanced bouncing ball animation with improved UI controls and arrow key functionality.

## Project Structure
```
Exercise 1/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── lab4/
│       │           └── exercise1/
│       │               ├── EnhancedJavaAnimation.java (Main Application)
│       │               ├── model/
│       │               │   └── Game.java (Game Logic Model)
│       │               └── UI/
│       │                   ├── Frame.java (Interface)
│       │                   ├── Screen.java (Abstract Base)
│       │                   ├── ScreenWithGame.java (Abstract Game Screen)
│       │                   ├── MainScreen.java (Main Menu)
│       │                   ├── ConfigurationScreen.java (Settings)
│       │                   └── GameScreen.java (Game Display)
│       └── resources/
│           └── styles.css (UI Styling)
├── README.md
└── IMPLEMENTATION_NOTES.md
```

## Features Implemented

### 1. **SOLID Principles Implementation**
- **Single Responsibility**: Each class has one clear responsibility
- **Open/Closed**: Easy to extend with new screen types
- **Liskov Substitution**: All screen implementations are interchangeable
- **Interface Segregation**: Frame interface contains only necessary methods
- **Dependency Inversion**: High-level modules depend on abstractions

### 2. **Enhanced UI Controls**
- Main menu with Start Game, Configuration, and Exit options
- Configuration screen for game settings
- Game screen with real-time ball animation
- Exit confirmation dialog

### 3. **Improved Arrow Key Controls**
- ⬆️ UP Arrow: Decrease Y speed (ball moves up)
- ⬇️ DOWN Arrow: Increase Y speed (ball moves down)
- ⬅️ LEFT Arrow: Decrease X speed (ball moves left)
- ➡️ RIGHT Arrow: Increase X speed (ball moves right)
- SPACE: Reset ball to center position
- ESC: Return to main menu

### 4. **Visual Enhancements**
- CSS styling for professional appearance
- Real-time speed display
- Ball shadow effects
- Gradient backgrounds
- Hover effects on buttons

### 5. **Game Features**
- Configurable ball size and color
- Adjustable ball speed
- Smooth animation with proper collision detection
- Ball stays within boundaries

## How to Run

### Prerequisites
- Java 17 or higher
- JavaFX 17.0.2
- Maven

### Running the Application
```bash
# From the main project directory
mvn clean javafx:run@run-lab4
```

### Alternative Run Method
```bash
# Compile first
mvn clean compile

# Run with JavaFX module path
java --module-path "path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml -cp "target/classes" com.lab4.exercise1.EnhancedJavaAnimation
```

## Usage Instructions

1. **Start Application**: Launch the application to see the main menu
2. **Configuration**: Click "Configuration" to adjust game settings
3. **Start Game**: Click "Start Game" to begin the animation
4. **Control Ball**: Use arrow keys to control ball movement
5. **Monitor Speed**: Watch the speed display for real-time feedback
6. **Reset Ball**: Press SPACE to reset ball position
7. **Exit**: Press ESC or click Exit (with confirmation dialog)

## Technical Implementation

### Architecture Pattern
- **Model-View-Controller (MVC)**: Clear separation of concerns
- **Strategy Pattern**: Different screen implementations
- **Observer Pattern**: UI updates based on model changes

### Key Design Decisions
1. **Separation of Model and UI**: Game logic separated from presentation
2. **Abstract Screen Classes**: Common functionality shared between screens
3. **Interface-based Design**: Loose coupling between components
4. **CSS Styling**: External styling for maintainability
5. **Event-driven Architecture**: Responsive user interactions

### Performance Optimizations
- Efficient animation timer
- Smooth double-precision calculations
- Optimized rendering with proper bounds checking
- Memory-efficient object reuse

## Testing Notes
- All arrow key controls are responsive and provide immediate feedback
- Speed adjustments are smooth with 0.5 increments
- Ball collision detection is accurate
- UI transitions are smooth
- Exit confirmation prevents accidental closure

## Future Enhancements
- Multiple ball support
- Different game modes
- Sound effects
- Score tracking
- Particle effects
- Customizable themes

---
*Developed for 2006ICT - Software Engineering*
