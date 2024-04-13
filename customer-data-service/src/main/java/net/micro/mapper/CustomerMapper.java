package net.micro.mapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.micro.dto.CustomerRequest;
import net.micro.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerMapper {
     private final ModelMapper modelMapper;
    public Customer from(CustomerRequest customerRequest) {
       return modelMapper.map(customerRequest,Customer.class);
    }
    public Customer from(Customer customer) {
        return modelMapper.map(customer,Customer.class);
    }
}
