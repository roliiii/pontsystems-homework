# pontsystems-homework

# Kafka/cassandra indítása local-ban
cd env  
docker-compose up

# Cassandra hasznos parancsok
docker-compose exec cassandra bash  
cqlsh -u cassandra -p cassandra  


create keyspace advertisement WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};  

describe advertisement  

select * from advertisement.advertisemententity;
