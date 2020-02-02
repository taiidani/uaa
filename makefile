.PHONY: build push deploy

build:
	docker build -t taiidani/uaa:latest .

push: build
	docker push taiidani/uaa:latest

deploy:
	nomad job plan -address="http://10.0.1.2:4646" nomad.hcl