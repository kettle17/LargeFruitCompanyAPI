package org.example.largefruitcompanyapi;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class
})
public class LargeFruitCompanyApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(LargeFruitCompanyApiApplication.class, args);
    }

    @PostConstruct
    public void debugCredentials() {
        try {
            System.out.println("=== DEBUGGING GCP SETUP ===");

            // Check if key.json exists
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream keyStream = classLoader.getResourceAsStream("key.json");
            if (keyStream != null) {
                System.out.println("✅ key.json found in classpath");
                keyStream.close();
            } else {
                System.out.println("❌ key.json NOT found in classpath");
            }

        } catch (Exception e) {
            System.out.println("❌ Error checking credentials: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
