package hu.fluffy.fe.controller;

import com.google.protobuf.Empty;
import hu.fluffy.be.grpcserver.AdvertisementServiceGrpc;
import hu.fluffy.fe.dao.AdvertisementDto;
import hu.fluffy.fe.service.advertisement.AdvertisementService;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/advertisement")
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @GrpcClient("adservice")
    AdvertisementServiceGrpc.AdvertisementServiceBlockingStub advertisementServiceBlockingStub;

    @GetMapping
    public List<AdvertisementDto> getAdvertisements(){
        return advertisementServiceBlockingStub
                .getAllAdvertisement(Empty.newBuilder().build())
                .getAdvertisementList()
                    .stream()
                    .map(x-> AdvertisementDto.builder().content(x.getContent()).name(x.getName()).build())
                    .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Void> addAdvertisement(@RequestBody AdvertisementDto advertisementDto){
        advertisementService.createAddAdvertisementEvent(advertisementDto);
        return ResponseEntity.ok().build();
    }

}
