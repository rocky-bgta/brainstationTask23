# First following cmd to build jar file:
* mvn install

# To build Docker image give by below cmd (salehinrocky docker user name):
* docker build -t salehinrocky/brainstation-user-event:1.0.0 .
* 
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

