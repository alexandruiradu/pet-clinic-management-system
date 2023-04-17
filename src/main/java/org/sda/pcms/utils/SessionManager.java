package org.sda.pcms.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sda.pcms.model.Consult;
import org.sda.pcms.model.Pet;
import org.sda.pcms.model.Veterinarian;

public class SessionManager extends AbstractSessionManager {
    private static final SessionManager INSTANCE = new SessionManager();

    private SessionManager() {
        // hide the default constructor
    }

    public static SessionFactory getSessionFactory() {
        return INSTANCE.getSessionFactory("pet_clinic_management_system?serverTimezone=UTC");
    }

    public static void shutDown() {
        INSTANCE.shutdownSessionManager();
    }

    @Override
    protected void setAnnotatedClasses(Configuration configuration) {
        // do not forget to add the model here
        configuration.addAnnotatedClass(Veterinarian.class);
        configuration.addAnnotatedClass(Pet.class);
        configuration.addAnnotatedClass(Consult.class);
    }
}