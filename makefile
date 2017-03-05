.PHONY: build push deploy

build:
	docker-compose build

push: build
	docker-compose push php

deploy:
	docker stack deploy --compose-file=docker-compose.prod.yml --with-registry-auth uaa