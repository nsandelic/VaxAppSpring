/*
package hr.sandelic.waxapp;

import ch.qos.logback.core.CoreConstants;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MockVaccineRepository  implements VaccineRepository{


    private final List<Vaccine> mocked_vaccines = new ArrayList<>( (Arrays.asList(
            new Vaccine(1, "AZD1222", "AstraZeneca", "Viral Vector", 2, 1200),
            new Vaccine(1, "BNT162b2", "Pfizer-BioTech", "RNA", 2, 1000)
        )
    ));





    @Override
    public List<Vaccine> findAll() {
        return mocked_vaccines;
    }

    @Override
    public Optional<Vaccine> findVaccineByManufacturersName(String manufacturersName) {
        return mocked_vaccines.stream().filter(it -> Objects.equals(it.getManufacturersName(), manufacturersName)).findAny();
    }

    @Override
    public Vaccine addNewVaccine(VaccineCommand command) {
         boolean bool = false;
        Vaccine newVaccine = (new Vaccine(command.getResearchName(), command.getManufacturersName(), command.getVaccineType(), command.getRequiredDosage(), command.getAvailableDosageCount()));
        Vaccine nullVaccine = null;

        for(int i = 0; i < mocked_vaccines.size(); i++ ){
            if( newVaccine.getResearchName().equals(mocked_vaccines.get(i).getResearchName() )) {
                bool = true;
                break;
            }
            else bool = false;
        }

        if( bool == false ){
            mocked_vaccines.add(newVaccine);
            return newVaccine;
        } else return nullVaccine;

    }

    @Override
    public int deleteaccineByResearchName(String researchName) {

        int deleted = 0;

        for(int i = 0; i < mocked_vaccines.size(); i++ ){
            if( researchName.equals(mocked_vaccines.get(i).getResearchName())){
                mocked_vaccines.remove(i);
                deleted = 1;
            }
        }
        return deleted;
    }


}


*/



