package codes.aliahmad.orders.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product
{
  @Id
  @GeneratedValue
  @Column(name = "ProductID")
  private int productId;

  @Column(name = "ProductName")
  private String productName;

  @Column(name = "Price")
  private double price;

  @Column(name = "Description")
  private String name;

  @ManyToMany(mappedBy = "products")
  @JsonIgnoreProperties("products")
  private List<Order> orders;
}

