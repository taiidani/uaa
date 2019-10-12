.PHONY: build push deploy

build:
	docker-compose build

push: build
	docker-compose push php

deploy:
	nomad job plan -address="http://157.245.181.195:4646" nomad.hcl