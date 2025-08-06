# Exercise 4: High-Quality Requirements

## Rewritten Security Alarm Requirements

Using the structured pattern: Precondition → Event → Postcondition → Constraints

### R1: Motion Detection and Signal Transmission
**Precondition:** The security alarm system is powered on and [detector is functional].
**Event:** The motion detector identifies [human or large object] movement [within the protected area].
**Postcondition:** A trip signal is sent to [the alarm control unit and security center].
**Constraints:** [The trip signal must be sent within 3 seconds of motion detection.]

### R2: Alarm System Activation
**Precondition:** The security alarm system is in deactivated state and [user is authorized].
**Event:** [An authorized user] presses the Set button.
**Postcondition:** The security alarm system transitions to activated/set state.
**Constraints:** [Activation must complete within 2 seconds of button press.]

### R3: Set Button Illumination Control
**Precondition:** The security alarm system state changes.
**Event:** The security alarm transitions to activated/set state.
**Postcondition:** The Set button [LED indicator] is illuminated [with green light].
**Constraints:** [Illumination must activate within 1 second of state change.]

### R4: Alarm Tone Activation
**Precondition:** The security alarm system is in activated/set state.
**Event:** A trip signal is received [from the motion detector].
**Postcondition:** A high-pitched alarm tone is emitted [from the alarm speaker] and [continues until deactivated].
**Constraints:** [Alarm tone must start within 1 second of trip signal receipt and maintain 85-95 dB volume level.]

### R5: Code Entry for Alarm Deactivation
**Precondition:** The alarm tone is active and [the keypad is functional].
**Event:** [A user] enters a three-digit code using [the numeric keypad].
**Postcondition:** The entered code is validated against [the stored security code].
**Constraints:** [Code entry must be completed within 30 seconds, and each digit must be pressed within 5 seconds of the previous digit.]

### R6: Alarm System Deactivation
**Precondition:** A three-digit code has been entered and validated as correct.
**Event:** The system confirms code validity.
**Postcondition:** The alarm tone stops, the security alarm system transitions to deactivated state, and [the Set button illumination turns off].
**Constraints:** [Deactivation must complete within 2 seconds of code validation.]

### R7: Code Entry Error Handling
**Precondition:** [A user is in the process of entering a security code] and [an incorrect digit is entered].
**Event:** [The user] presses the Clear button [on the keypad].
**Postcondition:** The partially entered code is cleared and [the system is ready for new code entry].
**Constraints:** [Code clearing must complete within 1 second of Clear button press, and the user has a maximum of 3 attempts before a 5-minute lockout period.]

## Additional Requirements (Analyst-Supplied)

### R8: Power Management
**Precondition:** [The main power supply is interrupted].
**Event:** [Primary power loss is detected].
**Postcondition:** [The system switches to backup battery power].
**Constraints:** [Backup power must activate within 100ms and provide at least 4 hours of operation.]

### R9: System Status Indication
**Precondition:** [The security alarm system is operational].
**Event:** [System performs periodic self-check every 60 seconds].
**Postcondition:** [System status is indicated via LED display showing green for normal, amber for warning, red for fault].
**Constraints:** [Status check must complete within 5 seconds.]

### R10: Security Code Management
**Precondition:** [An authorized administrator is present] and [system is in maintenance mode].
**Event:** [Administrator] changes the three-digit security code.
**Postcondition:** [New code is stored in non-volatile memory] and [old code is invalidated].
**Constraints:** [Code must be 3 digits, cannot be 000 or 999, and change must be confirmed twice before storage.]

## Key Improvements Made

1. **Added specific actors** in brackets where missing
2. **Clarified technical specifications** (timing, volume, power)
3. **Defined system states** more precisely
4. **Added error handling** and edge cases
5. **Included constraints** for timing and limits
6. **Resolved ambiguous terminology** with consistent definitions
7. **Added missing functionality** for complete system operation
