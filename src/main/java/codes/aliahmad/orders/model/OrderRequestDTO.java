package codes.aliahmad.orders.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO
{
  private int orderId;
  private int userId;
  private List<Integer> productIds;
  private int orderDate;
  private int quantity;
  private double totalAmount;

}
