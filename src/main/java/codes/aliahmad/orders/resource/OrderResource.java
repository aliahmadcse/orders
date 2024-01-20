package codes.aliahmad.orders.resource;


import codes.aliahmad.orders.entity.Order;
import codes.aliahmad.orders.model.OrderRequestDTO;
import codes.aliahmad.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderResource
{
  private final OrderService orderService;

  @GetMapping("/{orderId}")
  public ResponseEntity<Order> getOrder(@PathVariable int orderId)
  {
    return new ResponseEntity<>(orderService.findOrderById(orderId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDTO orderRequest) {
    Order createdOrder = orderService.createOrder(orderRequest);
    return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Order> updateOrder(@RequestBody OrderRequestDTO orderRequest) {
    Order updatedOrder = orderService.updateOrder(orderRequest);
    return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
  }

  @DeleteMapping("/{orderId}")
  public ResponseEntity<Void> deleteOrder(@PathVariable int orderId) {
    orderService.deleteOrder(orderId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
