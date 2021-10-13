package hu.fluffy.be.grpc;

import com.google.protobuf.Empty;
import hu.fluffy.be.grpcserver.AdvertiesementsResponse;
import hu.fluffy.be.grpcserver.Advertisement;
import hu.fluffy.be.grpcserver.AdvertisementServiceGrpc;
import hu.fluffy.be.repository.AdvertisementRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class AdvertisementGRPCServiceImpl extends AdvertisementServiceGrpc.AdvertisementServiceImplBase {

    private final AdvertisementRepository advertisementRepository;

    @Override
    public void getAllAdvertisement(Empty request, StreamObserver<AdvertiesementsResponse> responseObserver) {

        AdvertiesementsResponse.Builder advertiesementsResponseBuilder = AdvertiesementsResponse.newBuilder();

        advertisementRepository.findAll().forEach(x -> {
            advertiesementsResponseBuilder
                .addAdvertisement(Advertisement.newBuilder().setContent(x.getContent()).setName(x.getName()).build());
        });

        responseObserver.onNext(advertiesementsResponseBuilder.build());
        responseObserver.onCompleted();
    }
}
