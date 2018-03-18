# Docker

#### PostgreSQL 9.3
https://hub.docker.com/r/jetherrodrigues/postgresql/

docker pull jetherrodrigues/postgresql:v1

```sh
sudo docker build -t [your_user_on_docker_hub]/postgresql:[v1] [.]
```

```sh
sudo docker push image:version_tag
```

```sh
sudo docker run -d --name postgresql -p 55432:5432 jetherrodrigues/postgresql:v1
```

```sh
sudo docker stats postgresql
```

```sh
sudo docker port postgresql
```
Connect to docker postgresql (user: docker, password: docker)
```sh
psql -h localhost -p 55432 -d docker -U docker --password

docker=# select datname from pg_database;
docker=# create database unisal;
```

#### JAVA 8
docker pull jetherrodrigues/my_java:v1

Compile the java file
```sh
sudo docker run --rm -v $PWD:/[app path] -w /[app path] jetherrodrigues/my_java:v1 javac Main.java
```
Execute the bytecode(.class) file
```sh
sudo docker run --rm -v  $PWD:/[app path] -w /[app path] jetherrodrigues/my_java:v1 java Main
```

#### Maven
docker pull jetherrodrigues/my_maven:v1

Create maven project
```sh
sudo docker run -it --rm -v "$PWD":/[app path] -w /[app path] jetherrodrigues/my_maven:v1 mvn archetype:generate -DgroupId=br.unisal.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -Dinte
```

Build maven project
```sh
sudo docker run -it --rm -v "$PWD":[app path] -w /[app path] jetherrodrigues/my_maven:v1 mvn package
```

#### Application
docker pull jetherrodrigues/my_tomcat:v2

To run tomcat detach
```sh
sudo docker run -d --name tomcat -p 10080:8080 jetherrodrigues/my_tomcat:v2
```

To see the generated admin password
```sh
sudo docker logs tomcat
```

#### Application 2
docker pull jetherrodrigues/my_app_tomcat:v1

```sh
sudo docker run --rm -d --name app -p 15200:8080 jetherrodrigues/my_app_tomcat:v1
```

`http://localhost:15200/example/old/123`

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

#### Links uteis
http://jenkins.jenkins.6c6d6e4a.svc.dockerapp.io:9090/login?from=%2F

https://github.com/carlossg/docker-maven

https://codefresh.io/docker-tutorial/java_docker_pipeline/

https://semaphoreci.com/community/tutorials/build-and-deploy-a-java-web-application-with-docker-and-semaphore
