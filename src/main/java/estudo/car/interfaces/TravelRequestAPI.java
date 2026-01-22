package estudo.car.interfaces;

import estudo.car.domain.TravelRequest.TravelRequest;
import estudo.car.domain.TravelRequest.TravelRequestInput;
import estudo.car.domain.TravelRequest.TravelRequestMapper;
import estudo.car.domain.TravelRequest.TravelRequestOutput;
import estudo.car.service.TravelServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping(path = "/travelRequest", produces = MediaType.APPLICATION_JSON_VALUE)
public class TravelRequestAPI {

    @Autowired
    private TravelServiceAPI travelServiceAPI;

    @Autowired
    private TravelRequestMapper travelRequestMapper;

    @PostMapping
    public EntityModel<TravelRequestOutput> makeTravelRequest (@RequestBody TravelRequestInput travelRequest) {
        TravelRequest request = travelServiceAPI.saveTravelRequest(travelRequestMapper.map(travelRequest));
        TravelRequestOutput output = travelRequestMapper.map(request);
        return travelRequestMapper.buildOutputModel(request, output);
    }
}
