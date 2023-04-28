package org.sda.pcms.service;

import org.sda.pcms.model.Veterinarian;
import org.sda.pcms.repository.VeterinarianRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeterinarianServiceImpl implements VeterinarianService {
    private static final String ONLY_LETTERS_VALIDATION_REGEX = "^[a-zA-Z]+$";
    private static final String ADDRESS_VALIDATION_REGEX = "^[#.0-9a-zA-Z\\s,-]+$";
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
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Provided veterinarian id is 0 or negative. Please provide a valid value!"
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

        Optional<Veterinarian> optionalVeterinarian = veterinarianRepository.findById(id);
        if (optionalVeterinarian.isEmpty()) {
            throw new EntityNotFoundException(
                    "Provided veterinarian id does not exist in the system. Please provide a valid value!"
            );
        }

        Veterinarian veterinarian = optionalVeterinarian.get();
        veterinarian.setAddress(address);
        veterinarian.setSpeciality(speciality);
        veterinarianRepository.update(veterinarian);
    }

    @Override
    public void delete(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Provided veterinarian id is 0 or negative. Please provide a valid value!"
            );
        }

        Optional<Veterinarian> optionalVeterinarian = veterinarianRepository.findById(id);
        if (optionalVeterinarian.isEmpty()) {
            throw new EntityNotFoundException(
                    "Provided veterinarian id does not exist in the system. Please provide a valid value!"
            );
        }

        Veterinarian veterinarian = optionalVeterinarian.get();
        veterinarianRepository.delete(veterinarian);
    }

    @Override
    public List<Veterinarian> findAll() {
        return veterinarianRepository.findAll();
    }
}
