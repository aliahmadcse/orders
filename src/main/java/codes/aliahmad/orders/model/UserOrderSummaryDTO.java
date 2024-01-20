package codes.aliahmad.orders.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserOrderSummaryDTO
{
  private int userId;
  private String userName;
  private long totalOrderedProducts;
}
