# Spring_websocket_video

> **🎥 Advanced WebSocket Chat & Video**: Comprehensive WebSocket application with STOMP messaging, chat functionality, live streaming, and video communication.

## 🎯 Key Advanced WebSocket Operations Implemented

**In this project, I performed the following operations:**

1) **STOMP Protocol Integration** - Advanced messaging with STOMP over WebSocket
2) **Message Broker Configuration** - Topic-based message broadcasting system
3) **Chat System Implementation** - Real-time chat with message management
4) **Live Streaming Support** - WebSocket-based live video streaming
5) **User Presence Management** - Live user list and join/leave functionality
6) **Large Message Handling** - Custom transport limits for video data
7) **SockJS Fallback Support** - Cross-browser WebSocket compatibility

## 🎯 What This Project Does

**Advanced WebSocket application supporting real-time chat, live streaming, and video communication with STOMP messaging protocol.**

### Core Functionality:
- 🎥 **Video Streaming**: WebSocket-based live video streaming capabilities
- 💬 **Real-time Chat**: Advanced chat system with message broadcasting
- 👥 **User Management**: Live user presence and session management
- 📡 **STOMP Messaging**: Advanced messaging protocol over WebSocket
- 🔄 **Message Broker**: Topic-based message routing and broadcasting
- 📱 **Cross-browser Support**: SockJS fallback for WebSocket compatibility

## 🛠️ Technology Stack

- **STOMP Protocol**: Simple Text Oriented Messaging Protocol
- **Spring WebSocket**: Advanced WebSocket support with message broker
- **SockJS**: WebSocket fallback for cross-browser compatibility
- **Message Broker**: Topic-based message routing system
- **Large Message Support**: Custom transport limits for video data
- **Real-time Communication**: Bidirectional messaging with broadcasting

## 📚 Learning Objectives

### Advanced WebSocket Patterns
- **STOMP Protocol**: Understanding STOMP messaging over WebSocket
- **Message Broker**: Topic-based message routing and broadcasting
- **Large Data Transfer**: Handling video and large message data
- **Cross-browser Compatibility**: SockJS fallback mechanisms

### Real-time Applications
- **Chat Systems**: Building scalable real-time chat applications
- **Live Streaming**: WebSocket-based video streaming implementation
- **User Presence**: Managing user sessions and live status
- **Broadcasting**: Message broadcasting to multiple subscribers

---

## 📂 Core Components

<details>
<summary>🔧 ConfigrationClass</summary>

**Advanced WebSocket configuration with STOMP and large message support**

- **What it does**: Configures WebSocket with STOMP protocol, message broker, and custom transport limits
- **Code implementation**: 
  - **@EnableWebSocketMessageBroker**: Enables STOMP messaging over WebSocket
  - **STOMP Endpoints**: `registry.addEndpoint("/chat").withSockJS()` for client connections
  - **Message Broker**: `registry.enableSimpleBroker("/topic")` for topic-based broadcasting
  - **Transport Limits**: Custom limits for large video message handling
- **Configuration features**:
  - **Message Size**: `setMessageSizeLimit(2000000000)` for large video data (2GB limit)
  - **Send Time**: `setSendTimeLimit(20 * 100000)` for extended transmission time
  - **Buffer Size**: `setSendBufferSizeLimit(3 * 512 * 1024)` for large message buffering
  - **SockJS Support**: Cross-browser WebSocket compatibility with fallback
- **STOMP setup**:
  - **Client Endpoint**: `/chat` endpoint with SockJS fallback support
  - **Topic Broker**: `/topic` prefix for message broadcasting
  - **App Destination**: `/app` prefix for application message mapping
  - **Large Message**: Custom transport configuration for video streaming

</details>

<details>
<summary>💬 Controllers</summary>

**Message handling controllers for chat, live streaming, and user management**

- **What it does**: Handles different types of WebSocket messages including chat, live streaming, and user presence
- **Code implementation**: 
  - **Message Mapping**: `@MessageMapping` for STOMP message routing
  - **Send To**: `@SendTo` for topic-based message broadcasting
  - **Payload Processing**: `@Payload` for message data extraction
  - **Multiple Endpoints**: Different handlers for various message types
- **Message handlers**:
  - **Chat Messages**: `/message` endpoint for chat message processing
  - **Live Streaming**: `/liveStrem` endpoint for video data broadcasting
  - **User Presence**: `/setlive` endpoint for user join/leave management
  - **Test Endpoint**: `/test` endpoint for testing and development
- **Chat functionality**:
  - **Message ID**: Auto-incrementing message ID assignment
  - **Message Broadcasting**: Broadcasts chat messages to `/topic/return-to`
  - **User Management**: Maintains live user list with join/leave tracking
  - **Live Status**: Manages user presence and live streaming status
- **Streaming features**:
  - **Video Data**: Handles large video data through `/liveStrem` endpoint
  - **Real-time Broadcast**: Streams video data to `/topic/getLiveStremData`
  - **Data Passthrough**: Direct data streaming without modification
  - **Performance Note**: Suggests reactive programming for video streaming

</details>

<details>
<summary>📱 Message Entities</summary>

**Data models for chat messages, live streaming, and user management**

- **What it does**: Defines data structures for different types of WebSocket communication
- **Code implementation**: 
  - **Message Entity**: Complete chat message with metadata
  - **Live Entity**: User presence and live streaming status
  - **Type Enum**: Message type classification
  - **Video Entity**: Video streaming data structure
- **Message structure**:
  - **Message Fields**: id, name, profile, text, data, type, sendDate
  - **User Information**: name and profile for message attribution
  - **Content Data**: text content and additional data payload
  - **Timestamp**: sendDate for message chronology
- **Live streaming**:
  - **User Presence**: Live user tracking and status management
  - **Join/Leave**: Boolean flags for user session management
  - **User List**: Maintained collection of active users
  - **Status Broadcasting**: Live status updates to all clients

</details>

<details>
<summary>🔌 MyServer (Legacy Socket)</summary>

**Traditional socket server implementation for comparison**

- **What it does**: Demonstrates traditional socket programming alongside WebSocket implementation
- **Code implementation**: 
  - **ServerSocket**: Traditional TCP socket server on port 8888
  - **Multi-threading**: Separate threads for reading and writing
  - **Bidirectional Communication**: Concurrent read/write operations
  - **Connection Management**: Manual socket connection handling
- **Socket features**:
  - **TCP Communication**: Traditional socket-based communication
  - **Thread Management**: Manual thread creation for concurrent operations
  - **Input/Output Streams**: BufferedReader and PrintWriter for communication
  - **Connection Lifecycle**: Manual connection establishment and cleanup
- **Comparison purpose**:
  - **WebSocket vs Socket**: Demonstrates difference between protocols
  - **Complexity**: Shows WebSocket simplicity vs traditional sockets
  - **Framework Benefits**: Highlights Spring WebSocket advantages

</details>

## 🌟 Advanced WebSocket Features

### 🎥 Video Streaming Capabilities
- **Large Message Support**: 2GB message size limit for video data
- **Real-time Streaming**: WebSocket-based live video transmission
- **Buffer Management**: Custom buffer sizes for smooth video streaming
- **Performance Optimization**: Extended send time limits for large data

### 💬 Advanced Chat System
- **Message Broadcasting**: Topic-based message distribution
- **User Presence**: Real-time user list and status management
- **Message Metadata**: Complete message information with timestamps
- **Session Management**: User join/leave tracking and broadcasting

### 📡 STOMP Protocol Benefits
- **Structured Messaging**: STOMP protocol for organized message handling
- **Topic Subscription**: Clients subscribe to specific topics
- **Message Routing**: Automatic message routing based on destinations
- **Protocol Standards**: Industry-standard messaging protocol

### 🔄 Cross-browser Compatibility
- **SockJS Fallback**: Automatic fallback for browsers without WebSocket support
- **Transport Options**: Multiple transport mechanisms (WebSocket, polling, etc.)
- **Compatibility Layer**: Seamless experience across different browsers
- **Progressive Enhancement**: Graceful degradation for older browsers

## 🚀 WebSocket Communication Flow

### Chat Flow
1. **Client Connection**: Client connects to `/chat` endpoint with SockJS
2. **Topic Subscription**: Client subscribes to `/topic/return-to` for chat messages
3. **Message Sending**: Client sends message to `/app/message`
4. **Message Processing**: Server processes message and assigns ID
5. **Broadcasting**: Server broadcasts message to all subscribers
6. **Real-time Delivery**: All connected clients receive message instantly

### Live Streaming Flow
1. **User Join**: User joins live session via `/app/setlive`
2. **Presence Update**: Server updates live user list and broadcasts
3. **Video Streaming**: Client sends video data to `/app/liveStrem`
4. **Data Broadcasting**: Server streams video to `/topic/getLiveStremData`
5. **Real-time Viewing**: All subscribers receive live video stream
6. **User Leave**: User leaves session, server updates presence

## 📡 WebSocket Endpoints
- **Connection**: `/chat` with SockJS fallback
- **Chat Messages**: `/app/message` → `/topic/return-to`
- **Live Streaming**: `/app/liveStrem` → `/topic/getLiveStremData`
- **User Presence**: `/app/setlive` → `/topic/return-to`
- **Testing**: `/app/test` → `/topic/getTest`

## 🔧 Configuration Benefits
- **Large Data Support**: Custom transport limits for video streaming
- **Cross-browser**: SockJS ensures compatibility across all browsers
- **Scalable Architecture**: Topic-based broadcasting for multiple clients
- **Performance Optimized**: Custom buffer and timeout settings for large messages