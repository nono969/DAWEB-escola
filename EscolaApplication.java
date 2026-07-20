package br.edu.ifpb.escola;

import br.edu.ifpb.escola.presentation.controller.MenuPrincipalController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscolaApplication implements CommandLineRunner {

    @Autowired
    private MenuPrincipalController menuController;

    public static void main(String[] args) {
        SpringApplication.run(EscolaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        menuController.iniciar();
    }
}
