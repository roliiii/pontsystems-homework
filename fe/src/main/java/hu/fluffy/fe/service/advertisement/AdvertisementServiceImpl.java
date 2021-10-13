package hu.fluffy.fe.service.advertisement;

import hu.fluffy.fe.dao.AdvertisementDto;
import hu.fluffy.fe.service.advertisement.event.AddAdvertisementEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void createAddAdvertisementEvent(AdvertisementDto advertisementDto) {
        AddAdvertisementEvent addAdvertisementEvent = AddAdvertisementEvent.builder().name(advertisementDto.getName()).content(advertisementDto.getContent()).build();
        kafkaTemplate.send("advertisement-add", addAdvertisementEvent);
    }

}
