#!/usr/bin/env bash

TenantFolder=tenants/${1}
mkdir -p ${TenantFolder}

log_msg() {
	 MSG=$1
	 #TenantFolder=$2
   echo "$(date) : ${MSG}" >> ${TenantFolder}/log
}

update_status() {
	 MSG=$1
	 #TenantFolder=$2
   echo "${MSG}" > ${TenantFolder}/status
}

