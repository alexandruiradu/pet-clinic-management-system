package org.sda.pcms.controller;

import org.sda.pcms.repository.exception.EntityCreationFailedException;
import org.sda.pcms.service.PetService;

import java.sql.Date;
import java.util.Scanner;

public class PetController {
    //dependencies
    private final Scanner scanner;
    private final PetService petService;

    public PetController(Scanner scanner, PetService petService) {
        this.scanner = scanner;
        this.petService = petService;
    }

    public void create() {
        try {
            System.out.println("Please insert pet race:");
            String race = scanner.nextLine().trim();
            System.out.println("Please insert pet birthdate (YYYY-MM-DD):");
            Date birthdate = Date.valueOf(scanner.nextLine().trim());
            System.out.println("Please insert vaccine status (TRUE/FALSE):");
            boolean isVaccinated = Boolean.parseBoolean(scanner.nextLine().trim());
            System.out.println("Please insert owner name:");
            String ownerName = scanner.nextLine().trim();

            petService.create(race, birthdate, isVaccinated, ownerName);
            System.out.println("Pet created successfully!");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (EntityCreationFailedException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Internal server error. Please contact your administrator!");
        }
    }
}
