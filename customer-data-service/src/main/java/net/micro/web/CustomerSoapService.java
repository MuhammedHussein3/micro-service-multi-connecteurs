package net.micro.web;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import net.micro.dto.CustomerRequest;
import net.micro.entities.Customer;
import net.micro.mapper.CustomerMapper;
import net.micro.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@WebService(name = "CustomerWs")
public class CustomerSoapService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    @WebMethod
    public List<Customer> findAll()
    {
        return customerRepository.findAll();
    }
    @WebMethod
    public Customer findCustomerById(@WebParam(name = "id") Long id)
    {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent())
        {
            return customer.get();
        }
        throw  new RuntimeException(String.format("Customer %S Not Found",id));
    }

    @WebMethod
    public Customer saveCustomer(@WebParam(name = "customer") CustomerRequest customer)
    {
        return customerRepository.save(customerMapper.from(customer));
    }

    @WebMethod
    public Customer updateCustomer(@WebParam(name = "id") Long id,@WebParam(name = "customer")CustomerRequest customerRequest)
    {
        Customer check = customerRepository.findById(id).orElse(null);
        if (check!=null)
        {
            Customer customer = new Customer();
            customer.setId(id);
            customer.setName(customerRequest.getName());
            customer.setEmail(customerRequest.getEmail());
            return customer;
        }
        throw  new RuntimeException(String.format("UnSuccessfully!!!Customer %S Not Found",id));

    }
}
