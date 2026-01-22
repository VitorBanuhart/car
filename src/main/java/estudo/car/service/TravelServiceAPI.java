package estudo.car.service;

import estudo.car.domain.TravelRequest.TravelRequest;
import estudo.car.domain.TravelRequest.TravelRequestRepository;
import estudo.car.domain.TravelRequest.TravelRequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TravelServiceAPI {

    @Autowired
    TravelRequestRepository travelRequestRepository;

    public TravelRequest saveTravelRequest(TravelRequest travelRequest) {
        travelRequest.setStatus(TravelRequestStatus.ACCEPTED);
        travelRequest.setCreationDate(LocalDateTime.now());
        return travelRequestRepository.save(travelRequest);
    }
}
