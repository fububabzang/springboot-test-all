#!/usr/bin/env bash
app_name='springboot-test-all'
docker stop ${app_name}
echo '----stop container----'
docker rm ${app_name}
echo '----rm container----'
docker run -p 8096:8096 --name ${app_name} \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/${app_name}/logs:/var/logs \
-d mall-tiny/${app_name}:1.0-SNAPSHOT
echo '----start container----'
docker rmi `docker images | grep  "<none>" | awk '{print $3}'`
echo 'delete all <none> image'