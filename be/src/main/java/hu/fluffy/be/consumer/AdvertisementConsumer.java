package hu.fluffy.be.consumer;

import hu.fluffy.be.consumer.event.AddAdvertisementEvent;
import hu.fluffy.be.entity.AdvertisementEntity;
import hu.fluffy.be.repository.AdvertisementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdvertisementConsumer {

    private final AdvertisementRepository advertisementRepository;

    @KafkaListener(topics = "advertisement-add", groupId = "cassandra-saver")
    public void consume(AddAdvertisementEvent event) {
        log.info(String.format("Message received: %s", event.toString()));

        AdvertisementEntity advertisementEntity = new AdvertisementEntity();
        advertisementEntity.setId(UUID.randomUUID());
        advertisementEntity.setContent(event.getContent());
        advertisementEntity.setName(event.getName());
        advertisementRepository.save(advertisementEntity);
    }

}
