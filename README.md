# Lab 2 - Java Development Project

## 📋 Overview

This project contains all exercises for Lab 2, focusing on Java development, JavaFX applications, and requirements engineering. This setup replaces IntelliJ IDEA with VS Code as the primary development environment.

## 🏗️ Project Structure

```
2006ICT/
├── src/
│   ├── main/
│   │   ├── java/com/lab2/
│   │   │   ├── exercise1/          # VS Code setup notes
│   │   │   └── exercise2/          # Java applications
│   │   └── resources/              # Application resources
│   └── test/java/                  # Unit tests
├── docs/
│   └── exercises/                  # Documentation for exercises 3-5
├── pom.xml                         # Maven configuration
└── README.md                       # This file
```

## 🚀 Getting Started

### Prerequisites

- **Java 17 or higher** installed
- **Maven 3.6+** installed
- **VS Code** with Java extensions

### Installation

1. Clone or download this project
2. Open the project folder in VS Code
3. VS Code will automatically detect the Maven project and configure Java support

### Running the Applications

#### Hello World (Console Application)
```bash
# Using Maven
mvn compile exec:java -Dexec.mainClass="com.lab2.exercise2.HelloWorld"

# Or use VS Code's Run/Debug features
```

#### JavaFX Demo Application
```bash
# Using Maven JavaFX plugin
mvn clean javafx:run

# Or use VS Code's Run/Debug features
```

## 📚 Exercises

### Exercise 1: VS Code Setup ✅
- Replaced IntelliJ IDEA with VS Code
- Installed Java Extension Pack
- Configured Maven support
- Set up project structure

### Exercise 2: Java Applications ✅
- **HelloWorld.java** - Simple console application
- **HelloWorldApp.java** - JavaFX GUI application with user interaction
- Both applications are ready to run

### Exercise 3: Requirements Defect Analysis ✅
- Located in: `docs/exercises/exercise3-requirements-defects.md`
- Identified 17 defects in security alarm requirements
- Categorized by type: Incompleteness, Ambiguity, Inconsistency

### Exercise 4: High-Quality Requirements ✅
- Located in: `docs/exercises/exercise4-high-quality-requirements.md`
- Rewritten requirements using structured pattern
- Added preconditions, events, postconditions, and constraints

### Exercise 5: Use Case Diagram ✅
- Located in: `docs/exercises/exercise5-use-case-diagram.md`
- PlantUML diagram: `docs/exercises/security-alarm-use-case.puml`
- Identified actors, use cases, and relationships

## 🛠️ Development Tools

### VS Code Extensions Installed
- **Extension Pack for Java** - Complete Java development support
- **PlantUML** - UML diagram creation and preview
- **Code Spell Checker** - Writing assistance for documentation

### Maven Plugins Configured
- **Maven Compiler Plugin** - Java compilation
- **JavaFX Maven Plugin** - JavaFX application execution
- **Maven Surefire Plugin** - Unit testing

## 🎯 Features

### Java Development
- ✅ Maven project structure
- ✅ Java 17 compatibility
- ✅ JavaFX GUI applications
- ✅ Console applications
- ✅ Unit testing setup

### Documentation
- ✅ Requirements analysis
- ✅ UML use case diagrams
- ✅ Structured requirements writing
- ✅ PlantUML diagram source

### VS Code Integration
- ✅ IntelliSense and code completion
- ✅ Debugging support
- ✅ Git integration
- ✅ Built-in terminal
- ✅ Maven task integration

## 🎮 Quick Start Commands

### Build Project
```bash
mvn clean compile
```

### Run Hello World
```bash
mvn exec:java -Dexec.mainClass="com.lab2.exercise2.HelloWorld"
```

### Run JavaFX App
```bash
mvn javafx:run
```

### Run Tests
```bash
mvn test
```

### Generate UML Diagram
1. Open `docs/exercises/security-alarm-use-case.puml` in VS Code
2. Press `Ctrl+Shift+P` → "PlantUML: Preview Current Diagram"

## 📝 Assignment Submission

### For GitHub Repository (Exercise 2 requirement):
1. Initialize Git: `git init`
2. Add files: `git add .`
3. Commit: `git commit -m "Initial Lab 2 submission"`
4. Create GitHub repository
5. Link and push: 
   ```bash
   git remote add origin <your-repo-url>
   git branch -M main
   git push -u origin main
   ```

### What to Submit:
- ✅ Java source code (Exercise 2)
- ✅ Requirements defect analysis (Exercise 3)
- ✅ High-quality requirements (Exercise 4)
- ✅ Use case diagram (Exercise 5)
- ✅ This complete VS Code project setup

## 🤝 Contributing

1. Follow Java coding conventions
2. Write clear commit messages
3. Document your code
4. Include unit tests for new functionality

## 📄 License

This project is for educational purposes as part of the 2006ICT course.

---
