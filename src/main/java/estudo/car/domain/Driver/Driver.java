package estudo.car.domain.Driver;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Driver {
    @GeneratedValue
    @Id
    Long id;
    String name;
    LocalDate birthDate;
}
