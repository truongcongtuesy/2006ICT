# Exercise 3: Requirements Defect Analysis

## Security Alarm Requirements

**Original Requirements:**

1. **R1.** The security alarm has a detector that sends a trip signal when motion is detected.
2. **R2.** The security alarm is activated by pressing the Set button.
3. **R3.** The Set button is illuminated when the security alarm is set.
4. **R4.** If a trip signal occurs while the security alarm is set, a high-pitched tone (alarm) is emitted.
5. **R5.** A three-digit code must be entered to turn off the alarm tone.
6. **R6.** Correct entry of the code deactivates the security alarm.
7. **R7.** If a mistake is made when entering the code, the user must press the Clear button before the code can be reentered.

## Defect Analysis Table

| Defect ID | Req. ID | Defect Description | Defect Type |
|-----------|---------|-------------------|-------------|
| Df1 | R1 | Does not specify where the trip signal is sent | Incompleteness |
| Df2 | R1 | Missing precondition; does not state alarm status | Incompleteness |
| Df3 | R4, R5 | Unclear if high-pitched tone and alarm tone are the same | Ambiguity / Inconsistency |
| Df4 | R2, R6 | Inconsistent terminology: "activated" vs "set" vs "deactivates" | Inconsistency |
| Df5 | R5 | Does not specify what happens if wrong code is entered | Incompleteness |
| Df6 | R7 | Does not specify how many attempts are allowed before requiring Clear | Incompleteness |
| Df7 | R1 | "Motion" is ambiguous - what type of motion triggers the detector? | Ambiguity |
| Df8 | R3 | Does not specify what happens to illumination when alarm is deactivated | Incompleteness |
| Df9 | R4 | Does not specify duration of the alarm tone | Incompleteness |
| Df10 | R5 | Does not specify time limit for entering the code | Incompleteness |
| Df11 | R6 | Unclear if "correct entry" means exact sequence or just correct digits | Ambiguity |
| Df12 | R2, R3 | No specification of what happens if Set button is pressed when already set | Incompleteness |
| Df13 | R1-R7 | No power requirements or backup power specifications | Incompleteness |
| Df14 | R5, R7 | Interface for code entry is not specified (keypad, buttons, etc.) | Incompleteness |
| Df15 | R4 | Does not specify if alarm tone continues until code is entered | Incompleteness |
| Df16 | R1 | No specification of detector sensitivity or range | Incompleteness |
| Df17 | R6 | Does not specify if deactivation affects detector or just alarm capability | Ambiguity |

## Summary

**Total Defects Identified:** 17

**Defect Types:**
- Incompleteness: 13 defects
- Ambiguity: 3 defects  
- Inconsistency: 1 defect

**Major Issues:**
1. Missing technical specifications (power, sensitivity, timing)
2. Ambiguous terminology and functionality
3. Incomplete error handling and edge cases
4. Missing user interface specifications
