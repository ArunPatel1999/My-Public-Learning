# Docker Commands & Examples

## 📋 Overview
This folder contains comprehensive Docker commands, configurations, and practical examples for containerization workflows.

## 📁 Contents

<details>
<summary>📄 Docker.txt - Core Docker Commands</summary>

### Container Management
- **Lifecycle**: `docker run`, `docker stop`, `docker start`, `docker restart`
- **Cleanup**: Stop/remove all containers and images
- **Interactive Mode**: `docker exec -it` for terminal access
- **Monitoring**: `docker ps`, `docker logs`, `docker stats`, `docker top`

### Image Operations
- **Pull/Push**: `docker pull`, `docker push`, `docker search`
- **Build**: `docker build -t imagename .`
- **Management**: `docker images`, `docker rmi`, `docker history`
- **Import/Export**: Container and image backup/restore

### Networking & Volumes
- **Networks**: Create custom networks, connect containers
- **Volumes**: Bind mounts, volume management, permissions
- **Port Mapping**: `-p` flag for port forwarding

### Docker Registry
- **Private Registry**: Setup local registry on port 5000
- **Image Tagging**: Tag and push to custom registries
- **Security**: Configure insecure registries

### Docker REST API
- **Remote Access**: Configure Docker daemon for remote connections
- **API Usage**: Control Docker from remote machines

</details>

<details>
<summary>📄 Compose.txt - Docker Compose Commands</summary>

### Project Management
- **Up/Down**: `docker-compose up -d`, `docker-compose down`
- **Scaling**: `--scale service_name=count` for horizontal scaling
- **Custom Files**: `-f filename` for different compose files
- **Project Naming**: `-p projectname` for organized deployments

### Build & Development
- **Rebuild**: `--build` flag for image rebuilding
- **Development**: Hot reload and development configurations

</details>

<details>
<summary>📄 Docker Software.txt - Practical Examples</summary>

### Image Management
- **Pull & Run**: Step-by-step image pulling and container execution
- **Configuration**: Environment variables and runtime settings
- **Best Practices**: Efficient image usage and optimization

</details>

<details>
<summary>📁 Docker Examples - Application Dockerfiles</summary>

### Available Examples
- **Core Java**: Basic Java application containerization
- **Jenkins with Docker**: CI/CD pipeline setup
- **Spring Boot JAR**: Production-ready Spring Boot deployment with health checks
- **Spring Boot Gradle**: Gradle-based build without JAR packaging
- **Spring Boot Maven**: Maven-based build without JAR packaging

</details>

<details>
<summary>📁 Compose Example - Multi-Service Applications</summary>

### Site Visitor Example
- **Services**: Redis + Application containers
- **Purpose**: Website visitor tracking system
- **Features**: Multi-container orchestration, data persistence

</details>

<details>
<summary>📄 Swarm.txt - Docker Swarm Orchestration</summary>

### Cluster Management
- **Swarm Mode**: Initialize and manage Docker Swarm clusters
- **Service Deployment**: Deploy services across multiple nodes
- **Load Balancing**: Built-in load balancing and service discovery

</details>

## 🚀 Quick Start

1. **Basic Container**: `docker run -it ubuntu bash`
2. **Background Service**: `docker run -d -p 80:80 nginx`
3. **Build Custom Image**: `docker build -t myapp .`
4. **Compose Application**: `docker-compose up -d`

## 🔧 Common Patterns

### Development Workflow
```bash
# Build and run
docker build -t myapp .
docker run -p 8080:8080 myapp

# Development with volume
docker run -v $(pwd):/app -p 8080:8080 myapp
```

### Production Deployment
```bash
# Multi-stage build
docker build -t myapp:prod -f Dockerfile.prod .
docker run -d --restart=always -p 80:8080 myapp:prod
```

## 📚 Learning Path

1. **Start with**: Docker.txt for basic commands
2. **Practice with**: Docker Examples for real applications
3. **Scale up**: Compose.txt for multi-container apps
4. **Advanced**: Swarm.txt for cluster management