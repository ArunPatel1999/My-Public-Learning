# Kubernetes - Container Orchestration Platform

## 📋 Overview
Complete Kubernetes command reference, YAML configurations, and deployment examples for container orchestration and management.

## 📁 Contents

<details>
<summary>📄 kubectl.txt - Kubernetes CLI Commands</summary>

### Cluster Management
- **Cluster Info**: `kubectl cluster-info`, `kubectl version`
- **Node Management**: List, describe, and manage cluster nodes
- **Namespace Operations**: Create, switch, and manage namespaces
- **Resource Quotas**: Set and manage resource limits

### Workload Management
- **Pods**: Create, list, describe, delete pods
- **Deployments**: Manage application deployments and rollouts
- **Services**: Expose applications and manage networking
- **ConfigMaps/Secrets**: Manage configuration and sensitive data

### Debugging & Troubleshooting
- **Logs**: `kubectl logs` for container logs
- **Exec**: `kubectl exec` for container access
- **Port Forwarding**: `kubectl port-forward` for local access
- **Events**: Monitor cluster events and issues

</details>

<details>
<summary>📄 minikube.txt - Local Development Environment</summary>

### Minikube Operations
- **Cluster Lifecycle**: Start, stop, delete local clusters
- **Configuration**: CPU, memory, and driver settings
- **Add-ons**: Enable dashboard, ingress, metrics-server
- **Multi-node**: Local multi-node cluster simulation

### Development Features
- **Docker Integration**: Use local Docker images
- **Load Balancer**: Tunnel services for local access
- **Persistent Volumes**: Local storage configuration
- **Networking**: Service exposure and ingress setup

</details>

<details>
<summary>📄 kubeadm.txt - Cluster Bootstrap Tool</summary>

### Cluster Initialization
- **Master Setup**: Initialize control plane nodes
- **Worker Nodes**: Join worker nodes to cluster
- **Network Setup**: CNI plugin installation and configuration
- **Certificate Management**: PKI and certificate handling

### Cluster Management
- **Upgrades**: Cluster version upgrades
- **Backup/Restore**: etcd backup and restore procedures
- **High Availability**: Multi-master cluster setup
- **Troubleshooting**: Common cluster issues and solutions

</details>

<details>
<summary>📄 Kubernates YAML.txt - Resource Definitions</summary>

### YAML Structure
- **API Versions**: Understanding Kubernetes API versions
- **Resource Types**: Pods, Deployments, Services, etc.
- **Metadata**: Labels, annotations, and naming conventions
- **Specifications**: Resource-specific configuration options

### Best Practices
- **Resource Limits**: CPU and memory constraints
- **Health Checks**: Liveness and readiness probes
- **Security**: Security contexts and pod security policies
- **Networking**: Service types and ingress configurations

</details>

<details>
<summary>📄 Before Kubernetes Start.txt - Prerequisites</summary>

### System Requirements
- **Linux Setup**: Ubuntu/CentOS configuration for Kubernetes
- **VMBox Configuration**: Virtual machine setup and networking
- **Container Runtime**: Docker or containerd installation
- **Network Configuration**: CNI requirements and setup

### Pre-installation Steps
- **System Updates**: OS patches and kernel requirements
- **Firewall Rules**: Required ports and network access
- **User Permissions**: Non-root user setup and sudo access
- **Resource Planning**: CPU, memory, and storage requirements

</details>

<details>
<summary>📁 YAMLs - Configuration Examples</summary>

### Basic Resources
- **1. Nginx Pod.yml**: Simple pod definition
- **1. Nginx deployment.yml**: Deployment with replicas
- **1. Nginx replica set.yml**: ReplicaSet configuration
- **1. Nginx replication controller.yml**: Legacy replication controller

### Service Types
- **1. Service ClusterIP.yml**: Internal cluster communication
- **1. Service NodePort.yml**: External access via node ports

### Complex Applications
#### Voting Application V1 (Pods & Services)
- **Pod Definitions**: Individual application components
- **Service Definitions**: Network access and load balancing
- **Simple Architecture**: Basic multi-tier application

#### Voting Application V2 (Deployments & Services)
- **Deployment Definitions**: Scalable application components
- **Service Definitions**: Advanced networking and discovery
- **Production Ready**: Scalable and resilient architecture

</details>

## 🚀 Quick Start Guide

### 1. Local Development with Minikube
```bash
# Start minikube
minikube start --cpus=2 --memory=4096

# Enable dashboard
minikube addons enable dashboard

# Access dashboard
minikube dashboard
```

### 2. Basic Pod Deployment
```bash
# Create pod from YAML
kubectl apply -f nginx-pod.yml

# Check pod status
kubectl get pods

# Access pod logs
kubectl logs nginx-pod
```

### 3. Application Deployment
```bash
# Deploy application
kubectl apply -f nginx-deployment.yml

# Expose as service
kubectl apply -f nginx-service.yml

# Scale deployment
kubectl scale deployment nginx --replicas=3
```

## 🔧 Common Operations

### Resource Management
```bash
# Get all resources
kubectl get all

# Describe resource
kubectl describe pod <pod-name>

# Delete resource
kubectl delete -f deployment.yml
```

### Debugging
```bash
# Get pod logs
kubectl logs <pod-name> -f

# Execute commands in pod
kubectl exec -it <pod-name> -- /bin/bash

# Port forward to local machine
kubectl port-forward <pod-name> 8080:80
```

### Configuration Management
```bash
# Create configmap
kubectl create configmap app-config --from-file=config.properties

# Create secret
kubectl create secret generic app-secret --from-literal=password=secret123

# Apply configuration
kubectl apply -f configmap.yml
```

## 📊 Example Applications

### Simple Nginx Deployment
- **Pod**: Single container deployment
- **ReplicaSet**: Multiple replica management
- **Deployment**: Rolling updates and rollbacks
- **Service**: Load balancing and discovery

### Voting Application
- **Architecture**: Multi-tier web application
- **Components**: Frontend, backend, database, cache
- **Networking**: Inter-service communication
- **Scaling**: Horizontal pod autoscaling

## 🛡️ Security & Best Practices

### Resource Limits
```yaml
resources:
  requests:
    memory: "64Mi"
    cpu: "250m"
  limits:
    memory: "128Mi"
    cpu: "500m"
```

### Health Checks
```yaml
livenessProbe:
  httpGet:
    path: /health
    port: 8080
  initialDelaySeconds: 30
  periodSeconds: 10
```

### Security Context
```yaml
securityContext:
  runAsNonRoot: true
  runAsUser: 1000
  fsGroup: 2000
```

## 📚 Learning Path

1. **Prerequisites**: Before Kubernetes Start.txt for system setup
2. **Local Environment**: minikube.txt for development setup
3. **Basic Commands**: kubectl.txt for CLI operations
4. **YAML Basics**: Kubernates YAML.txt for resource definitions
5. **Simple Deployments**: Basic YAML examples (Nginx)
6. **Complex Applications**: Voting application examples
7. **Production Setup**: kubeadm.txt for cluster deployment