package org.sda.pcms;

import org.sda.pcms.controller.UserOption;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startHibernate();
        // dependencies
        Scanner scanner = new Scanner(System.in);


        UserOption userOption = UserOption.UNKNOWN;
        while (userOption != UserOption.EXIT) {
            UserOption.printAllOptions();
            System.out.println();
            System.out.println("Please select an option:");
            try {
                int selectedOption = Integer.parseInt(scanner.nextLine().trim());
                userOption = UserOption.findUserOption(selectedOption).orElse(UserOption.UNKNOWN);
            } catch (NumberFormatException e) {
                userOption = UserOption.UNKNOWN;
            }

            switch (userOption) {
                case CREATE_VETERINARIAN:
                    System.out.println("Not implemented");
                    break;
                case VIEW_VETERINARIAN_LIST:
                    System.out.println("Not implemented");
                    break;
                case UPDATE_VETERINARIAN:
                    System.out.println("Not implemented");
                    break;
                case DELETE_VETERINARIAN:
                    System.out.println("Not implemented");
                    break;
                case CREATE_PET:
                    System.out.println("Not implemented");
                    break;
                case VIEW_PET_LIST:
                    System.out.println("Not implemented");
                    break;
                case UPDATE_PET:
                    System.out.println("Not implemented");
                    break;
                case DELETE_PET:
                    System.out.println("Not implemented");
                    break;
                case CREATE_CONSULT:
                    System.out.println("Not implemented");
                    break;
                case VIEW_CONSULT_LIST:
                    System.out.println("Not implemented");
                    break;
                case UPDATE_CONSULT:
                    System.out.println("Not implemented");
                    break;
                case EXIT:
                    stopHibernate();
                    System.out.println("Good bye!!");
                    break;
                default:
                    System.out.println("Not implemented. Please contact administrator.");
            }
        }
    }

    private static void startHibernate(){
        for (int index = 0; index < 50; index++){
            System.out.println();
        }
    }

    private static void stopHibernate(){
        for (int index = 0; index < 50; index++){
            System.out.println();
        }
    }
}