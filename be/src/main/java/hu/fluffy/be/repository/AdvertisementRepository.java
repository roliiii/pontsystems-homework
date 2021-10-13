package hu.fluffy.be.repository;

import hu.fluffy.be.entity.AdvertisementEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface AdvertisementRepository extends CassandraRepository<AdvertisementEntity, UUID> {

}
