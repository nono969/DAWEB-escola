package br.edu.ifpb.escola;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscolaApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EscolaApplication.class, args);
	}
@Override
	public void run (String... args) throws Exception {
		System.out.println("Oi, esse é meu primeiro projeto.");
	}
}
