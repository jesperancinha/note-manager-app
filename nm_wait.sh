#!/bin/bash

function checkServiceByNameAndMessage() {
    name=$1
    message=$2
    printf "%s." "$name"
    docker-compose logs "$name" &> "logs"
    string=$(cat logs)
    counter=0
    while [[ "$string" != *"$message"* ]]
    do
      printf "."
      docker-compose logs "$name" &> "logs"
      string=$(cat logs)
      sleep 1
      counter=$((counter+1))
      if [ $counter -eq 200 ]; then
          echo "Failed after $counter tries! Cypress tests mail fail!!"
          exit
      fi
    done
    counter=$((counter+1))
    echo "succeeded $name Service after $counter tries!"
}

checkServiceByNameAndMessage red-portal-db 'database system is ready to accept connections'
