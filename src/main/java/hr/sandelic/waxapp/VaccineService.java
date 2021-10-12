package hr.sandelic.waxapp;

import java.util.List;
import java.util.Optional;

public interface VaccineService {

    List<VaccineDTO> findAll();

    VaccineDTO findVaccineByManufacturersName (String manufacturersName);

    VaccineDTO addNewVaccine (VaccineCommand command);

    void deleteVaccineByManufacturersName(String manufacturersName);

}
