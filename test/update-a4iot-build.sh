#!/usr/bin/env bash

RG=$1
. ./support.sh ${RG}

log_msg "Starting Update A4IOT Build" 

echo "Params: $*"

sleep 5 

log_msg "Completed Update A4IOT Build" 
update_status "Update Complete"
