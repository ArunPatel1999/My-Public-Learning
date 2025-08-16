# WebFlux-Video-Stremming

## 🎯 What This Project Does

**Reactive video streaming application using Spring WebFlux with HTTP Range request support for efficient video delivery.**

### Core Functionality:
- 🎬 **Video Streaming**: Reactive video file serving with range request support
- 📡 **HTTP Range Requests**: Supports partial content delivery for video seeking
- ⚡ **Non-blocking I/O**: WebFlux reactive streaming for efficient resource usage
- 🌐 **Web Interface**: Bootstrap-based video player with HTML5 video controls
- 📁 **Resource Management**: Classpath-based video file serving

## 🛠️ Technology Stack

- **Spring WebFlux**: Reactive web framework
- **Spring Boot**: Application framework
- **ResourceLoader**: Spring resource abstraction
- **HTML5 Video**: Native browser video playback
- **Bootstrap**: Frontend styling framework
- **HTTP Range Requests**: Partial content delivery protocol

## 📚 Learning Objectives

### Reactive Streaming
- **Non-blocking I/O**: Efficient resource handling with reactive streams
- **Resource Streaming**: File-based content delivery with Spring WebFlux
- **Mono Operations**: Single-value reactive operations for resource loading
- **Backpressure**: Automatic flow control in video streaming

### HTTP Protocol Features
- **Range Requests**: HTTP/1.1 partial content delivery
- **Video Seeking**: Browser-initiated range requests for video navigation
- **Content Negotiation**: Proper media type handling for video files
- **Resource Optimization**: Efficient bandwidth usage with partial downloads

---

## 📂 Core Components

<details>
<summary>🎬 Controller</summary>

**Reactive video streaming controller with Range request support**

- **What it does**: Serves video files reactively with HTTP Range request handling
- **Code implementation**: 
  - **Resource Loading**: `resourceLoader.getResource("classpath:" + name)` for file access
  - **Reactive Response**: `Mono.fromSupplier()` for non-blocking resource loading
  - **Range Header**: `@RequestHeader("Range")` for partial content requests
  - **Path Variables**: `@PathVariable String name` for dynamic video selection
- **API endpoint**: GET /video/{name} - Stream video file by name
- **Key features**:
  - **Range Support**: Handles HTTP Range headers for video seeking
  - **Reactive Loading**: Non-blocking file resource loading
  - **Dynamic Serving**: Serves any video file from classpath by name
  - **Debug Logging**: Prints Range header values for debugging
- **HTTP behavior**:
  - **Full Request**: Returns complete video file when no Range header
  - **Partial Request**: Supports byte-range requests for video seeking
  - **Browser Integration**: Works with HTML5 video controls automatically

</details>

<details>
<summary>🌐 index.html</summary>

**Bootstrap-styled video player interface**

- **What it does**: Provides web interface for video streaming with HTML5 video player
- **Code implementation**: 
  - **HTML5 Video**: `<video src="video/1. Introduction.mp4" controls preload="none">`
  - **Bootstrap Styling**: Responsive design with Bootstrap 5.1.0
  - **Video Controls**: Native browser controls for play, pause, seek, volume
  - **Responsive Layout**: Container-based layout for different screen sizes
- **Features**:
  - **Preload None**: `preload="none"` prevents automatic video loading
  - **Native Controls**: Browser-provided video player interface
  - **Responsive Design**: Bootstrap container for mobile-friendly layout
  - **Direct Integration**: Video src points to reactive streaming endpoint
- **User experience**:
  - **Instant Seeking**: Range requests enable immediate video seeking
  - **Bandwidth Efficient**: Only loads requested video segments
  - **Cross-browser**: Works with all modern browsers supporting HTML5 video

</details>

## 🌟 Advanced Features

### 📡 HTTP Range Request Support
- **Partial Content**: Enables video seeking without downloading entire file
- **Bandwidth Optimization**: Only transfers requested byte ranges
- **Browser Integration**: Automatic range request handling by HTML5 video
- **Seeking Performance**: Instant video navigation to any position

### ⚡ Reactive Resource Handling
- **Non-blocking I/O**: WebFlux handles file streaming without blocking threads
- **Resource Abstraction**: Spring ResourceLoader for flexible file access
- **Mono Supplier**: Lazy resource loading with `Mono.fromSupplier()`
- **Memory Efficiency**: Streaming delivery without loading entire file in memory

### 🎬 Video Streaming Optimization
- **Classpath Resources**: Videos served from application resources
- **Dynamic File Selection**: URL path-based video file selection
- **Content Type Detection**: Automatic MIME type handling for video files
- **Browser Compatibility**: Works with all HTML5 video-capable browsers

### 🌐 Web Integration
- **Bootstrap UI**: Professional-looking video player interface
- **Responsive Design**: Mobile-friendly video streaming
- **Native Controls**: Browser-provided video player functionality
- **Progressive Loading**: Video loads only when needed

## 🔧 Technical Implementation

### Range Request Flow
1. **Initial Request**: Browser requests video metadata
2. **Range Headers**: Browser sends Range: bytes=0-1023 for seeking
3. **Reactive Processing**: WebFlux handles range request non-blocking
4. **Partial Response**: Server returns requested byte range
5. **Seamless Playback**: Browser continues video from requested position

### Resource Management
- **Classpath Loading**: Videos stored in src/main/resources
- **Spring ResourceLoader**: Abstracted file access mechanism
- **Reactive Streams**: Non-blocking file serving with backpressure
- **Memory Efficiency**: Streaming without full file loading