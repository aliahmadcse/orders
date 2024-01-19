package codes.aliahmad.orders.service;

import codes.aliahmad.orders.entity.Order;

public interface OrderService
{
  Order findOrderById(int orderId);
  Order createOrder(Order order);
  Order updateOrder(Order order);
  void deleteOrder(int orderId);
}
