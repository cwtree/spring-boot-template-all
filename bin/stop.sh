#!/bin/bash

erebus_pids=`ps -ef | grep "erebus.jar" | grep -v grep | awk '{print $2}'`
for erebus_pid in $erebus_pids
do
    echo stop erebus java process: $erebus_pid
    kill -9 $erebus_pid
done

nr_erebus_pids=`ps -ef | grep "erebus.jar" | grep -v grep | wc -l`
while [ $nr_erebus_pids -gt 0 ]
do
    nr_erebus_pids=`ps -ef | grep "erebus.jar" | grep -v grep | wc -l`
done
echo now, erebus process is not run!
