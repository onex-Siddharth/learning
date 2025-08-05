# Maven Build Lifecycle Commands

## 1. Core Maven Build Lifecycles
Maven has three standard lifecycles with distinct phases:

1. **Default (build)** - Project compilation, testing, and packaging
2. **Clean** - Project cleanup
3. **Site** - Documentation generation

### Lifecycle Phases (Sequential Execution)
Each lifecycle consists of ordered phases where executing a phase runs all prior phases.

## 2. Basic Commands

| Command | Description |
|---------|-------------|
| `mvn validate` | Validates project structure |
| `mvn compile` | Compiles source code |
| `mvn test` | Runs unit tests |
| `mvn package` | Packages compiled code (JAR/WAR/etc.) |
| `mvn verify` | Runs integration tests |
| `mvn install` | Installs package to local repository |
| `mvn deploy` | Deploys to remote repository |
| `mvn clean` | Deletes the `target` directory |
| `mvn site` | Generates project documentation |

## 3. Advanced Commands

| Command | Description |
|---------|-------------|
| `mvn dependency:tree` | Displays dependency hierarchy |
| `mvn dependency:analyze` | Identifies unused dependencies |
| `mvn help:effective-pom` | Shows final POM with all inheritance |
| `mvn versions:display-dependency-updates` | Checks for dependency updates |
| `mvn archetype:generate` | Creates new project from archetype |

## 4. Test Control Commands

| Command | Description |
|---------|-------------|
| `mvn test -Dtest=TestClass` | Runs single test class |
| `mvn test -Dtest=TestClass#method` | Runs single test method |
| `mvn test -DskipTests` | Skips tests during build |
| `mvn test -Dmaven.test.failure.ignore=true` | Continues build on test failures |

## 5. Multi-Module Projects

| Command | Description |
|---------|-------------|
| `mvn -pl module-name` | Builds specific module |
| `mvn -am -pl module-name` | Builds module + dependencies |
| `mvn -rf module-name` | Resumes build from specified module |

## 6. Debugging & Optimization

| Command | Description |
|---------|-------------|
| `mvn -X` | Debug mode (verbose output) |
| `mvn --threads 2C` | Parallel builds (2 x CPU cores) |
| `mvn -o` | Offline mode (uses local cache only) |
| `mvn -Dmaven.repo.local=/path` | Custom local repository path |

## Example Workflows

```sh
# Clean and rebuild
mvn clean install

# Skip tests and build quickly
mvn package -DskipTests

# Run specific test with debug info
mvn test -Dtest=UserServiceTest -X

# Deploy snapshot to remote repo
mvn clean deploy
```
