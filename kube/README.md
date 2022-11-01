1. Set the default service account using default namespace to access the configmap
   1. kubectl apply -f kube/configmap-cluster-role.yaml
   2. kubectl auth can-i get configmap --as=system:serviceaccount:default:default -n default
2. Create the config map
   1. kubectl apply -f kube/colosseumSnacks-configmap.yaml 
3. Create the deployment
   1. kubectl apply -f kube/colosseumSnacks-deployment.yaml