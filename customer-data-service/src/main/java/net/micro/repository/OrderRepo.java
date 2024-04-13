package net.micro.repository;
import net.micro.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {

    @Query(value = """
select * from Order where Order.customer.id = :id
""",nativeQuery = true)
    List<Order> ordersByCustomer(Long id);
}
