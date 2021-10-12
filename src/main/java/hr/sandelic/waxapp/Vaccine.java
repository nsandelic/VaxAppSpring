package hr.sandelic.waxapp;

public class Vaccine {

    private Long id;
    private String researchName;
    private String manufacturersName;
    private String vaccineType;
    private Integer requiredDosage;
    private Integer availableDosageCount;


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
