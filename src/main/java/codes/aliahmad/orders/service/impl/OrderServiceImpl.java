package codes.aliahmad.orders.service.impl;

import codes.aliahmad.orders.entity.Order;
import codes.aliahmad.orders.repository.OrderRepository;
import codes.aliahmad.orders.resource.OrderResource;
import codes.aliahmad.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService
{

  private final OrderRepository orderRepository;

  @Override
  public Order findOrderById(int orderId)
  {
    return orderRepository.findById(orderId).orElseThrow(() -> {
      log.error("Order with id {} not found ", orderId);
      return new RuntimeException("No order found with id: " + orderId);
    });
  }

  @Override
  public Order createOrder(Order order)
  {
    return orderRepository.save(order);
  }

  @Override
  public Order updateOrder(Order order)
  {
    return null;
  }

  @Override
  public void deleteOrder(int orderId)
  {

  }
}
