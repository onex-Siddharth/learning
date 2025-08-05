```table-of-contents
title: 
style: nestedList # TOC style (nestedList|nestedOrderedList|inlineFirstLevel)
minLevel: 0 # Include headings from the specified level
maxLevel: 0 # Include headings up to the specified level
includeLinks: true # Make headings clickable
hideWhenEmpty: false # Hide TOC if no headings are found
debugInConsole: false # Print debug info in Obsidian console
```

# History

### What Before Spring and SpringBoot ?

Typical Stack: 
- Java EE (now Jakarta EE)
- Servlets, JSP, EJB (Enterprise Java Beans), JDBC
- Heavy reliance on XML configuration

### What Before Build Automation Tools (Maven & Gradle)?

- Manual, Platform-Specific Builds
- No Dependency Management
- Inconsistent Builds
- No Standardized Task Automation
- No Separation of Concerns (Main & Test Code Mixed)
- Project-Specific Hand-Written Scripts


# Content

## Build Automation Tools:

### JAVA
#### Maven

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>sample-project</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>2.7.0</version>
        </dependency>
    </dependencies>
</project>

```
#### Gradle 

```gradle
plugins {
    id 'java'
}

group = 'com.example'
version = '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web:2.7.0'
}

tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
}

```

### Node.js
#### Package.json

```json
{
  "name": "sample-node-project",
  "version": "1.0.0",
  "description": "Sample Node.js project",
  "main": "index.js",
  "scripts": {
    "start": "node index.js"
  },
  "dependencies": {
    "express": "^4.18.2"
  }
}

```

### Python
#### Requirements.txt (Older Approach)

```txt
Flask==2.3.2
requests==2.31.0
```

#### Pyproject.toml (Modern Approach)

```toml
[project]
name = "python-deps-demo"
version = "0.1.0"
description = "Demo project for Python dependency management"
authors = [
    { name = "Your Name", email = "your.email@example.com" },
]
dependencies = [
    "requests>=2.28.0",
    "numpy>=1.21.0",
]
requires-python = ">=3.8"

[project.optional-dependencies]
dev = [
    "pytest>=7.0",
    "pytest-cov>=4.0",
]
lint = [
    "black>=23.0",
    "flake8>=6.0",
]

[build-system]
requires = ["setuptools>=61.0.0"]
build-backend = "setuptools.build_meta"

[tool.pytest.ini_options]
python_files = "test_*.py"
addopts = "--verbose"
```

## Automation:

### Bash

### Power shell

### Python

