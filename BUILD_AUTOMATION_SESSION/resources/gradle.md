# Gradle Build Lifecycle Commands

## 1. Core Gradle Build Lifecycle Commands
Gradle builds follow a three-phase lifecycle:

1. **Initialization** – Sets up the project hierarchy (e.g., single or multi-project builds)
2. **Configuration** – Evaluates build scripts and resolves dependencies
3. **Execution** – Runs the tasks specified in the command

### Basic Commands

| Command | Description |
|---------|-------------|
| `gradle tasks` | Lists all available tasks in the project |
| `gradle build` | Runs compilation, tests, and packaging (creates JAR/WAR) |
| `gradle clean` | Deletes the `build` directory (removes compiled files) |
| `gradle assemble` | Compiles and packages code without running tests |
| `gradle check` | Runs verification tasks (tests, linting, etc.) without packaging |

## 2. Task-Specific Commands

| Command | Description |
|---------|-------------|
| `gradle compileJava` | Compiles Java source files (no tests) |
| `gradle processResources` | Copies resources to the build directory |
| `gradle classes` | Compiles Java + processes resources (but does not package) |
| `gradle test` | Runs unit tests (outputs reports in `build/reports/tests/`) |
| `gradle test --tests "com.example.*"` | Runs tests matching a pattern |
| `gradle jar` | Creates a JAR file (in `build/libs/`) |
| `gradle javadoc` | Generates JavaDoc documentation |

## 3. Advanced & Useful Commands

| Command | Description |
|---------|-------------|
| `gradle dependencies` | Lists all project dependencies |
| `gradle dependencyInsight --dependency <lib>` | Analyzes a specific dependency |
| `gradle build --scan` | Generates a detailed build scan (shared online) |
| `gradle publishToMavenLocal` | Publishes artifacts to the local Maven repo (`~/.m2`) |
| `gradle clean build` | Cleans & rebuilds from scratch |
| `gradle build -x test` | Skips tests during build |

## 4. Multi-Project Build Commands

| Command | Description |
|---------|-------------|
| `gradle :subproject:build` | Builds a specific subproject |
| `gradle projects` | Lists all subprojects |

## 5. Debugging & Performance

| Command | Description |
|---------|-------------|
| `gradle build --info` | Shows detailed logs |
| `gradle build --debug` | Enables debug logging |
| `gradle build --dry-run` | Simulates task execution (no actual changes) |
| `gradle build --parallel` | Runs tasks in parallel (faster builds) |

## Example Workflow

```sh
# Clean previous builds
gradle clean

# Run tests and build JAR
gradle build

# Skip tests and just assemble
gradle assemble -x test

# Check dependency conflicts
gradle dependencyInsight --dependency junit