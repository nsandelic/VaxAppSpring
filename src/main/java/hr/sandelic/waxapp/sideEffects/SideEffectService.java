package hr.sandelic.waxapp.sideEffects;

import java.util.List;
import java.util.Optional;

public interface SideEffectService {

    List<SideEffectDTO> findAll();
    List<SideEffectDTO> findSideEffectsByVaccine_ManufacturersName(String manufacturersName);
}
