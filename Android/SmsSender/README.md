# SMS Sender - Socket-Based SMS Gateway

## 🎯 What This Project Does

**Turns your Android phone into a remote-controlled SMS gateway that can send text messages on command from any server or application.**

### Core Functionality:
- 📡 **Connects to a server** via TCP socket (IP: 192.168.0.169:8888)
- 📨 **Receives SMS requests** in real-time from the server
- 📱 **Sends SMS messages** using your phone's native SMS capability
- 🔄 **Processes continuously** - listens for new requests 24/7
- 📊 **Shows status** on screen when messages are sent

### Message Flow:
```
Server → Socket Connection → Android App → SMS → Recipient Phone
```

### Example Usage:
```
Server sends: "1234567890Hello World!"
Result: SMS "Hello World!" sent to phone number 1234567890
```

---

## 📋 Overview
Android application that functions as an SMS gateway, receiving SMS requests through socket connections and sending them via the device's SMS capability.

## 🚀 Features

<details>
<summary>📱 Core Functionality</summary>

### Socket Communication
- **TCP Socket Client**: Connects to server on IP `192.168.0.169:8888`
- **Real-time Listening**: Continuously listens for incoming SMS requests
- **Message Protocol**: Receives formatted messages with phone number and text
- **Connection Management**: Handles socket connections and error recovery

### SMS Operations
- **SMS Sending**: Uses Android's SmsManager for message delivery
- **Permission Handling**: Requires SEND_SMS permission for functionality
- **Message Parsing**: Extracts phone number (first 10 digits) and message content
- **Status Updates**: Displays sent message status on UI

### Network Integration
- **Wi-Fi Support**: Full Wi-Fi connectivity with multicast support
- **Internet Access**: Network communication capabilities
- **Background Processing**: Handles network operations on main thread (development setup)

</details>

<details>
<summary>🏗️ Technical Architecture</summary>

### Application Structure
- **Single Activity**: MainActivity handles all operations
- **Socket Client**: Persistent connection to remote server
- **SMS Manager**: Android system service integration
- **UI Updates**: Real-time status display

### Message Format
```
Format: [10-digit-phone-number][message-content]
Example: 1234567890Hello World!
Result: Sends "Hello World!" to +1234567890
```

### Permissions Required
- `SEND_SMS`: Send SMS messages
- `INTERNET`: Network communication
- `ACCESS_WIFI_STATE`: Wi-Fi network access
- `CHANGE_WIFI_MULTICAST_STATE`: Multicast support

</details>

<details>
<summary>🔧 Implementation Details</summary>

### MainActivity Components
- **Socket Connection**: Establishes TCP connection to server
- **Message Processing**: Parses incoming socket data
- **SMS Dispatch**: Sends SMS using Android SmsManager
- **UI Feedback**: Updates TextView with operation status

### Key Methods
- `socket()`: Manages socket connection and message listening
- `sendSMS()`: Handles SMS sending via SmsManager
- `onCreate()`: Initializes app and starts socket connection

### Threading
- **StrictMode Policy**: Permits network operations on main thread
- **Continuous Loop**: Infinite loop for message processing
- **Real-time Updates**: Immediate UI updates on message receipt

</details>

<details>
<summary>📱 User Interface</summary>

### Layout Structure
- **ConstraintLayout**: Main container for UI elements
- **TextView (myText)**: Displays SMS sending status
- **Status Updates**: Shows "SMS Send to [number]" for each message

### UI Features
- **Real-time Status**: Live updates when SMS is sent
- **Simple Design**: Minimal interface focused on functionality
- **Status Tracking**: Visual confirmation of SMS operations

</details>

## 🚀 Setup & Usage

### Prerequisites
```xml
<!-- Required permissions in AndroidManifest.xml -->
<uses-permission android:name="android.permission.SEND_SMS"/>
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
<uses-permission android:name="android.permission.CHANGE_WIFI_MULTICAST_STATE"/>
```

### Installation
1. **Build Project**: Compile Android project in Android Studio
2. **Install APK**: Install on Android device with SMS capability
3. **Grant Permissions**: Allow SMS and network permissions
4. **Network Setup**: Ensure device can reach server IP `192.168.0.169:8888`

### Server Setup
```bash
# Example server that sends SMS requests
# Server should send messages in format: [phone][message]
# Example: "1234567890Hello from server!"
```

### Usage Flow
1. **Launch App**: Start SMS Sender application
2. **Auto-Connect**: App automatically connects to configured server
3. **Send Messages**: Server sends formatted SMS requests
4. **SMS Delivery**: App processes and sends SMS messages
5. **Status Display**: UI shows delivery confirmation

## 🔧 Configuration

### Network Settings
```java
// Current server configuration
Socket s = new Socket("192.168.0.169", 8888);

// To change server, modify IP and port:
Socket s = new Socket("YOUR_SERVER_IP", YOUR_PORT);
```

### Message Format Customization
```java
// Current parsing logic
number = msg.substring(0, 10);        // First 10 characters as phone
message = msg.substring(11, msg.length()); // Rest as message

// Modify for different formats as needed
```

## 🛡️ Security Considerations

### Permissions
- **SMS Access**: Requires explicit user permission for SMS sending
- **Network Access**: Needs internet permission for socket communication
- **Runtime Permissions**: Handle SMS permission requests properly

### Network Security
- **Unencrypted Communication**: Current implementation uses plain TCP
- **IP Restrictions**: Hardcoded server IP limits flexibility
- **Authentication**: No authentication mechanism implemented

### Recommendations
- Implement SSL/TLS for encrypted communication
- Add authentication for server connections
- Validate phone numbers and message content
- Implement rate limiting for SMS sending

## 🔄 Use Cases

### SMS Gateway Service
- **Remote SMS Sending**: Send SMS from web applications
- **Notification System**: Automated SMS notifications
- **Alert System**: Emergency or system alerts via SMS

### Integration Scenarios
- **Web-to-SMS**: Web applications sending SMS via Android device
- **IoT Notifications**: IoT devices triggering SMS alerts
- **Monitoring Systems**: System alerts and status notifications

### Development & Testing
- **SMS Testing**: Test SMS functionality without manual sending
- **Automation**: Automated SMS sending for testing scenarios
- **Remote Control**: Control SMS sending from remote applications
