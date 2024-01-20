package codes.aliahmad.orders.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReorderSummaryDTO
{
  private Long productId;
  private String productName;
  private Long totalReorderQuantity;
}
