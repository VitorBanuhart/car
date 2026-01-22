package estudo.car.domain.TravelRequest;

import estudo.car.domain.Passenger.Passenger;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class TravelRequest {
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    Passenger passenger;
    String origin;
    String destination;

    @Enumerated(EnumType.STRING)
    TravelRequestStatus status;
    LocalDateTime creationDate;
}
