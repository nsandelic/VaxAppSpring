package hr.sandelic.waxapp;

import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VaccineServiceImplementation  implements VaccineService{

    private final VaccineRepository vaccineRepository;

    public VaccineServiceImplementation(VaccineRepository vaccineRepository){
        this.vaccineRepository = vaccineRepository;
    }




    @Override
    public List<VaccineDTO> findAll() {
        return vaccineRepository.findAll().stream().map(this::mapVaccineToDTO).collect(Collectors.toList());
    }

    @Override
    public VaccineDTO findVaccineByManufacturersName(String researchName) {
        return vaccineRepository.findVaccineByManufacturersName(researchName).map(this::mapVaccineToDTO).orElse(null);
    }
    @Override
    public VaccineDTO  addNewVaccine(VaccineCommand command) {
        VaccineDTO nullDTO = null;

        Vaccine newVaccine = vaccineRepository.addNewVaccine(command);

        if(newVaccine == null)
            return nullDTO;
        else {
            VaccineDTO newVaccineDTO = mapVaccineToDTO(newVaccine);
            return newVaccineDTO;
        }

    }

    @Override
    public int deleteaccineByResearchName(String researchName) {
        int deleted = vaccineRepository.deleteaccineByResearchName(researchName);
        return deleted;
    }

    private VaccineDTO mapVaccineToDTO(final Vaccine vaccine){
        return new VaccineDTO(vaccine.getResearchName(),vaccine.getManufacturersName(), vaccine.getRequiredDosage());
    }


}
