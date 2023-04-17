package org.sda.pcms.service;

import org.sda.pcms.model.Veterinarian;
import org.sda.pcms.repository.VeterinarianRepository;

import java.util.List;

public class VeterinarianServiceImpl implements VeterinarianService {
    private static final String ONLY_LETTERS_VALIDATION_REGEX = "^[a-zA-Z]+$";
    private static final String ADDRESS_VALIDATION_REGEX = "^[a-zA-Z0-9]+$";
    // dependencies
    private final VeterinarianRepository veterinarianRepository;

    public VeterinarianServiceImpl(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    @Override
    public void create(String firstName, String lastName, String address, String speciality) {
        if (firstName == null || firstName.isBlank() || firstName.isEmpty()) {
            throw new IllegalArgumentException(
                    "Provided first name is empty or blank. Please provide a valid value!"
            );
        }
        if (lastName == null || lastName.isBlank() || lastName.isEmpty()) {
            throw new IllegalArgumentException(
                    "Provided last name is empty or blank. Please provide a valid value!"
            );
        }
        if (!firstName.matches(ONLY_LETTERS_VALIDATION_REGEX)) {
            throw new IllegalArgumentException(
                    "Provided first name contains invalid characters. Please provide a valid value!"
            );
        }
        if (!lastName.matches(ONLY_LETTERS_VALIDATION_REGEX)) {
            throw new IllegalArgumentException(
                    "Provided last name contains invalid characters. Please provide a valid value!"
            );
        }
        if (address == null || address.isBlank() || address.isEmpty()) {
            throw new IllegalArgumentException(
                    "Provided address is empty or blank. Please provide a valid value!"
            );
        }
        if (!address.matches(ADDRESS_VALIDATION_REGEX)) {
            throw new IllegalArgumentException(
                    "Provided address contains invalid characters. Please provide a valid value!"
            );
        }
        if (speciality == null || speciality.isEmpty() || speciality.isBlank()) {
            throw new IllegalArgumentException(
                    "Provided speciality is empty or blank. Please provide a valid value!"
            );
        }
        if (!speciality.matches(ONLY_LETTERS_VALIDATION_REGEX)) {
            throw new IllegalArgumentException(
                    "Provided speciality contains invalid characters. Please provide a valid value!"
            );
        }

        Veterinarian veterinarian = new Veterinarian(firstName, lastName, address, speciality);
        veterinarianRepository.create(veterinarian);
    }

    @Override
    public void update(int id, String address, String speciality) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Veterinarian> findAll() {
        return null;
    }
}
