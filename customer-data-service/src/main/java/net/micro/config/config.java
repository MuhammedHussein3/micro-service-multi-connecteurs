package net.micro.config;

import net.micro.entities.Customer;
import net.micro.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "")
public class config {
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditingImpl();
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().name("muhammed").email("muahmedHussein2312@gmial.com").build());
            customerRepository.save(Customer.builder().name("ali").email("aliMohsen2312@gmial.com").build());
            customerRepository.save(Customer.builder().name("youssef").email("yousseHussein8095@gmial.com").build());

        };
    }
}
