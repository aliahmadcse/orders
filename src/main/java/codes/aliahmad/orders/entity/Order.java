package codes.aliahmad.orders.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import java.util.Date;
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
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "OrderID")
  private int orderId;

  @ManyToOne
  @JoinColumn(name = "UserID")
  private User user;

  @ManyToMany
  @JoinTable(
          name = "OrderProduct",
          joinColumns = @JoinColumn(name = "OrderID"),
          inverseJoinColumns = @JoinColumn(name = "ProductID")
  )
  private List<Product> products;

  @Column(name = "OrderDate")
  private Date orderDate;

  @Column(name = "Quantity")
  private int quantity;

  @Column(name = "TotalAmount")
  private double totalAmount;
}