package org.sda.pcms.repository;

import org.sda.pcms.model.Veterinarian;
import org.sda.pcms.repository.BaseRepositoryImpl;
import org.sda.pcms.repository.VeterinarianRepository;

public class VeterinarianRepositoryImpl extends BaseRepositoryImpl<Veterinarian> implements VeterinarianRepository {

    public VeterinarianRepositoryImpl() {
        super(Veterinarian.class);
    }
}
