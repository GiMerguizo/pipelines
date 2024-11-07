# Pipelines
Recursos úteis em pipelines usadas no Jenkins

## Subir Jenkins no Docker

- Abrir o Play with Docker:
https://labs.play-with-docker.com/

`docker run --name=jenkins -p 8080:8080 -p 50000:50000 jenkins/jenkins:lts`

- Copiar a senha: *************

Ver a senha: `docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword`

- Abrir a porta
- Colar a senha do administrador
- Instalar os Plugins
