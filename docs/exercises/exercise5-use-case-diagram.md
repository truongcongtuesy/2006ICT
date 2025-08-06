# Exercise 5: Use Case Diagram

## UML Use Case Diagram for Security Alarm System

### Identified Actors

1. **User** - Person who interacts with the alarm system
2. **Security Center** - External monitoring service
3. **Maintenance Technician** - Person who services the system
4. **Motion Detector** - Hardware component (could be considered as actor for external triggers)

### Identified Use Cases

#### Primary Use Cases
1. **Activate Alarm System**
2. **Deactivate Alarm System**
3. **Enter Security Code**
4. **Detect Motion**
5. **Emit Alarm Tone**
6. **Send Trip Signal**
7. **Clear Code Entry**

#### Secondary Use Cases
1. **Illuminate Set Button**
2. **Validate Security Code**
3. **Monitor System Status**
4. **Perform System Maintenance**

### Use Case Relationships

#### Include Relationships (<<include>>)
- **Activate Alarm System** includes **Illuminate Set Button**
- **Deactivate Alarm System** includes **Enter Security Code**
- **Enter Security Code** includes **Validate Security Code**
- **Detect Motion** includes **Send Trip Signal**

#### Extend Relationships (<<extend>>)
- **Clear Code Entry** extends **Enter Security Code** (when error occurs)
- **Perform System Maintenance** extends **Monitor System Status** (when maintenance needed)

### Use Case Descriptions

#### UC1: Activate Alarm System
- **Actor:** User
- **Description:** User presses Set button to activate the security alarm
- **Precondition:** System is deactivated
- **Postcondition:** System is activated and Set button is illuminated
- **Includes:** Illuminate Set Button

#### UC2: Detect Motion
- **Actor:** Motion Detector, User (indirectly)
- **Description:** Motion detector senses movement and triggers alarm
- **Precondition:** System is activated
- **Postcondition:** Trip signal is sent
- **Includes:** Send Trip Signal, Emit Alarm Tone

#### UC3: Deactivate Alarm System  
- **Actor:** User
- **Description:** User enters correct security code to turn off alarm
- **Precondition:** Alarm tone is active
- **Postcondition:** Alarm is deactivated
- **Includes:** Enter Security Code, Validate Security Code

#### UC4: Send Trip Signal
- **Actor:** System
- **Description:** System sends signal to security center when motion detected
- **Precondition:** Motion has been detected
- **Postcondition:** Security center is notified

#### UC5: Enter Security Code
- **Actor:** User
- **Description:** User inputs three-digit code via keypad
- **Precondition:** Alarm is active or system requires authentication
- **Postcondition:** Code is entered and ready for validation
- **Includes:** Validate Security Code
- **Extended by:** Clear Code Entry

### PlantUML Code for Use Case Diagram

```plantuml
@startuml SecurityAlarmUseCases

!define ACTOR_COLOR #lightblue
!define USECASE_COLOR #lightgreen
!define SYSTEM_COLOR #lightyellow

left to right direction

actor "User" as user ACTOR_COLOR
actor "Security Center" as security ACTOR_COLOR  
actor "Maintenance Technician" as tech ACTOR_COLOR
actor "Motion Detector" as detector ACTOR_COLOR

rectangle "Security Alarm System" SYSTEM_COLOR {
    usecase "Activate Alarm System" as UC1 USECASE_COLOR
    usecase "Deactivate Alarm System" as UC2 USECASE_COLOR
    usecase "Detect Motion" as UC3 USECASE_COLOR
    usecase "Emit Alarm Tone" as UC4 USECASE_COLOR
    usecase "Enter Security Code" as UC5 USECASE_COLOR
    usecase "Send Trip Signal" as UC6 USECASE_COLOR
    usecase "Illuminate Set Button" as UC7 USECASE_COLOR
    usecase "Validate Security Code" as UC8 USECASE_COLOR
    usecase "Clear Code Entry" as UC9 USECASE_COLOR
    usecase "Monitor System Status" as UC10 USECASE_COLOR
    usecase "Perform System Maintenance" as UC11 USECASE_COLOR
}

' Actor-Use Case relationships
user --> UC1
user --> UC2
user --> UC5
user --> UC9
detector --> UC3
security --> UC6
tech --> UC11
tech --> UC10

' Include relationships
UC1 ..> UC7 : <<include>>
UC2 ..> UC5 : <<include>>
UC5 ..> UC8 : <<include>>
UC3 ..> UC6 : <<include>>
UC3 ..> UC4 : <<include>>

' Extend relationships  
UC9 ..> UC5 : <<extend>>
UC11 ..> UC10 : <<extend>>

@enduml
```

### Instructions for Creating the Diagram

#### Using VS Code Extensions:
1. Install **PlantUML** extension in VS Code
2. Copy the PlantUML code above into a `.puml` file
3. Use `Ctrl+Shift+P` → "PlantUML: Preview Current Diagram"

#### Using Online Tools:
1. Visit [PlantUML Online Editor](http://www.plantuml.com/plantuml/uml/)
2. Paste the PlantUML code
3. Generate and export the diagram

#### Alternative Tools:
- **Lucidchart** - Web-based diagramming
- **Draw.io** (now Diagrams.net) - Free online tool
- **Visual Paradigm** - Professional UML tool
- **Creately** - Online collaborative diagramming

### Diagram Validation Checklist

- [ ] All actors are external to the system
- [ ] Use cases represent system functionality
- [ ] Relationships are properly labeled
- [ ] Include relationships show mandatory sub-functionality
- [ ] Extend relationships show optional/conditional functionality
- [ ] All use cases have clear names and descriptions
- [ ] System boundary is clearly defined
