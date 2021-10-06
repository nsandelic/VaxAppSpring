package hr.sandelic.waxapp;

import java.util.List;
import java.util.Optional;

public interface VaccineRepository {

    List<Vaccine> findAll();

    Optional<Vaccine> findVaccineByManufacturersName(String researchName);

    Vaccine addNewVaccine (VaccineCommand command);

    int deleteaccineByResearchName(String researchName);

}
