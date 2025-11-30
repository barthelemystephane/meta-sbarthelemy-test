#!/bin/sh
/usr/bin/figlet -f banner -w 115  $(/sbin/ifconfig eth0 | grep 'inet ' | awk -F'[: ]+' '{ print $4 }')
