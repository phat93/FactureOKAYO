package fr.okayo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//NB: @SpringBootApplication est un equivalent 
//    de @Configuration + @EnableAutoConfiguration + @ComponentScan/current package
// en mode @ComponentScan/currentble fichier application.properties et automatiquement analysé et pris en compte

@SpringBootApplication
public class SpringBootApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
    	//demarrage automarique d'un équivalent tomcat embarqué dans l'application 
        SpringApplication.run(SpringBootApp.class, args);
        System.out.println("http://localhost:8080/FactureOKAYO");
    }

}