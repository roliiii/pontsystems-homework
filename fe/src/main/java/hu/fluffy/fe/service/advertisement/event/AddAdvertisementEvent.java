package hu.fluffy.fe.service.advertisement.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddAdvertisementEvent {

    private String name;
    private String content;

}
