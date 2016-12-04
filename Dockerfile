FROM php:5.6-fpm-alpine

RUN apk add --no-cache bash nginx \
	&& mkdir -p /run/nginx \
    && ln -sf /dev/stdout /var/log/nginx/access.log \
    && ln -sf /dev/stderr /var/log/nginx/error.log

EXPOSE 80 443

# Install Composer globally
RUN php -r "copy('https://getcomposer.org/installer', 'composer-setup.php');" \
    && php -r "if (hash_file('SHA384', 'composer-setup.php') === 'aa96f26c2b67226a324c27919f1eb05f21c248b987e6195cad9690d5c1ff713d53020a02ac8c217dbf90a7eacc9d141d') { echo 'Installer verified'; } else { echo 'Installer corrupt'; unlink('composer-setup.php'); } echo PHP_EOL;" \
    && php composer-setup.php \
    && php -r "unlink('composer-setup.php');" \
    && mv composer.phar /usr/local/bin/composer \
    && composer -V
ENV COMPOSER_ALLOW_SUPERUSER 1

# And install the project packages
COPY src/composer.json src/composer.lock /tmp/
RUN cd /tmp && composer --ansi install -o

# Environment variables
ENV SENTRY_DSN=https://a115369e208847449cc6c05f4d332672:0ad536e676074277a1a9c2d6dfba6da6@sentry.io/119540

# Install the codebase
COPY build/nginx.conf /etc/nginx/nginx.conf
COPY src /var/www
RUN mv -f /tmp/vendor /var/www/vendor

WORKDIR /var/www
