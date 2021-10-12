package hr.sandelic.waxapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("vaccine")
@CrossOrigin(origins = "http://localhost:4200")
public class VaccineController {

    private final VaccineService vaccineService;


    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping()
    public List<VaccineDTO> getAllVaccine(){
        return this.vaccineService.findAll();
    }

    @GetMapping( path = "/{manufacturersName}")
    public ResponseEntity<VaccineDTO> getVaccineByResearchName(@PathVariable("manufacturersName") final String manufacturersName){

            VaccineDTO vaccineDTO = vaccineService.findVaccineByManufacturersName(manufacturersName);
            if (vaccineDTO == null)
                return new ResponseEntity<VaccineDTO>(HttpStatus.NOT_FOUND);
            else return new ResponseEntity<VaccineDTO>(vaccineDTO, HttpStatus.OK);




    }
    @PostMapping
    public ResponseEntity<VaccineDTO> addNewVaccine(@Valid @RequestBody final VaccineCommand command){
            VaccineDTO newVaccineDTO = vaccineService.addNewVaccine(command);
            if (newVaccineDTO == null)
                return new ResponseEntity<VaccineDTO>(HttpStatus.CONFLICT);
            else return new ResponseEntity<VaccineDTO>( newVaccineDTO,  HttpStatus.CREATED );
    }

    @DeleteMapping( path = "/{manufacturersName}")
    public void deleteByReaserchName(@PathVariable("manufacturersName") String manufacturersName){
        vaccineService.deleteVaccineByManufacturersName(manufacturersName);
    }


}
