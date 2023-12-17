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

# Now run the following cmd:
* docker compose up

# To test api that run inside docker container
* to get all user:
  curl --location 'http://localhost:8080/users'
# To create a user:
curl --location 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--data ' {

        "username": "Create Kafka Test",
        "phoneNo": "000114777",
        "nid": "nid_6aebb02de15f",
        "address": "address_407c0e658ad3"
}'

# To get user by id:
curl --location 'http://localhost:8080/users/4'

# To update user:
curl --location --request PUT 'http://localhost:8080/users/1' \
--header 'Content-Type: application/json' \
--data ' {

        "username": "566666",
        "phoneNo": "phoneNo_5c783ac70c92",
        "nid": "nid_6aebb02de15f",
        "address": "address_407c0e658ad3"
    }'

