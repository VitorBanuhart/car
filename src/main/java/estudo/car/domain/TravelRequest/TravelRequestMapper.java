package estudo.car.domain.TravelRequest;

import estudo.car.domain.Passenger.Passenger;
import estudo.car.domain.Passenger.PassengerRepository;
import estudo.car.interfaces.PassengerAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class TravelRequestMapper {
    @Autowired
    private PassengerRepository passengerRepository;

    public TravelRequest map(TravelRequestInput input) {
        Passenger passenger = passengerRepository.findById(input.passengerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        TravelRequest travelRequest = new TravelRequest();
        travelRequest.setPassenger(passenger);
        travelRequest.setOrigin(input.origin());
        travelRequest.setDestination(input.destination());
        return travelRequest;
    }

    public TravelRequestOutput map(TravelRequest travelRequest) {
        TravelRequestOutput travelRequestOutput = new TravelRequestOutput(
                travelRequest.getId(),
                travelRequest.getOrigin(),
                travelRequest.getDestination(),
                travelRequest.getStatus(),
                travelRequest.getCreationDate()
        );

        return travelRequestOutput;
    }

    public EntityModel<TravelRequestOutput> buildOutputModel(TravelRequest travelRequest, TravelRequestOutput output) {
        EntityModel<TravelRequestOutput> model = EntityModel.of(output);

        Link passengerLink = WebMvcLinkBuilder
                .linkTo(PassengerAPI.class)
                .slash(travelRequest.getPassenger().getId())
                .withRel("passenger")
                .withTitle(travelRequest.getPassenger().getName());
        model.add(passengerLink);
        return model;
    }
}
