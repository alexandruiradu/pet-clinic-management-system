package org.sda.pcms.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Integer petId;
    @Enumerated(EnumType.STRING)
    @Column(name = "race")
    private Race race;
    @Column(name = "birthdate")
    private Date birthdate;
    @Column(name = "is_vaccinated")
    private Boolean isVaccinated;
    @Column(name = "owner_name")
    private String ownerName;
    @OneToMany(mappedBy = "pet")
    private List<Consult> consults;

    public Pet() {
    }

    public Pet(Race race, Date birthdate, Boolean isVaccinated, String ownerName) {
        this.race = race;
        this.birthdate = birthdate;
        this.isVaccinated = isVaccinated;
        this.ownerName = ownerName;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Boolean getVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<Consult> getConsults() {
        return consults;
    }

    public void setConsults(List<Consult> consults) {
        this.consults = consults;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", race=" + race +
                ", birthdate=" + birthdate +
                ", isVaccinated=" + isVaccinated +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
