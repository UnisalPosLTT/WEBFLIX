# Docker

#### PostgreSQL 9.3
https://hub.docker.com/r/thiagoteberga/postgresql/


```sh
docker pull thiagoteberga/postgresql:latest
```

```sh
sudo docker build -t [your_user_on_docker_hub]/postgresql:[v1] [.]
```

```sh
sudo docker push image:version_tag
```

```sh
sudo docker run -d --name postgresql -p 55432:5432 thiagoteberga/postgresql:latest
```

```sh
sudo docker stats postgresql
```

```sh
sudo docker port postgresql
```

```sh
sudo apt install postgresql-client
```
Conectar ao docker postgresql (user: docker, password: docker)

```sh
psql -h localhost -p 55432 -d docker -U docker --password

docker=# select datname from pg_database;
docker=# create database docker;
```

Acessar a pasta onde contem o arquivo de backup do banco de dados "backup_postgresql" e rodar:

```sh
sudo pg_restore -h localhost -p 55432 -d docker -U docker backup_postgresql
```

#### Application - TOMCAT

```sh
docker pull thiagoteberga/tomcat:latest
```

To run tomcat detach
```sh
sudo docker run -d --name tomcat -p 10080:8080 thiagoteberga/tomcat:latest
```

To see the generated admin password
```sh
sudo docker logs tomcat
```

#### Run docker.yaml
```sh
sudo docker-compose --file docker.yaml up -d
```

```sh
sudo docker-compose --file docker.yaml ps
```

```sh
sudo docker-compose --file docker.yaml down
```
