package codes.aliahmad.orders.resource;


import codes.aliahmad.orders.entity.Order;
import codes.aliahmad.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
