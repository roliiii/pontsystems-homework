# pontsystems-homework

![](diagram.jpg)


# helm  

kubectl create namespace nrfh
  
helm repo add bitnami https://charts.bitnami.com/bitnami  
helm install cassandra --namespace nrfh --set dbUser.password=cassandra,cluster.datacenter=datacenter1 bitnami/cassandra

helm install kaffka --namespace nrfh bitnami/kafka



# Kafka/cassandra local  
cd env/local  
docker-compose up

# Cassandra useful commands  
docker-compose exec cassandra bash  
cqlsh -u cassandra -p cassandra  


create keyspace advertisement WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};  

describe advertisement  

select * from advertisement.advertisemententity;

# kubectl for company's rancher 

copy config from rancher to
nano ~/.kube/config

than use kubectl as before

kubectl apply -f [filename] --namespace nrfh