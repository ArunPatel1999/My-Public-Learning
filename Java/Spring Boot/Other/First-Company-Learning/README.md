# First-Company-Learning

> **🏢 Enterprise Spring Boot Operations Hub**: This project contains main operations and Spring Boot implementations for real-world enterprise applications.

## 🎯 Key Operations Implemented

**In this project, I performed the following operations:**

1) **GraphQL** - Flexible query language implementation
2) **Log file generator** - Automated logging and file generation
3) **Swagger** - Interactive API documentation
4) **Basic API Testing** - Comprehensive endpoint testing
5) **Firebase File Upload** - Cloud storage integration
6) **Video stream** - Media streaming capabilities
7) **Mail sender** - Professional email services
8) **Firebase notification** - Push notification system
9) **String To Json Converter** - Data transformation utilities

## 🎯 What This Project Does

**Enterprise Spring Boot application demonstrating real-world integrations including Firebase, email services, image processing, notifications, and API documentation.**

### Core Functionality:
- 🔥 **Firebase Integration**: File upload, storage, and push notifications
- 📧 **Email Services**: JavaMail integration with HTML templates and attachments
- 🖼️ **Image Processing**: Multi-image handling, Base64 encoding, and streaming
- 📱 **Push Notifications**: Firebase Cloud Messaging for mobile notifications
- 📚 **API Documentation**: Swagger integration for comprehensive API docs
- 🔍 **GraphQL**: Query resolver implementation for flexible data fetching

## 🛠️ Technology Stack

- **Spring Boot**: Enterprise application framework
- **Firebase**: Cloud storage, authentication, and messaging
- **JavaMail**: Email sending with SMTP configuration
- **Swagger**: API documentation and testing interface
- **GraphQL**: Flexible query language for APIs
- **Apache Commons**: Utility libraries for file operations
- **MongoDB**: NoSQL database integration
- **Base64 Encoding**: Image data encoding and streaming

## 📚 Learning Objectives

### Enterprise Integrations
- **Cloud Services**: Firebase storage and messaging integration
- **Email Systems**: Professional email sending with templates
- **API Documentation**: Swagger for developer-friendly documentation
- **Real-time Communication**: Push notifications and messaging

### File and Media Processing
- **File Upload**: Multi-part file handling and cloud storage
- **Image Processing**: Multiple image formats and streaming
- **Base64 Encoding**: Image data conversion and embedding
- **Media Streaming**: Efficient file delivery mechanisms

---

## 📂 Core Components

<details>
<summary>🔥 FirebaseFileUpload</summary>

**Firebase Cloud Storage integration with file upload and management**

- **What it does**: Handles file uploads to Firebase Storage with metadata management
- **Code implementation**: 
  - **Upload Endpoint**: POST /api/firebaseupload/{type}/{movieName}/{folder}
  - **Delete Endpoint**: DELETE /api/firebaseupload/{type}/{movieName}/{folder}
  - **Storage Operations**: BlobId, BlobInfo for Firebase Storage operations
  - **Metadata Management**: Custom metadata with firebaseStorageDownloadTokens
- **Firebase features**:
  - **StorageClient**: Firebase Storage client for bucket operations
  - **Blob Operations**: Create, delete, and manage storage objects
  - **Custom Naming**: Dynamic file naming with movieName and folder structure
  - **Content Type**: Automatic content type detection and setting
- **Advanced operations**:
  - **Credential Management**: GoogleCredentials with service account JSON
  - **URL Generation**: Custom download URL construction
  - **Error Handling**: Comprehensive exception handling for storage operations

</details>

<details>
<summary>🖼️ ImageController</summary>

**Advanced image processing with multiple formats and streaming**

- **What it does**: Handles image serving, multi-image responses, and Base64 encoding
- **Code implementation**: 
  - **Image Streaming**: Direct file streaming to HttpServletResponse
  - **Multi-image Response**: Multipart response with multiple images
  - **HTML Embedding**: Base64-encoded images in HTML responses
  - **Boundary Handling**: Custom multipart boundary management
- **Image processing features**:
  - **File Streaming**: StreamUtils.copy() for efficient file transfer
  - **Base64 Conversion**: Apache Commons Base64 encoding
  - **HTML Generation**: Dynamic HTML with embedded images
  - **Content Type Management**: Proper MIME type handling
- **Advanced capabilities**:
  - **Multipart Responses**: Custom multipart/x-mixed-replace responses
  - **Array Operations**: ArrayUtils for byte array manipulation
  - **Memory Efficiency**: Stream-based processing for large files

</details>

<details>
<summary>📧 MailController</summary>

**Professional email service with HTML templates and attachments**

- **What it does**: Sends emails using JavaMail with HTML content and multiple recipients
- **Code implementation**: 
  - **JavaMailSender**: Spring Boot email integration
  - **MimeMessageHelper**: Advanced email composition with HTML support
  - **Multiple Recipients**: Array-based recipient management
  - **HTML Content**: Rich HTML email templates with styling
- **Email features**:
  - **SMTP Configuration**: Gmail SMTP with authentication
  - **HTML Templates**: Rich HTML content with CSS styling
  - **Attachment Support**: File attachment capabilities (commented)
  - **Multiple Recipients**: Bulk email sending to multiple addresses
- **Configuration options**:
  - **SMTP Properties**: Detailed SMTP server configuration
  - **Authentication**: Username/password authentication
  - **TLS Support**: Secure email transmission
  - **Custom Headers**: Date, subject, and content type management

</details>

<details>
<summary>📱 NotificationController</summary>

**Firebase Cloud Messaging for push notifications**

- **What it does**: Sends push notifications to mobile devices via Firebase FCM
- **Code implementation**: 
  - **FCM Integration**: FirebaseMessaging.getInstance() for message sending
  - **Message Builder**: Notification title, body, and configuration
  - **Android Config**: Platform-specific configuration with high priority
  - **Token-based**: Device token-based message targeting
- **Notification features**:
  - **Cross-platform**: Android-specific configuration with extensibility
  - **Priority Management**: High priority for important notifications
  - **Error Handling**: Comprehensive Firebase exception handling
  - **Response Tracking**: Message ID tracking for delivery confirmation
- **API endpoint**: GET /{token}/{title}/{body} - Send notification with parameters

</details>

<details>
<summary>📚 SwaggerConfiguration</summary>

**Comprehensive API documentation with Swagger integration**

- **What it does**: Provides interactive API documentation and testing interface
- **Code implementation**: 
  - **Docket Configuration**: Swagger 2 documentation setup
  - **API Selection**: RequestHandlerSelectors for endpoint discovery
  - **UI Configuration**: Custom UI settings with method sorting
  - **Metadata**: API information, version, and licensing details
- **Documentation features**:
  - **Interactive Testing**: Built-in API testing interface
  - **Method Sorting**: Organized endpoint display
  - **Comprehensive Coverage**: All endpoints automatically documented
  - **Professional Metadata**: Title, version, description, and licensing
- **Developer experience**:
  - **Live Testing**: Direct API testing from documentation
  - **Request/Response Examples**: Automatic example generation
  - **Parameter Documentation**: Detailed parameter descriptions

</details>

<details>
<summary>🔍 Graphql</summary>

**GraphQL query resolver for flexible data fetching**

- **What it does**: Provides GraphQL endpoint for flexible user data queries
- **Code implementation**: 
  - **GraphQLQueryResolver**: Interface implementation for query handling
  - **Service Integration**: UserServiceInterface for data access
  - **Query Methods**: getAll() method for user data retrieval
- **GraphQL features**:
  - **Flexible Queries**: Client-specified data fetching
  - **Type Safety**: Strongly typed query resolution
  - **Service Layer**: Integration with existing service architecture
  - **Extensible**: Easy addition of new query methods

</details>

## 🌟 Enterprise Features

### 🔥 Firebase Cloud Integration
- **Storage Management**: File upload, download, and deletion
- **Push Notifications**: Cross-platform mobile notifications
- **Authentication**: Service account-based secure access
- **Metadata Management**: Custom file metadata and tokens

### 📧 Professional Email System
- **HTML Templates**: Rich email content with CSS styling
- **Multiple Recipients**: Bulk email capabilities
- **SMTP Configuration**: Production-ready email server setup
- **Attachment Support**: File attachment capabilities

### 🖼️ Advanced Media Processing
- **Multi-format Support**: Various image formats and processing
- **Streaming Responses**: Efficient large file delivery
- **Base64 Encoding**: Image embedding in web responses
- **Multipart Responses**: Complex response format handling

### 📚 Developer Experience
- **Swagger Documentation**: Interactive API documentation
- **GraphQL Flexibility**: Client-driven data fetching
- **Error Handling**: Comprehensive exception management
- **Configuration Management**: Environment-specific settings

## 🚀 Production Considerations
- **Security**: Service account authentication and secure configurations
- **Scalability**: Cloud storage and messaging for high availability
- **Monitoring**: Response tracking and error logging
- **Documentation**: Comprehensive API documentation for team collaboration