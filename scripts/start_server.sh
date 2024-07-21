#!/bin/bash
java -jar -Dspring.profiles.active=dev /home/ubuntu/ecf-0.0.1-SNAPSHOT.jar > /dev/null 2> /dev/null < /dev/null &