package hr.sandelic.waxapp;

import java.util.List;
import java.util.Optional;

public interface VaccineRepository {

    List<Vaccine> findAll();

    Optional<Vaccine> findVaccineByManufacturersName(String manufacturersName);

    Vaccine addNewVaccine (Vaccine vaccine);

    void deleteVaccineByManufacturersName(String manufacturersName);

}
