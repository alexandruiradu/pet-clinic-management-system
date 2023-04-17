package org.sda.pcms.controller;

import org.sda.pcms.repository.exception.EntityCreationFailedException;
import org.sda.pcms.service.VeterinarianService;

import java.util.Scanner;

public class VeterinarianController {
    // dependencies
    private final Scanner scanner;
    private final VeterinarianService veterinarianService;

    public VeterinarianController(Scanner scanner, VeterinarianService veterinarianService) {
        this.scanner = scanner;
        this.veterinarianService = veterinarianService;
    }

    public void create() {
        try {
            System.out.println("Please insert first name:");
            String firstName = scanner.nextLine().trim();
            System.out.println("Please insert last name:");
            String lastName = scanner.nextLine().trim();
            System.out.println("Please insert address:");
            String address = scanner.nextLine().trim();
            System.out.println("Please insert speciality");
            String speciality = scanner.nextLine().trim();

            veterinarianService.create(firstName, lastName, address, speciality);
            System.out.println("Veterinarian created successfully!");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (EntityCreationFailedException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Internal server error. Please contact your administrator!");
        }
    }
}
