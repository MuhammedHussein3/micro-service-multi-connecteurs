package net.micro.service;

import net.micro.entities.Order;
import net.micro.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<Order> ordersByCustomer(Long id){
        return orderRepo.ordersByCustomer(id);
    }
}
