# 🚀ChainTest Reporting with TestNG🚀

This project implements **ChainTest Reporting** in TestNG, including a custom listener to capture screenshots of failed tests as Base64-encoded images. The reporting framework generates a detailed report after executing the tests.

## Features
- **Custom Listener**: Captures screenshots on test failure as Base64 images.
- **ChainTest Report**: Provides a detailed and interactive test report.
- **Easy Integration**: Run tests using `testng.xml`, and the reports will be automatically generated.

## Prerequisites
- **Java Development Kit (JDK)**: Version 8 or later.
- **Maven**: Ensure Maven is installed and configured.
- **TestNG**: Installed and configured as part of your Maven dependencies.

## Project Structure
src/main/java/ # Contains application code, src/test/java/ # Contains test cases and 
testng.xml # TestNG Runner file


## Installation
1. Clone this repository:
   ```bash
   git clone [<repository-url>](https://github.com/prasanthvb/ChainTest_TestNG.git)
2. Navigate to the project directory:
   ```bash
    cd <project-directory>

3. Install dependencies:
   ```bash
    mvn clean install

Usage
1. Run the tests using the testng.xml file:
   ```bash
   mvn test -DsuiteXmlFile=testng.xml

2. After execution, the ChainTest report will be generated in the following directory:
   ```bash
    target/chaintest/

3.Open the index.html file in the target/chaintest folder to view the test report.

Sample Report
![image](https://github.com/user-attachments/assets/556736fb-27cf-49c8-88c8-08925176cbde)

Happy testing! 🎉

Let me know if you’d like to tweak or add more details!






