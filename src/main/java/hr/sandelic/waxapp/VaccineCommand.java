package hr.sandelic.waxapp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class VaccineCommand {




    @NotBlank(message = "Research name must not be empty")
    private String researchName;
    @NotBlank(message = "Manufacturer's name must not be empty")
    private String manufacturersName;
    @NotBlank(message = "Vaccine type  must not be empty")
    private String vaccineType;
    @NotNull(message = "Number of required shots must be entered")
    @PositiveOrZero(message = "Number of required shots cannot be negative")
    private Integer requiredDosage;
    @NotNull(message = "Number of available shots must be entered")
    @PositiveOrZero(message = "Number of available shots cannot be negative")
    private Integer availableDosageCount;


    public VaccineCommand(String researchName, String manufacturersName, String vaccineType, Integer requiredDosage, Integer availableDosageCount) {
        this.researchName = researchName;
        this.manufacturersName = manufacturersName;
        this.vaccineType = vaccineType;
        this.requiredDosage = requiredDosage;
        this.availableDosageCount = availableDosageCount;
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
