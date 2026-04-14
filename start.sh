#!/bin/bash
set -e

echo "Installing messaging-api..."
cd messaging-api && mvn install -DskipTests && cd ..

echo "Building example-service jar..."
cd example-service && mvn package -DskipTests && cd ..

echo "Building example-service Docker image..."
docker build -t example-service:1.0.0-SNAPSHOT example-service/

echo "Starting services..."
docker-compose up -d

echo ""
echo "Services started:"
echo "  Eureka Registry : http://localhost:8761"
echo "  Example Service : http://localhost:8080"
echo ""
echo "Streaming example-service logs (Ctrl+C to stop)..."
docker-compose logs -f example-service
