@echo off
echo Creating Problem Service directory structure...

set BASE_PATH=src\main\java\com\codechallenge\problem\problem_service

echo Creating directories...
mkdir "%BASE_PATH%\exceptions" 2>nul
mkdir "%BASE_PATH%\configs" 2>nul
mkdir "%BASE_PATH%\securities" 2>nul
mkdir "%BASE_PATH%\services\impl" 2>nul

echo Directories created successfully!
echo.
echo Please run the following command to create Java files:
echo.
echo Next step: Run create-problem-service-files.bat
pause
