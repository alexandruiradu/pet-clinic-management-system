package org.sda.pcms.repository;

import org.sda.pcms.model.Pet;

public class PetRepositoryImpl extends BaseRepositoryImpl<Pet> implements PetRepository{
    public PetRepositoryImpl() {
        super(Pet.class);
    }
}
