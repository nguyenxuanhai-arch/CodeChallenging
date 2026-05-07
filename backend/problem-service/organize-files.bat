@echo off
echo ========================================
echo PROBLEM SERVICE - FILE ORGANIZER
echo ========================================
echo.

set BASE=src\main\java\com\codechallenge\problem\problem_service

echo Step 1: Creating subdirectories...
mkdir "%BASE%\exceptions" 2>nul
mkdir "%BASE%\configs" 2>nul
mkdir "%BASE%\securities" 2>nul
mkdir "%BASE%\services\impl" 2>nul
echo ✓ Directories created
echo.

echo Step 2: Moving exception files...
move "%BASE%\ProblemNotFoundException.java" "%BASE%\exceptions\" 2>nul
move "%BASE%\TestCaseNotFoundException.java" "%BASE%\exceptions\" 2>nul
move "%BASE%\GlobalExceptionHandler.java" "%BASE%\exceptions\" 2>nul
echo ✓ Exception files moved
echo.

echo Step 3: Moving security files...
move "%BASE%\GatewayHeaderFilter.java" "%BASE%\securities\" 2>nul
echo ✓ Security files moved
echo.

echo Step 4: Moving config files...
move "%BASE%\SecurityConfig.java" "%BASE%\configs\" 2>nul
move "%BASE%\WebConfig.java" "%BASE%\configs\" 2>nul
echo ✓ Config files moved
echo.

echo Step 5: Moving service implementation files...
move "%BASE%\ProblemServiceImpl.java" "%BASE%\services\impl\" 2>nul
move "%BASE%\TestCaseServiceImpl.java" "%BASE%\services\impl\" 2>nul
echo ✓ Service impl files moved
echo.

echo ========================================
echo ✅ FILE ORGANIZATION COMPLETE!
echo ========================================
echo.
echo Next steps:
echo 1. Run: mvn clean install
echo 2. Run: mvn spring-boot:run
echo 3. Check Eureka: http://localhost:8761
echo.
pause
