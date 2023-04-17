package org.sda.pcms.repository;

import org.sda.pcms.model.Consult;

public class ConsultRepositoryImpl extends BaseRepositoryImpl<Consult> implements ConsultRepository {

    public ConsultRepositoryImpl() {
        super(Consult.class);
    }
}
