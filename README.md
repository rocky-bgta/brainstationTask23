# spring-data-jpa
required cmd
docker exec -it kafka /bin/sh
ls
cd opt
ls
cd kafka_2.13-2.8.1
pwd
ls
cd bin
# To create topic =========
kafka-topics.sh --create --zookeeper zookeeper:2181 --topic user-event --partitions 3 --replication-factor 1


# To build Docker image give below cmd (salehinrocky docker user name):
* docker build -t salehinrocky/brainstation-user-event:1.0.0 .
# To run build image to give the following cmd:
* docker run -p 8080:9191 salehinrocky/spring-boot-caching-redis:1.0.0
# To give name of running container from an image give the following cmd: 
* docker run -p 8080:9191 --name spring-boot-caching-redis salehinrocky/brainstation-user-event:1.0.0
_Here salehinrocky/brainstation-user-event:1.0.0 is given image name_

# To test api that run inside docker container
* first try with http://localhost:8080/user

