#!/usr/bin/env bash
set -ex

kubectl apply -f deployment/pages-namespace.yaml
kubectl apply -f deployment/pages-config.yaml
kubectl apply -f deployment/pages-service.yaml
kubectl apply -f deployment/pages-deployment.yaml

kubectl apply -f deployment/mysql-secret.yaml
kubectl apply -f deployment/mysql-service.yaml
kubectl apply -f deployment/mysql-deployment.yaml
kubectl apply -f deployment/flyway-configmap.yaml
kubectl apply -f deployment/flyway-job.yaml

kubectl apply -f deployment/mysql-pv.yaml
kubectl apply -f deployment/mysql-pvc.yaml