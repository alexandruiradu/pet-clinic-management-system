package org.sda.pcms.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "consult")
public class Consult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consult_id")
    private Integer consultId;
    @Column(name = "date")
    private Date date;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private Veterinarian veterinarian;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Consult() {
    }

    public Consult(Date date, String description) {
        this.date = date;
        this.description = description;
    }

    public Integer getConsultId() {
        return consultId;
    }

    public void setConsultId(Integer consultId) {
        this.consultId = consultId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Consult{" +
                "consultId=" + consultId +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
