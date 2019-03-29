#!/usr/bin/env bash

RG=$1
. ./support.sh ${RG}

update_status "Delete Started"
log_msg "Start Delete Tenant"

log_msg "Params: $*"

sleep 3 

log_msg "End Delete Tenant"
update_status "Delete Completed"
