package codes.aliahmad.orders.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Orders")
public class Order
{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_gen")
  @SequenceGenerator(name = "order_seq_gen", sequenceName = "order_seq", initialValue = 1001)
  @Column(name = "OrderID")
  private int orderId;

  @ManyToOne
  @JoinColumn(name = "UserID")
  @JsonIgnoreProperties("orders")
  private User user;

  @ManyToMany
  @JsonIgnoreProperties("orders")
  @JoinTable(
          name = "OrderProduct",
          joinColumns = @JoinColumn(name = "OrderID"),
          inverseJoinColumns = @JoinColumn(name = "ProductID")
  )
  private List<Product> products;

  @Column(name = "OrderDate")
  private int orderDate;

  @Column(name = "Quantity")
  private int quantity;

  @Column(name = "TotalAmount")
  private double totalAmount;
}
