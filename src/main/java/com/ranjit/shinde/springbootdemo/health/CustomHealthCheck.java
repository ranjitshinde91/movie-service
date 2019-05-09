package com.ranjit.shinde.springbootdemo.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        boolean running = true;
        if (running) {
            return Health.up().withDetail("status", "running Ok").build();
        } else {
            return  Health.down().build();
        }
    }
}
