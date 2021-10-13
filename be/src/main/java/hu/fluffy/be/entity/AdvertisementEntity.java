package hu.fluffy.be.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class AdvertisementEntity {

    @PrimaryKey
    private UUID id;

    private String name;
    private String content;

}
