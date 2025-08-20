@echo off
echo ========================================
echo Lab 4 - Exercise 1: Enhanced JavaAnimation
echo ========================================
echo.
echo Compiling and running the application...
echo.

cd /d "%~dp0"

REM Clean and compile
call mvn clean compile

if %errorlevel% neq 0 (
    echo.
    echo ERROR: Compilation failed!
    pause
    exit /b 1
)

echo.
echo Compilation successful! Starting application...
echo.

REM Run the application
call mvn javafx:run

echo.
echo Application closed.
pause
