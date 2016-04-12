#! /bin/bash

CONTAINER=`docker create php:5.6.20-apache`

docker cp . $CONTAINER:/var/www || exit 1
docker commit $CONTAINER taiidani/php:uaa || exit 1
docker rm -fv $CONTAINER || exit 1

docker push taiidani/php:uaa