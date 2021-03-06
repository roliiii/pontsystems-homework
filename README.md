# pontsystems-homework

![](diagram.jpg)


# helm  

kubectl create namespace nrhf
  
helm repo add bitnami https://charts.bitnami.com/bitnami  
helm install cassandra --namespace nrhf --set dbUser.password=cassandra,cluster.datacenter=datacenter1 bitnami/cassandra

helm install kaffka --namespace nrhf bitnami/kafka



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

helm install kafka --namespace nrhf --set persistence.enabled=false,zookeeper.enabled=false,externalZookeeper.servers=zookeeper bitnami/kafka

helm install zookeeper --namespace nrhf --set persistence.enabled=false bitnami/zookeeper
