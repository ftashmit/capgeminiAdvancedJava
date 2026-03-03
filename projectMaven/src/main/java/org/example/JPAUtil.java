package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JPAUtil {

    private static EntityManagerFactory emf;

    static {

        try {

            Properties props = new Properties();

            InputStream input =
                    JPAUtil.class.getClassLoader().getResourceAsStream("db.properties");

            props.load(input);

            Map<String, Object> config = new HashMap<>();

            config.put("jakarta.persistence.jdbc.url", props.getProperty("db.url"));
            config.put("jakarta.persistence.jdbc.user", props.getProperty("db.user"));
            config.put("jakarta.persistence.jdbc.password", props.getProperty("db.password"));
            config.put("jakarta.persistence.jdbc.driver", props.getProperty("db.driver"));

            emf = Persistence.createEntityManagerFactory("taskPU", config);

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize JPA", e);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}