package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ClassicalMusic implements Music {

    @PostConstruct
    public void doMyInit() {
        System.out.println("My init");
    }

    @PreDestroy
    public void doMyDestroy() {
        System.out.println("My destroy");
    }

    @Override
    public String getSong() {
        return "Vitja AKA";
    }
}
