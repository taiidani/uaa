#!/bin/sh

nginx

php-fpm7 --nodaemonize "$@"
