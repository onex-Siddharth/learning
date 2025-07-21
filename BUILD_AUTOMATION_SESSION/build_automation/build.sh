#!/bin/bash
set -e

echo "🧹 Cleaning project..."
mvn clean

echo "📦 Installing dependencies..."
mvn install -DskipTests

echo "⚙️ Compiling code..."
mvn compile

echo "✅ Running tests..."
mvn test
