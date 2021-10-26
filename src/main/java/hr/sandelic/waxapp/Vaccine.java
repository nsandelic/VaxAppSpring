package hr.sandelic.waxapp;


import hr.sandelic.waxapp.sideEffects.SideEffect;
import hr.sandelic.waxapp.sideEffects.SideEffectDTO;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vaccine")
public class Vaccine implements Serializable {

    @Serial
    private static final long serialVersionUID = 4102905907076867121L;

    @Id
    @GeneratedValue
    @Column( name = "vaccine_id")
    private Long id;
    @Column( name = "research_name")
    private String researchName;
    @Column( name = "manufacturers_name")
    private String manufacturersName;
    @Column( name = "vaccine_type")
    private String vaccineType;
    @Column( name = "required_dosage")
    private Integer requiredDosage;
    @Column( name = "available_dosage_count")
    private Integer availableDosageCount;
    @OneToMany(
            mappedBy = "vaccine",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER

    )
    private List<SideEffect> sideEffects = new ArrayList<>();


    public Vaccine(String researchName, String manufacturersName, String vaccineType, Integer requiredDosage, Integer availableDosageCount) {
       this.id = id;
        this.researchName = researchName;
        this.manufacturersName = manufacturersName;
        this.vaccineType = vaccineType;
        this.requiredDosage = requiredDosage;
        this.availableDosageCount = availableDosageCount;
    }

    public Vaccine() {
    }

   public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResearchName() {
        return researchName;
    }

    public void setResearchName(String researchName) {
        this.researchName = researchName;
    }

    public String getManufacturersName() {
        return manufacturersName;
    }

    public void setManufacturersName(String manufacturersName) {
        this.manufacturersName = manufacturersName;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public Integer getRequiredDosage() {
        return requiredDosage;
    }

    public void setRequiredDosage(Integer requiredDosage) {
        this.requiredDosage = requiredDosage;
    }

    public Integer getAvailableDosageCount() {
        return availableDosageCount;
    }

    public void setAvailableDosageCount(Integer availableDosageCount) {
        this.availableDosageCount = availableDosageCount;
    }
}
