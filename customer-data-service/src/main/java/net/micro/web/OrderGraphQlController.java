package net.micro.web;

import lombok.RequiredArgsConstructor;
import net.micro.entities.Order;
import net.micro.repository.OrderRepo;
import net.micro.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderGraphQlController {

    private final OrderService orderService;
    @QueryMapping("")
    List<Order> ordersByCustomer(@Argument(name = "") Long id){
        return orderService.ordersByCustomer(id);
    }
}
