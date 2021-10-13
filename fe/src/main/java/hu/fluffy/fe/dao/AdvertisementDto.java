package hu.fluffy.fe.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdvertisementDto {

    private String name;
    private String content;

}
