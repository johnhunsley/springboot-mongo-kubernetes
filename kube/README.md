1. Set the default service account using default namespace to access the configmap
   1. kubectl apply -f kube/configmap-cluster-role.yaml
   2. kubectl auth can-i get configmap --as=system:serviceaccount:default:default -n default
2. Create the config map from application.properties
   1. kubectl create cm colosseumSnacks-configmap --from-file=application.properties
   2. kubectl apply -f kube/colosseumSnacks-configmap.yaml 
3. Create the deployment
   1. kubectl apply -f kube/colosseumSnacks-deployment.yaml