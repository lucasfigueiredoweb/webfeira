SHELL := /bin/bash

DOCKER_IMAGE=webfeira
APP_VERSION = $(shell mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate \
            -Dexpression=project.version | sed -n -e '/^\[.*\]/ !{ /^[0-9]/ { p; q } }')

.ONESHELL:

all:
	@make clean
	@make install -DskipTests
	@make test
	@make deploy_dev

clean:
	@echo " -- Cleaning project with Maven -- "
	@mvn clean

build:
	@echo " -- Building project with Maven -- "
	@mvn install -DskipTests

test:
	@echo " -- Running tests -- "
	@mvn test

docker_build:
	@echo " -- Building docker image -- "
	@echo "APP_VERSION = $(APP_VERSION)"
	@docker build --build-arg APP_VERSION=$(APP_VERSION) -t ${DOCKER_IMAGE} -t ${DOCKER_IMAGE}:${APP_VERSION} -t ${DOCKER_IMAGE}:latest .

docker_compose_run:
	@echo " -- Running in docker compose -- "
	@echo "APP_VERSION = $(APP_VERSION)"
	@docker-compose up --build --force-recreate -d

docker_compose_clean:
	@echo " -- Removing all Components in docker compose -- "
	@@docker-compose down
