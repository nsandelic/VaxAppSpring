package hr.sandelic.waxapp.sideEffects;

import hr.sandelic.waxapp.Vaccine;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "side_effect")
public class SideEffect implements  Serializable{

    @Serial
    private static final long serialVersionUID = -2104426544612711980L;


    @Id
    @GeneratedValue
    @Column(name = "side_effect_id")
    private Long id;
    @Column(name = "side_effect_name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "frequency")
    private String frequency;
    @ManyToOne
    @JoinColumn(name = "vaccine_id")
    private Vaccine vaccine;

    public SideEffect() {
    }

    public SideEffect(String name, String description, String frequency, Vaccine vaccine) {
        this.name = name;
        this.description = description;
        this.frequency = frequency;
        this.vaccine = vaccine;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Vaccine getVaccine() {return vaccine;}

    public void setVaccine(Vaccine vaccine) {this.vaccine = vaccine;}
}
