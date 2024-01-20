package codes.aliahmad.orders.service;

import codes.aliahmad.orders.entity.User;
import codes.aliahmad.orders.model.UserOrderSummaryDTO;

import java.util.List;


public interface UserService
{
  User findUserById(int id);

  List<UserOrderSummaryDTO> findTopThreeUsersByOrderedProducts();
}
