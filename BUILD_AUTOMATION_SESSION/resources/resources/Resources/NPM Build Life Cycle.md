
## 1. Core npm Lifecycle Phases
npm executes scripts in a specific order during common operations:

1. **Pre- Hooks** (`pre*`) - Runs before main script
2. **Main Script** - Primary operation
3. **Post- Hooks** (`post*`) - Runs after main script

### Default Lifecycle Scripts (in execution order)

| Script | Triggered When |
|--------|----------------|
| `prepublish` | Before package is packed and published (deprecated) |
| `prepare` | Before package is packed (runs on `npm install` too) |
| `prepack` | Before tarball is packed |
| `postpack` | After tarball is packed |
| `publish` | After package is published |
| `postpublish` | After package is published |

## 2. Basic npm Commands

| Command                 | Description                            |
| ----------------------- | -------------------------------------- |
| `npm install`           | Installs all dependencies              |
| `npm install <package>` | Adds a dependency                      |
| `npm run build`         | Runs project build script              |
| `npm test`              | Executes test scripts                  |
| `npm start`             | Starts the application                 |
| `npm stop`              | Stops the application                  |
| `npm restart`           | Restarts the application               |


## 3. Development Workflow Commands

| Command | Description |
|---------|-------------|
| `npm run dev` | Common development starter |
| `npm run lint` | Runs code linter |
| `npm run format` | Formats code (Prettier, etc.) |
| `npm run watch` | Watches files for changes |
| `npm run serve` | Starts development server |

## 4. Dependency Management

| Command | Description |
|---------|-------------|
| `npm outdated` | Checks for outdated packages |
| `npm update` | Updates packages to latest versions |
| `npm audit` | Checks for security vulnerabilities |
| `npm audit fix` | Fixes vulnerabilities automatically |
| `npm ls` | Lists installed dependencies |
| `npm dedupe` | Reduces duplication in dependencies |

## 5. Package Publishing

| Command | Description |
|---------|-------------|
| `npm login` | Logs in to npm registry |
| `npm publish` | Publishes package to registry |
| `npm unpublish` | Removes published package |
| `npm version patch` | Updates version (patch/minor/major) |
| `npm pack` | Creates tarball without publishing |

## 6. Debugging & Configuration

| Command | Description |
|---------|-------------|
| `npm config list` | Shows current configuration |
| `npm doctor` | Checks npm environment health |
| `npm exec -- <cmd>` | Runs command with local binaries |
| `npm root -g` | Shows global install location |
| `npm explain <package>` | Explains why a package is installed |

## Example package.json Scripts

```json
{
  "scripts": {
    "prebuild": "rimraf dist/",
    "build": "webpack --config webpack.prod.js",
    "postbuild": "size-limit",
    "prestart": "npm run build",
    "start": "node dist/index.js",
    "pretest": "npm run lint",
    "test": "jest --coverage",
    "posttest": "codecov",
    "lint": "eslint src/",
    "prepare": "husky install"
  }
}