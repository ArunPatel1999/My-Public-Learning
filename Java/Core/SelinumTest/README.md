# SelinumTest

> **🌐 Selenium Web Automation**: Basic Selenium WebDriver setup for automated web browser testing and interaction.

## 🎯 Key Selenium Operations Implemented

**In this project, I performed the following operations:**

1) **WebDriver Setup** - Chrome WebDriver configuration and initialization
2) **Browser Automation** - Automated browser launching and navigation
3) **Web Page Navigation** - Direct URL navigation to target websites
4) **Driver Management** - ChromeDriver executable path configuration
5) **System Property Configuration** - WebDriver system property setup
6) **Basic Web Testing** - Foundation for web application testing
7) **Cross-Platform Setup** - Windows ChromeDriver integration

## 🎯 What This Project Does

**Basic Selenium WebDriver implementation demonstrating automated browser control and web page navigation.**

### Core Functionality:
- 🌐 **Browser Automation**: Automated Chrome browser launching and control
- 🔧 **WebDriver Setup**: ChromeDriver configuration and initialization
- 📍 **Navigation**: Direct URL navigation to web pages
- ⚙️ **Driver Management**: System property configuration for WebDriver
- 🖥️ **Cross-Platform**: Windows-compatible ChromeDriver setup
- 🧪 **Testing Foundation**: Base setup for web application testing

## 🛠️ Technology Stack

- **Selenium WebDriver**: Web browser automation framework
- **ChromeDriver**: Chrome browser automation driver
- **Java**: Programming language for test automation
- **Maven**: Build and dependency management
- **Chrome Browser**: Target browser for automation
- **System Properties**: Runtime configuration management

## 📚 Learning Objectives

### Selenium Fundamentals
- **WebDriver Setup**: Understanding WebDriver configuration and initialization
- **Browser Automation**: Automated browser control and interaction
- **Driver Management**: WebDriver executable management and configuration
- **Navigation**: Web page navigation and URL handling

### Test Automation Basics
- **Setup Patterns**: Standard WebDriver setup and configuration patterns
- **Resource Management**: Driver executable path management
- **System Configuration**: System property setup for WebDriver
- **Foundation Building**: Base setup for complex test automation

---

## 📂 Core Components

<details>
<summary>🌐 App</summary>

**Main application class demonstrating basic Selenium WebDriver setup**

- **What it does**: Configures ChromeDriver and demonstrates basic web navigation
- **Code implementation**: 
  - **System Property**: `System.setProperty("webdriver.chrome.driver", path)` for driver configuration
  - **Driver Path**: `System.getProperty("user.dir")+"/src/main/java/driver/chromedriver.exe"`
  - **WebDriver Instance**: `new ChromeDriver()` for browser automation
  - **Navigation**: `driver.get("https://www.fb.com")` for web page access
- **Setup features**:
  - **Dynamic Path**: Uses `user.dir` system property for relative path resolution
  - **Driver Location**: ChromeDriver executable in `/src/main/java/driver/` directory
  - **Browser Launch**: Automated Chrome browser launching
  - **URL Navigation**: Direct navigation to Facebook homepage
- **Configuration details**:
  - **WebDriver Property**: Sets `webdriver.chrome.driver` system property
  - **Executable Path**: Points to local ChromeDriver executable
  - **Browser Instance**: Creates new Chrome browser instance
  - **Target URL**: Navigates to `https://www.fb.com` for demonstration
- **Automation flow**:
  - **Property Setup**: Configures ChromeDriver system property
  - **Driver Creation**: Instantiates ChromeDriver for browser control
  - **Browser Launch**: Opens Chrome browser automatically
  - **Page Navigation**: Loads specified URL in browser

</details>

<details>
<summary>🔧 Driver Configuration</summary>

**ChromeDriver executable and configuration setup**

- **What it does**: Provides ChromeDriver executable and configuration for browser automation
- **Configuration structure**: 
  - **Driver Location**: `/src/main/java/driver/chromedriver.exe`
  - **Platform Support**: Windows executable (.exe) for Chrome automation
  - **Path Resolution**: Dynamic path using system properties
  - **Version Compatibility**: ChromeDriver version matching Chrome browser
- **Setup requirements**:
  - **ChromeDriver**: Compatible ChromeDriver executable for system
  - **Chrome Browser**: Installed Chrome browser on target system
  - **Path Configuration**: Correct path to ChromeDriver executable
  - **System Properties**: Proper WebDriver system property setup
- **Cross-platform considerations**:
  - **Windows**: Uses .exe executable for Windows systems
  - **Path Handling**: Dynamic path resolution for different environments
  - **Version Management**: ChromeDriver version must match Chrome browser
  - **Executable Permissions**: Proper file permissions for driver execution

</details>

## 🌟 Selenium Automation Features

### 🌐 Browser Automation
- **Chrome Integration**: Direct Chrome browser automation and control
- **WebDriver API**: Standard WebDriver interface for browser interaction
- **Navigation Control**: Programmatic web page navigation
- **Session Management**: Browser session creation and management

### 🔧 Configuration Management
- **System Properties**: WebDriver configuration via system properties
- **Dynamic Paths**: Relative path resolution for cross-environment compatibility
- **Driver Management**: ChromeDriver executable path configuration
- **Resource Location**: Organized driver resource management

### 📍 Web Navigation
- **URL Navigation**: Direct navigation to web pages via URLs
- **Page Loading**: Automated page loading and rendering
- **Browser Control**: Programmatic browser window management
- **Web Interaction**: Foundation for web element interaction

### 🧪 Testing Foundation
- **Setup Pattern**: Standard WebDriver setup for test automation
- **Reusable Configuration**: Base configuration for complex test scenarios
- **Automation Framework**: Foundation for web application testing
- **Cross-browser Support**: Extensible setup for multiple browsers

## 🚀 Automation Flow
1. **System Property Setup**: Configure `webdriver.chrome.driver` system property
2. **Path Resolution**: Resolve ChromeDriver executable path dynamically
3. **Driver Initialization**: Create new ChromeDriver instance
4. **Browser Launch**: Chrome browser opens automatically
5. **Navigation**: Browser navigates to specified URL
6. **Page Loading**: Target web page loads in browser
7. **Session Active**: WebDriver session ready for further automation
8. **Interaction Ready**: Setup complete for web element interaction

## 🔧 Setup Requirements
- **Java**: Java Development Kit (JDK) installed
- **Maven**: Maven for dependency management
- **Chrome Browser**: Google Chrome browser installed
- **ChromeDriver**: Compatible ChromeDriver executable
- **Selenium WebDriver**: Selenium dependencies in Maven

## 📡 Usage Example
```java
// Basic Selenium WebDriver setup
System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://example.com");

// Additional automation operations can be added here
// driver.findElement(By.id("element")).click();
// driver.quit(); // Close browser when done
```