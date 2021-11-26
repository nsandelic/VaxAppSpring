package hr.sandelic.waxapp.sideEffects;


import hr.sandelic.waxapp.VaccineDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("sideEffect")
@CrossOrigin(origins = "http://localhost:4200")
public class SideEffectController {

    private SideEffectService sideEffectService;


    public SideEffectController(SideEffectService sideEffectService) {
        this.sideEffectService = sideEffectService;
    }

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public List<SideEffectDTO> getAllSideEffects() {
        return sideEffectService.findAll();
    }


   @GetMapping( path = "/{manufacturersName}")
   @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<List<SideEffectDTO>> findSideEffectsByVaccine_ManufacturersName (@PathVariable("manufacturersName") final String manufacturersName ) {

        List<SideEffectDTO> list = sideEffectService.findSideEffectsByVaccine_ManufacturersName(manufacturersName);
        if(list.isEmpty())
            return new ResponseEntity<List<SideEffectDTO>>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<List<SideEffectDTO>>(list, HttpStatus.FOUND);
    }

}
