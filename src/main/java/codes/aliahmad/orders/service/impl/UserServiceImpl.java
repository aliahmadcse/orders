package codes.aliahmad.orders.service.impl;


import codes.aliahmad.orders.entity.User;
import codes.aliahmad.orders.model.UserOrderSummaryDTO;
import codes.aliahmad.orders.repository.OrderRepository;
import codes.aliahmad.orders.repository.UserRepository;
import codes.aliahmad.orders.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService
{
  private final UserRepository userRepository;
  private final OrderRepository orderRepository;

  @Override
  public User findUserById(int id)
  {
    Optional<User> user = userRepository.findById(id);
    if (user.isEmpty())
    {
      log.error("User with id {} not found", id);
      throw new RuntimeException("User not found with id: " + 1);
    }
    return user.get();
  }

  @Override
  public List<UserOrderSummaryDTO> findTopThreeUsersByOrderedProducts()
  {
    return orderRepository.findTopUsersByOrderedProducts();
  }


}
