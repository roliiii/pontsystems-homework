package hu.fluffy.be.consumer.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddAdvertisementEvent {

    private String name;
    private String content;

}
