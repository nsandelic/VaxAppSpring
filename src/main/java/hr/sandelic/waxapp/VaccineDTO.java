package hr.sandelic.waxapp;

public class VaccineDTO {

    private String researchName;
    private String manufacturersName;
    private Integer requiredDosage;

    public VaccineDTO(String researchName, String manufacturersName, Integer requiredDosage) {
        this.manufacturersName = manufacturersName;
        this.requiredDosage = requiredDosage;
        this.researchName = researchName;
    }

    public VaccineDTO() {
    }

    public String getManufacturersName() {
        return manufacturersName;
    }

    public void setManufacturersName(String manufacturersName) {
        this.manufacturersName = manufacturersName;
    }

    public Integer getRequiredDosage() {
        return requiredDosage;
    }

    public void setRequiredDosage(Integer requiredDosage) {
        this.requiredDosage = requiredDosage;
    }

    public String getResearchName() {
        return researchName;
    }

    public void setResearchName(String researchName) {
        this.researchName = researchName;
    }

    @Override
    public String toString() {
        return "VaccineDTO {" +
                "Research Name= " + researchName +
                "Manufacturers Name = " + manufacturersName +
                ", Required Dosage = " + requiredDosage +
                '}';
    }






}
