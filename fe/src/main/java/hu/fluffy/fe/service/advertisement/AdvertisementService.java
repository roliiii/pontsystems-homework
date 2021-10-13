package hu.fluffy.fe.service.advertisement;

import hu.fluffy.fe.dao.AdvertisementDto;

public interface AdvertisementService {
    void createAddAdvertisementEvent(AdvertisementDto advertisementDto);
}
