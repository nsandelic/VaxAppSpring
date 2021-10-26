package hr.sandelic.waxapp.sideEffects;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JPASideEffectService implements  SideEffectService{

    private final SideEffectRepository sideEffectRepository;


    public JPASideEffectService(SideEffectRepository sideEffectRepository) {
        this.sideEffectRepository = sideEffectRepository;
    }


    @Override
    public List<SideEffectDTO> findAll() {
        return sideEffectRepository.findAll().stream().map(this::mapSideEffectToDTO).collect(Collectors.toList());
    }

   @Override
    public List<SideEffectDTO> findSideEffectsByVaccine_ManufacturersName(String manufacturersName) {
        return sideEffectRepository.findSideEffectsByVaccine_ManufacturersName(manufacturersName).stream().map(this::mapSideEffectToDTO).collect(Collectors.toList());
    }


    private SideEffectDTO mapSideEffectToDTO (final SideEffect sideEffect){
        return new SideEffectDTO(sideEffect.getName(), sideEffect.getFrequency(), sideEffect.getVaccine().getId());
    }
}
