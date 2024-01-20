package codes.aliahmad.orders.service;

import codes.aliahmad.orders.entity.Order;
import codes.aliahmad.orders.model.OrderRequestDTO;

public interface OrderService
{
  Order findOrderById(int orderId);
  Order createOrder(OrderRequestDTO orderRequest);
  Order updateOrder(OrderRequestDTO order);
  void deleteOrder(int orderId);


}
