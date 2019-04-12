# Apache2 Setup

## Operating System

Created a Ubuntu 18.04 VM.

## Setup Apache Web Server

[How To Install Apache Web Server](https://www.digitalocean.com/community/tutorials/how-to-install-the-apache-web-server-on-ubuntu-18-04)

### Vhost 

```
<VirtualHost a4iot-admin.westus2.cloudapp.azure.com:80>
    ServerAdmin admin@a4iot-admin.westus2.cloudapp.azure.com
    ServerName a4iot-admin.westus2.cloudapp.azure.com
    ServerAlias a4iot-admin.westus2.cloudapp.azure.com
    DocumentRoot /var/www/a4iot-admin.westus2.cloudapp.azure.com/html
    ErrorLog ${APACHE_LOG_DIR}/a4iot-admin.westus2.cloudapp.azure.com-error.log
    CustomLog ${APACHE_LOG_DIR}/a4iot-admin.westus2.cloudapp.azure.com-access.log combined
</VirtualHost>
```

Adding ```<hostname>:80``` on first line was needed; otherwise calls were hanlded by default config.

### Enabled SSL

Followed instructions to install SSL.

## Configured Certbot

[How to Secure Apache with Let's Encrypt](https://www.digitalocean.com/community/tutorials/how-to-secure-apache-with-let-s-encrypt-on-ubuntu-18-04)


### Enabled Authentication

[How to Setup Password Authentication](https://www.digitalocean.com/community/tutorials/how-to-set-up-password-authentication-with-apache-on-ubuntu-14-04)

### Setup Proxy

[Setup Reverse Proxy](https://www.digitalocean.com/community/tutorials/how-to-use-apache-as-a-reverse-proxy-with-mod_proxy-on-ubuntu-16-04)


Added configuration to the VirtualHost created by Certbox.

```
    ProxyPreserveHost On

    ProxyPass /v2 http://127.0.0.1:8080/v2
    ProxyPassReverse /v2 http://127.0.0.1:8080/v2

```



