PROJECT_NAME=pandaFive

docker_build:
  	mvn package
	docker-compose -f docker-compose.yaml --project-name $(PROJECT_NAME) build
	
start:
	docker-compose -f docker-compose.yaml --project-name $(PROJECT_NAME) up -d

stop:
	docker-compose -f docker-compose.yaml --project-name $(PROJECT_NAME) stop
