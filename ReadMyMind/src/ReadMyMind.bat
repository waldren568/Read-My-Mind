@echo off
javac Launcher.java
if %errorlevel% equ 0 (
    start javaw -cp . Launcher
    exit
)