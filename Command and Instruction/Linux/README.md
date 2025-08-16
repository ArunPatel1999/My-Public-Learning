# Linux Commands & System Administration

## 📋 Overview
Comprehensive Linux command reference and system administration guides for CentOS and Ubuntu distributions.

## 📁 Contents

<details>
<summary>📄 Linux Basic.txt - Essential Commands</summary>

### Directory Navigation
- **Navigation**: `cd`, `pwd`, `ls` with various options
- **Path Management**: Absolute vs relative paths
- **Directory Operations**: `mkdir`, `rmdir`, `tree`

### File Management
- **File Operations**: `cp`, `mv`, `rm`, `touch`, `find`
- **File Permissions**: `chmod`, `chown`, `chgrp`
- **File Content**: `cat`, `less`, `more`, `head`, `tail`
- **File Compression**: `tar`, `gzip`, `zip`, `unzip`

### User Management
- **User Operations**: `useradd`, `usermod`, `userdel`
- **Group Management**: `groupadd`, `groupmod`, `groupdel`
- **User Switching**: `su`, `sudo`, `whoami`, `id`
- **Password Management**: `passwd`, `chage`

### Applications & Processes
- **Package Management**: Distribution-specific package managers
- **Process Control**: `ps`, `top`, `htop`, `kill`, `killall`
- **Job Control**: `jobs`, `bg`, `fg`, `nohup`
- **System Services**: `systemctl`, `service`

### Searching & Text Processing
- **File Search**: `find`, `locate`, `which`, `whereis`
- **Text Search**: `grep`, `egrep`, `fgrep` with regex
- **Text Processing**: `sed`, `awk`, `cut`, `sort`, `uniq`
- **Pattern Matching**: Regular expressions and wildcards

### Storage & System Info
- **Disk Usage**: `df`, `du`, `lsblk`, `fdisk`
- **Mount Operations**: `mount`, `umount`, `/etc/fstab`
- **System Information**: `uname`, `lscpu`, `free`, `uptime`
- **Network Info**: `ifconfig`, `ip`, `netstat`, `ss`

</details>

<details>
<summary>📁 CentOS - Red Hat Enterprise Linux</summary>

### System Setup & Configuration
#### CentOS.txt
- **Initial Setup**: Post-installation configuration steps
- **Package Management**: `yum`, `dnf` package operations
- **System Updates**: Update procedures and kernel management
- **Repository Management**: Adding and configuring repositories

#### Firewall Configuration
- **firewalld**: Modern firewall management
- **iptables**: Traditional firewall rules
- **Port Management**: Opening/closing specific ports
- **Service Rules**: Allow/deny specific services
- **Zone Configuration**: Network zone management

#### Security & Access
- **Root Access**: Change root@localhost credentials
- **SSH Configuration**: Secure remote access setup
- **User Security**: Password policies and account lockout
- **SELinux**: Security-Enhanced Linux configuration

### Container Orchestration
#### Docker Swarm Setup (docker-swarm-setup.pdf)
- **Cluster Initialization**: Multi-node Docker Swarm setup
- **Manager Nodes**: Configure Swarm manager nodes
- **Worker Nodes**: Join worker nodes to the cluster
- **Service Deployment**: Deploy services across the cluster
- **Load Balancing**: Built-in load balancing configuration
- **High Availability**: Fault tolerance and failover setup

</details>

<details>
<summary>📁 Ubuntu - Debian-based Distribution</summary>

### Development Environment Setup
#### Ubuntu Server - VMBox.txt
- **Virtual Machine**: VMware/VirtualBox Ubuntu setup
- **Shared Folders**: Host-guest file sharing configuration
- **Network Configuration**: Bridged/NAT network setup
- **Guest Additions**: Enhanced VM functionality
- **Resource Allocation**: CPU, memory, and storage optimization

#### Ubuntu Server.txt - Production Setup
### User Management
- **User Creation**: Create new system users with proper permissions
- **SSH Security**: Disable password-based authentication
- **Key-based Auth**: SSH key pair setup and configuration
- **Sudo Configuration**: Grant administrative privileges

### Database Installation
- **MySQL Setup**: Complete MySQL server installation
- **Database Configuration**: Performance tuning and security
- **User Management**: Database user creation and permissions
- **Backup Setup**: Automated backup procedures

### Java Development Environment
- **Oracle JDK**: Download and install Oracle Java
- **OpenJDK**: Alternative open-source Java installation
- **Environment Variables**: JAVA_HOME and PATH configuration
- **Multiple Versions**: Java version management

### Application Server Setup
- **Tomcat Installation**: Apache Tomcat web server setup
- **Configuration**: Server.xml and context configuration
- **SSL Setup**: HTTPS configuration with certificates
- **Performance Tuning**: JVM and connector optimization

### Web Server & Reverse Proxy
- **Nginx Installation**: High-performance web server setup
- **Configuration**: Virtual hosts and server blocks
- **Reverse Proxy**: Backend application proxying
- **Load Balancing**: Multiple backend server configuration

### SSL & Security
- **Free SSL Certificates**: Let's Encrypt certificate setup
- **Certificate Management**: Renewal and automation
- **HTTPS Redirect**: Force secure connections
- **Security Headers**: Enhanced web security configuration

### Service Management
- **Background Services**: Run applications as system services
- **Systemd Configuration**: Create custom service units
- **Auto-start**: Automatic service startup on boot
- **Process Management**: Service monitoring and restart policies

### Domain & Networking
- **Domain Configuration**: Point domains to applications
- **Port Management**: Access backend without specifying ports
- **DNS Configuration**: Local and public DNS setup
- **Firewall Rules**: UFW (Uncomplicated Firewall) configuration

### Servlet/JSP Hosting
- **Standalone Deployment**: Host Java web apps without external servers
- **Embedded Servers**: Jetty/Tomcat embedded configuration
- **WAR Deployment**: Web application archive deployment
- **Context Configuration**: Application context and resources

</details>

## 🚀 Quick Start Guide

### Basic System Navigation
```bash
# Check current directory
pwd

# List files with details
ls -la

# Change directory
cd /path/to/directory

# Create directory
mkdir -p /path/to/new/directory
```

### File Operations
```bash
# Copy files
cp source.txt destination.txt

# Move/rename files
mv oldname.txt newname.txt

# Find files
find /path -name "*.txt" -type f

# Search in files
grep -r "pattern" /path/to/search
```

### User Management
```bash
# Add new user
sudo useradd -m -s /bin/bash username

# Set password
sudo passwd username

# Add to sudo group
sudo usermod -aG sudo username
```

### System Information
```bash
# System info
uname -a

# Disk usage
df -h

# Memory usage
free -h

# Running processes
ps aux | grep process_name
```

## 🔧 Common Administration Tasks

### Package Management
```bash
# Ubuntu/Debian
sudo apt update && sudo apt upgrade
sudo apt install package_name

# CentOS/RHEL
sudo yum update
sudo yum install package_name
```

### Service Management
```bash
# Start/stop services
sudo systemctl start service_name
sudo systemctl stop service_name

# Enable/disable auto-start
sudo systemctl enable service_name
sudo systemctl disable service_name

# Check service status
sudo systemctl status service_name
```

### Firewall Configuration
```bash
# Ubuntu (UFW)
sudo ufw enable
sudo ufw allow 22/tcp
sudo ufw allow 80/tcp

# CentOS (firewalld)
sudo firewall-cmd --permanent --add-port=80/tcp
sudo firewall-cmd --reload
```

## 🛡️ Security Best Practices

### SSH Hardening
- Disable root login
- Use key-based authentication
- Change default SSH port
- Configure fail2ban for brute force protection

### System Updates
- Regular security updates
- Kernel updates and reboots
- Package vulnerability scanning
- Automated update configuration

### User Security
- Strong password policies
- Regular user access reviews
- Proper sudo configuration
- Account lockout policies

## 📚 Learning Path

1. **Start with**: Linux Basic.txt for fundamental commands
2. **Choose Distribution**: 
   - CentOS for enterprise/server environments
   - Ubuntu for development/cloud environments
3. **System Administration**: User management and security
4. **Service Setup**: Web servers, databases, application servers
5. **Advanced Topics**: Container orchestration, automation
6. **Security**: Hardening and monitoring practices