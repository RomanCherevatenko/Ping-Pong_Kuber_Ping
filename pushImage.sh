#!/bin/sh

docker build -t roman1844/ping:1.0.0 .
docker push roman1844/ping:1.0.0

docker run -p 8089:8089 roman1844/ping:1.0.0