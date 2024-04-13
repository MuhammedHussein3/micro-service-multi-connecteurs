package net.micro.web;

import lombok.RequiredArgsConstructor;
import net.micro.dto.CustomerRequest;
import net.micro.entities.Customer;
import net.micro.mapper.CustomerMapper;
import net.micro.repository.CustomerRepository;
import net.micro.service.CustomerServiceG;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Controller
@RequestMapping("/gr")
@RequiredArgsConstructor
public class CustomerGraphQlController {

    private final CustomerRepository customerRepository;
    private final CustomerServiceG customerServiceG;
    private final CustomerMapper customerMapper;
     @QueryMapping
     public List<Customer> allCustomers(){
         return customerServiceG.allCustomers();
     }
    @QueryMapping("/cu-id")
    public Customer customerById(Long id)
    {
        return customerServiceG.findById(id);
    }
    @QueryMapping("/email")
    public Customer find_by_email(@Argument(name = "email") String s){
        return customerServiceG.find_by_email(s);
    }

     @MutationMapping
     public Customer updateCustomer(@Argument Long id,@Argument(name = "customer") CustomerRequest c)
     {
         Optional<Customer> customerUpdate = customerRepository.findById(id);

         if (customerUpdate.isPresent())
         {
             Customer customer = new Customer();
             customer.setId(id);
             customer.setName(c.getName());
             customer.setEmail(c.getEmail());
             return customerRepository.save(customerMapper.from(customer));
         }
         throw  new RuntimeException(String.format("Customer with %s Not Found",customerUpdate));

     }
     @MutationMapping
     public ResponseEntity<String> deleteCustomer(@Argument Long id)
     {
         Optional<Customer> customer = customerRepository.findById(id);
         AtomicReference<String> ans = new AtomicReference<>("");

         customer.ifPresent(c->{
             customerRepository.delete(c);
             ans.set("Delete Successfully"+"\n"+
                     "Customer { hasId: "+id+"\n"+
                     " hasName: "+c.getName()+"\n"+
                     "hasEmail "+c.getEmail()
                     );
         });
         if (!ans.get().isEmpty())
         {
             return ResponseEntity.ok(ans.get());
         }
        throw new RuntimeException(String.format("Delete %s Not Found",id));
     }

      @MutationMapping
     public Customer saveCustomer(@Argument(name = "c") CustomerRequest customerRequest)
     {
         return customerRepository.save(customerMapper.from(customerRequest));
     }
}


