package hr.sandelic.waxapp.sideEffects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SideEffectRepository extends JpaRepository<SideEffect, Long> {

    List<SideEffect> findAll();
    List<SideEffect> findSideEffectsByVaccine_ManufacturersName(String manufacturersName);



}
