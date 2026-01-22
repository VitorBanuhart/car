package estudo.car.domain.TravelRequest;

import java.time.LocalDateTime;

public record TravelRequestOutput(
        Long id,
        String origin,
        String destination,
        TravelRequestStatus status,
        LocalDateTime creationDate) {

}
