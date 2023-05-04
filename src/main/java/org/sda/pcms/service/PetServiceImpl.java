package org.sda.pcms.service;

import org.sda.pcms.model.Pet;
import org.sda.pcms.repository.PetRepository;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class PetServiceImpl implements PetService {
    private static final String DIGIT_VALIDATION_REGEX = "\\d+";
    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
    //dependencies
    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public void create(String race, Date birthdate, boolean isVaccinated, String ownerName) {
        if (race == null || race.isBlank() || race.isEmpty()) {
            throw new IllegalArgumentException(
                    "Provided race is empty or blank. Please provide a valid value!"
            );
        }
        if (race.matches(DIGIT_VALIDATION_REGEX)) {
            throw new IllegalArgumentException(
                    "Provided race contains invalid characters. Please provide a valid value!"
            );
        }
        if (!DATE_PATTERN.matcher(birthdate.toString()).matches()) {
            throw new IllegalArgumentException(
                    "Provided birthdate format is invalid. Please provide a valid value!"
            );
        }
        if (ownerName == null || ownerName.isEmpty() || ownerName.isBlank()) {
            throw new IllegalArgumentException(
                    "Provided owner name is empty or blank. Please provide a valid value!"
            );
        }
        if (ownerName.matches(DIGIT_VALIDATION_REGEX)) {
            throw new IllegalArgumentException(
                    "Provided owner name contains invalid characters. Please provide a valid value!"
            );
        }

        petRepository.create(new Pet(race, birthdate, isVaccinated, ownerName));
    }

}
