package codes.aliahmad.orders.service.impl;

import codes.aliahmad.orders.entity.Order;
import codes.aliahmad.orders.entity.Product;
import codes.aliahmad.orders.model.OrderRequestDTO;
import codes.aliahmad.orders.repository.OrderRepository;
import codes.aliahmad.orders.service.OrderService;
import codes.aliahmad.orders.service.ProductService;
import codes.aliahmad.orders.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService
{

  private final OrderRepository orderRepository;
  private final UserService userService;
  private final ProductService productService;

  @Override
  public Order findOrderById(int orderId)
  {
    return orderRepository.findById(orderId).orElseThrow(() -> {
      log.error("Order with id {} not found ", orderId);
      return new RuntimeException("No order found with id: " + orderId);
    });
  }

  @Override
  public Order createOrder(OrderRequestDTO orderRequest)
  {
    Order order = new Order();

    order.setUser(userService.findUserById(orderRequest.getUserId()));

    List<Product> products = new ArrayList<>();
    for (int productId : orderRequest.getProductIds())
    {
      products.add(productService.findProductById(productId));
    }

    order.setProducts(products);
    order.setOrderDate(orderRequest.getOrderDate());
    order.setQuantity(products.size());
    order.setTotalAmount(orderRequest.getTotalAmount());

    return orderRepository.save(order);
  }

  @Override
  public Order updateOrder(OrderRequestDTO orderRequest)
  {
    Order existingOrder = findOrderById(orderRequest.getOrderId());

    existingOrder.setOrderDate(orderRequest.getOrderDate());
    existingOrder.setQuantity(orderRequest.getQuantity());
    existingOrder.setTotalAmount(orderRequest.getTotalAmount());
    existingOrder.setUser(userService.findUserById(orderRequest.getUserId()));

    List<Product> products = new ArrayList<>();
    for (int productId : orderRequest.getProductIds())
    {
      products.add(productService.findProductById(productId));
    }

    existingOrder.setProducts(products);

    return orderRepository.save(existingOrder);
  }

  @Override
  public void deleteOrder(int orderId)
  {
    Order order = findOrderById(orderId);
    orderRepository.delete(order);
  }
}
