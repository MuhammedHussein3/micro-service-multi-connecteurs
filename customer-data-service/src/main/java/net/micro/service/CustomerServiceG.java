package net.micro.service;

import net.micro.entities.Customer;
import net.micro.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceG {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> allCustomers()
    {
        return customerRepository.findAll();
    }
    public Customer findById(Long id)
    {
        Optional<Customer> customer = customerRepository.findBy_id(id);

        if (customer.isPresent())
            return customer.get();

        throw  new RuntimeException(String.format("Customer with %s Not Found",id));

    }

     public Customer find_by_email(String s){
        return customerRepository.find_by_email(s);
    }

}
