package net.micro.web;

import lombok.AllArgsConstructor;
import net.micro.entities.Customer;
import net.micro.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest-api")
public class CustomerRestController {

   @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/customer")
    public Customer customerById(@RequestParam  Long id)
    {
        return customerRepository.findById(id).orElseThrow(null);
    }
    @GetMapping("/customers")

    public List<Customer> findAll()
    {
        return customerRepository.findAll();
    }
    @PostMapping("/insert")
    public Customer insert(@RequestBody Customer customer)
    {
        return customerRepository.save(customer);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id )
    {
        Customer customer = customerById(id);
        if (customer==null)
            return ResponseEntity.ok("delete unsuccessfully !! customer doesn't exist");
        customerRepository.delete(customer);
        return ResponseEntity.ok("delete successfully");
    }


 }
