# Spring_websocket_video

<details>
<summary>Project Overview</summary>

This Spring Boot application demonstrates WebSocket implementation for real-time communication, supporting both chat messaging and video streaming capabilities with STOMP protocol integration.

</details>

<details>
<summary>WebSocket Configuration</summary>

**STOMP Protocol Setup**
- EnableWebSocketMessageBroker for STOMP messaging
- SockJS fallback support for browsers without WebSocket support
- Custom transport configuration for large message handling

**Message Broker Configuration**
- Simple broker enabled for `/topic` destinations
- Application destination prefix set to `/app`
- Real-time message broadcasting capabilities

**Transport Settings**
- Message size limit: 2GB (for large video files)
- Send time limit: Extended for video streaming
- Send buffer size: 1.5MB for efficient data transfer

</details>

<details>
<summary>Communication Features</summary>

**WebSocket Chat**
- Real-time messaging between clients
- STOMP endpoint at `/chat` with SockJS support
- Message broadcasting to subscribed clients

**Socket Server (Alternative)**
- Traditional socket server implementation (commented)
- Direct TCP connection on port 8888
- Bidirectional communication with reading/writing threads
- Console-based chat interface

</details>

<details>
<summary>Entity Structure</summary>

**Message Entity**
- Fields: id, name, profile, text, data, type, sendDate
- Supports different message types (text, media, etc.)
- User profile and timestamp information
- Generic data field for various content types

**Video Entity**
- Fields: id, name, data
- Video streaming data container
- Base64 or binary data support

**Type Enum**
- Message type classification
- Supports different content types

**Live Entity**
- Real-time streaming support
- Live video/audio communication

</details>

<details>
<summary>Architecture Components</summary>

**Controllers**
- Controllers: Main WebSocket message handling
- MyServer: Alternative socket server implementation

**Configuration**
- ConfigurationClass: WebSocket and STOMP configuration
- Transport and broker settings
- Endpoint registration

**Real-time Features**
- Instant message delivery
- Video streaming capabilities
- Multi-client support
- SockJS fallback for compatibility

</details>

<details>
<summary>Key Features</summary>

**WebSocket Communication**
- STOMP protocol for structured messaging
- Real-time bidirectional communication
- Topic-based message broadcasting

**Video Streaming**
- Large file transfer support (2GB limit)
- Optimized buffer settings for video data
- Real-time video communication

**Fallback Support**
- SockJS for browsers without WebSocket support
- Alternative socket server implementation
- Cross-browser compatibility

</details>

<details>
<summary>Technologies Used</summary>

- Spring Boot
- Spring WebSocket
- STOMP Protocol
- SockJS
- Java Socket Programming
- Maven

</details>