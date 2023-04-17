package org.sda.pcms.service;

import org.sda.pcms.model.Veterinarian;

import java.util.List;

public interface VeterinarianService {

    void create(String firstName, String lastName, String address, String speciality);

    void update(int id, String address, String speciality);

    void delete(int id);

    List<Veterinarian> findAll();
}
