package hr.sandelic.waxapp;

import java.util.List;
import java.util.Optional;

public interface VaccineService {

    List<VaccineDTO> findAll();

    VaccineDTO findVaccineByManufacturersName (String researchName);

    VaccineDTO addNewVaccine (VaccineCommand command);

    int deleteaccineByResearchName(String researchName);

}
