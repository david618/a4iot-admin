#!/usr/bin/env bash

echo "Start Create Tenant"

. ./support.sh

RG=$1

echo "Params: $*"

TenantFolder=tenants/${RG}
mkdir -p ${TenantFolder}

update_status "Installing" ${TenantFolder}

log_msg "Installing AKS" ${TenantFolder}
./install-aks-10.sh
if [ "$?" -ne 0 ];then
   update_status "Install Failed" ${TenantFolder}
	 exit 10
fi

log_msg "Installing Portworx" ${TenantFolder}
./install-portworx-15.sh
if [ "$?" -ne 0 ];then
   update_status "Install Failed" ${TenantFolder}
	 exit 15
fi

log_msg "Installing Datastore" ${TenantFolder}
./install-datastore-es-20.sh
if [ "$?" -ne 0 ];then
	 log_msg "Install Datastore Failed" ${TenantFolder}
   update_status "Install Failed" ${TenantFolder}
	 exit 20
fi

log_msg "Installing Gateway" ${TenantFolder}
./install-gateway-kafka-30.sh
if [ "$?" -ne 0 ];then
   update_status "Install Failed" ${TenantFolder}
	 exit 30
fi

log_msg "Installing Contour" ${TenantFolder}
./install-ingress-contour-40.sh
if [ "$?" -ne 0 ];then
   update_status "Install Failed" ${TenantFolder}
	 exit 40
fi

log_msg "Installing LetsEncrypt" ${TenantFolder}
./install-ingress-letsencrypt-60.sh
if [ "$?" -ne 0 ];then
   update_status "Install Failed" ${TenantFolder}
	 exit 60
fi

log_msg "Installing Spark Operator" ${TenantFolder}
./install-sparkoperator-65.sh
if [ "$?" -ne 0 ];then
   update_status "Install Failed" ${TenantFolder}
	 exit 65
fi

log_msg "Installing A4IOT" ${TenantFolder}
./install-a4iot-70.sh
if [ "$?" -ne 0 ];then
   update_status "Install Failed" ${TenantFolder}
   exit 70
fi

log_msg "End Create Tenant" ${TenantFolder}
update_status "Install Completed" ${TenantFolder}

