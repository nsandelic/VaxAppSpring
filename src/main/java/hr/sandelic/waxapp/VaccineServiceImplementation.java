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
    public VaccineDTO findVaccineByManufacturersName(String manufacturersName) {
        return vaccineRepository.findVaccineByManufacturersName(manufacturersName).map(this::mapVaccineToDTO).orElse(null);
    }
    @Override
    public VaccineDTO   addNewVaccine(VaccineCommand command) {


        VaccineDTO nullDTO = null;
        Vaccine commandToVaccine = mapCommandToVaccine(command);
        Vaccine newVaccine = vaccineRepository.addNewVaccine(commandToVaccine);

        if(newVaccine == null)
            return nullDTO;
        else {
            VaccineDTO newVaccineDTO = mapVaccineToDTO(newVaccine);
            return newVaccineDTO;
        }



    }

    @Override
    public void deleteVaccineByManufacturersName(String manufacturersName) {
        vaccineRepository.deleteVaccineByManufacturersName(manufacturersName);
    }

    private VaccineDTO mapVaccineToDTO(final Vaccine vaccine){
        return new VaccineDTO(vaccine.getId(), vaccine.getResearchName(),vaccine.getManufacturersName(), vaccine.getVaccineType(), vaccine.getRequiredDosage(), vaccine.getAvailableDosageCount());
    }

    private Vaccine mapCommandToVaccine(VaccineCommand command) {
        Vaccine vaccine = new Vaccine();
        vaccine.setResearchName(command.getResearchName());
        vaccine.setManufacturersName(command.getManufacturersName());
        vaccine.setVaccineType(command.getVaccineType());
        vaccine.setRequiredDosage(command.getRequiredDosage());
        vaccine.setAvailableDosageCount(command.getAvailableDosageCount());
        return vaccine;
    }



}
