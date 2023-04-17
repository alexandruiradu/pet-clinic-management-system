package org.sda.pcms.controller;

import java.util.Optional;

public enum UserOption {
    CREATE_VETERINARIAN(1, "Add Veterinarian"),
    VIEW_VETERINARIAN_LIST(2, "Show All Veterinarians"),
    UPDATE_VETERINARIAN(3, "Update Veterinarian"),
    DELETE_VETERINARIAN(4, "Delete Veterinarian"),
    CREATE_PET(5, "Add Pet"),
    VIEW_PET_LIST(6, "Show All Pets"),
    UPDATE_PET(7, "Update Pet"),
    DELETE_PET(8, "Delete Pet"),
    CREATE_CONSULT(9, "Add Consult"),
    VIEW_CONSULT_LIST(10, "Show All Consults"),
    UPDATE_CONSULT(11, "Update Consult"),
    EXIT(99, "EXIT"),
    UNKNOWN(9999, "UNKNOWN");

    private final int option;
    private final String displayName;

    UserOption(int option, String displayName) {
        this.option = option;
        this.displayName = displayName;
    }

    public static void printAllOptions() {
        System.out.println("--------------------");
        for (UserOption userOption : values()) {
            if (userOption != UNKNOWN) {
                System.out.println(userOption.option + " -> " + userOption.displayName);
            }
        }
    }

    public static Optional<UserOption> findUserOption(int optionInput) {
        for (UserOption userOption : values()) {
            if (userOption.option == optionInput) {
                return Optional.of(userOption);
            }
        }
        return Optional.empty();
    }
}
