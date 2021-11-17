package com.actuator.retoactuatorclient;

import com.actuator.retoactuatorclient.entity.Coche;
import com.actuator.retoactuatorclient.service.Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetoactuatorclientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RetoactuatorclientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Service service = new Service();

        String open = "open";
        String halfOpen = "half-open";
        String close = "close";

       Coche coche = new Coche(open, "Renault", "Megane");

        for (int i = 0; i < 5; i++) {
            if (coche.getEstado().equals(open)) {
                coche.setEstado(open);
                service.setToHalfOpen();
                Thread.sleep(5000);

                if (i >= 3) {
                    coche.setEstado(close);
                    service.setToClose();
                    Thread.sleep(5000);
                } else {
                    coche.setEstado(halfOpen);
                    service.setToHalfOpen();
                    Thread.sleep(5000);
                }
            }
        }
    }

}
