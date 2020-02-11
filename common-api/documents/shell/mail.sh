#!/bin/bash 
APP_NAME=common-api.jar

#use note
usage() { 
    echo "Usage: sh moco.sh [start|stop|restart|status|log]" 
    exit 1 
} 
#check the progress
is_exist(){ 
    pid=`ps -ef|grep $APP_NAME|grep -v grep|awk '{print $2}' ` 
	#if exist return 0,else return -1
    if [ -z "${pid}" ]; then 
        return 1 
    else 
        return 0 
    fi 
} 

#start
start(){ 
    is_exist 
    if [ $? -eq "0" ]; then 
        echo "${APP_NAME} is already running. pid=${pid} ." 
    else 
        nohup java -jar $APP_NAME > /dev/null 2>&1 &
		echo "${APP_NAME} is start success!......"
    fi
} 

#stop
stop(){ 
    is_exist 
    if [ $? -eq "0" ]; then 
        kill -9 $pid 
		echo "${APP_NAME} is stop success!......"
    else 
        echo "${APP_NAME} is not running" 
    fi 
} 

#status
status(){ 
    is_exist 
    if [ $? -eq "0" ]; then 
        echo "${APP_NAME} is running. Pid is ${pid}" 
    else 
        echo "${APP_NAME} is NOT running." 
    fi 
} 
#restart
restart(){ 
    stop 
    start 
}

#log
log(){
     # output the log
    tail -n 100 -f ../logs/common.log
}

#switch operation
case "$1" in 
    "start") 
        start 
        ;; 
    "stop") 
        stop 
        ;; 
    "status") 
        status 
        ;; 
    "restart") 
        restart 
        ;; 
	"log") 
        log 
        ;; 
    *) 
usage 
;; 
esac