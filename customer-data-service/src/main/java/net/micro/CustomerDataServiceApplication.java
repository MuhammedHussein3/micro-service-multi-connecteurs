package net.micro;

import net.micro.entities.Customer;
import net.micro.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerDataServiceApplication {

 public static void main(String... args) {
        SpringApplication.run(CustomerDataServiceApplication.class,args);
    }

}
