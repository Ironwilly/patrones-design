package com.nttdata.patterdesin.patterns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.nttdata.patterdesin.patterns.decorator.PersonInterface;
import com.nttdata.patterdesin.patterns.singleton.PersonSingletonEnum;

@SpringBootApplication
@ComponentScan(value = "com.nttdata")
public class PatternsApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    private PersonInterface personPrototype;

    public PatternsApplication(PersonInterface personPrototype) {
        this.personPrototype = personPrototype;
    }

    public static void main(String[] args) {
        SpringApplication.run(PatternsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inicio...");

        System.out.println("=============================================================================");
        System.out.println("Prácticas con Singleton");
        System.out.println("=============================================================================");
        PersonSingletonEnum.INSTANCE.person().setName("Joselito");

        System.out.println(PersonSingletonEnum.INSTANCE.person().getName());

        System.out.println("Fin...");
    }
}
