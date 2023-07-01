SHELL := /bin/bash
GRADLE_VERSION ?= 8.2

b: buildw
buildw:
	gradle build -x test
coverage:
	mvn clean install jacoco:prepare-agent package jacoco:report
	mvn omni-coveragereporter:report
docker-stop-all:
	docker ps -a --format '{{.ID}}' | xargs -I {}  docker stop {}
	docker network prune
stop:
	docker ps -a -q --filter="name=red-portal" | xargs -I {} docker stop {}
	docker ps -a -q --filter="name=red-portal" | xargs -I {} docker rm {}
docker-clean: stop
	docker-compose down -v
	docker-compose rm -svf
dcd: docker-clean
	docker-compose -p ${GITHUB_RUN_ID} -f docker-compose.yml -f docker-compose.override.yml down
dcup-light: dcd
	docker-compose -p ${GITHUB_RUN_ID} up -d red-portal-db
