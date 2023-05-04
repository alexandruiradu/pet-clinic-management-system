package org.sda.pcms.service;

import java.sql.Date;

public interface PetService {

    void create(String race, Date birthdate, boolean isVaccinated, String ownerName);
}
