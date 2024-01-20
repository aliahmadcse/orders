package codes.aliahmad.orders.resource;

import codes.aliahmad.orders.entity.User;
import codes.aliahmad.orders.model.UserOrderSummaryDTO;
import codes.aliahmad.orders.repository.OrderRepository;
import codes.aliahmad.orders.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserResource
{
  private final UserService userService;

  @GetMapping
  public ResponseEntity<User> getUser()
  {
    return new ResponseEntity<>(userService.findUserById(1), HttpStatus.OK);
  }

  @GetMapping("/top")
  public ResponseEntity<List<UserOrderSummaryDTO>> getTopUsersByOrderedProducts()
  {
    return new ResponseEntity<>(userService.findTopThreeUsersByOrderedProducts(), HttpStatus.OK);
  }
}
