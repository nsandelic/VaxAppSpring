package hr.sandelic.waxapp.sideEffects;

public class SideEffectDTO {

    private String name;
    private String frequency;
    private Long vaccineId;

    public SideEffectDTO(String name, String frequency, Long vaccineId) {
        this.name = name;
        this.frequency = frequency;
        this.vaccineId = vaccineId;
    }

    public SideEffectDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setfrequency(String frequency) {
        this.frequency = frequency;
    }

    public Long getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(Long vaccineId) {
        this.vaccineId = vaccineId;
    }

    @Override
    public String toString() {
        return "SideEffectDTO {" +
                "Side Effect Name= " + name +
                "Frequency = " + frequency +
                '}';
    }
}
