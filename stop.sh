#!/bin/bash

echo "Stopping and removing containers, networks, volumes..."
docker-compose down -v --remove-orphans

echo "Removing Docker image..."
docker rmi -f example-service:1.0.0-SNAPSHOT 2>/dev/null || true

echo "Everything stopped."
