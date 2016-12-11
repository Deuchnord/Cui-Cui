package fr.tanghevandekadsye.jee;

import fr.tanghevandekadsye.jee.Interfaces.ContactInfo;
import fr.tanghevandekadsye.jee.Interfaces.Repository.MessageRepository;
import fr.tanghevandekadsye.jee.Interfaces.Repository.UserRepository;
import fr.tanghevandekadsye.jee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;

@SpringBootApplication
@ComponentScan({"fr.tanghevandekadsye.jee.Interfaces.Repository","fr.tanghevandekadsye.jee.controller.html","fr.tanghevandekadsye.jee.controller.rest"})
public class Application implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }

    @Override
    public void run(String... strings) throws Exception {


    }
}
