package kz.halykacademy.bookstore.order;

import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void create(Order order) {

        order.getItems().forEach(item -> item.setOrder(order));
        orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getByID(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    public void setStatus(Order order, Status status) {

        order.setStatus(status);
        orderRepository.save(order);
    }
}
