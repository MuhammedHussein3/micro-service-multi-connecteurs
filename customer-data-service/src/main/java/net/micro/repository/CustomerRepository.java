package net.micro.repository;

import com.fasterxml.jackson.annotation.OptBoolean;
import net.micro.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {


    @Query("""
 select c from Customer c where c.id = :id
""")
   Optional<Customer> findBy_id(Long id);

    @Query("""
select c from Customer c where c.email = :email
""")
    Customer find_by_email(String s);



}
