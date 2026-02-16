@echo off
if not exist "target\classes" mkdir target\classes
echo Compiling...
javac -d target/classes src/main/java/com/example/*.java
if %errorlevel% neq 0 (
    echo Compilation failed!
    exit /b %errorlevel%
)
echo Compilation successful. Running App...
java -cp target/classes com.example.Main
