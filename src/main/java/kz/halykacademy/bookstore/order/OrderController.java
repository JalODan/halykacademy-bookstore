package kz.halykacademy.bookstore.order;

import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @GetMapping
    public Set<OrderDTO> getAll() {
        return orderService.getAll().stream().map(orderMapper::toDTO).collect(Collectors.toSet());
    }

    @PostMapping
    public void create(@RequestBody OrderCreationDTO dto) {

        Order order = orderMapper.toEntity(dto);
        order.getItems().forEach(item -> item.setOrder(order));
        orderService.create(order);
    }

    @GetMapping("/{id}")
    public OrderDTO getByID(@PathVariable Long id) {

        return orderMapper.toDTO(orderService.getByID(id));
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestBody StatusUpdateDTO dto) {

        Status status = Status.valueOf(dto.getStatusName());
        Order order = orderService.getByID(id);

        orderService.setStatus(order, status);
    }
}
