package codes.aliahmad.orders.repository;

import codes.aliahmad.orders.entity.Order;
import codes.aliahmad.orders.model.ProductSummaryDTO;
import codes.aliahmad.orders.model.ReorderSummaryDTO;
import codes.aliahmad.orders.model.UserOrderSummaryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>
{
  @Query("SELECT new codes.aliahmad.orders.model.UserOrderSummaryDTO(u.userId, u.userName, COUNT(p)) " +
          "FROM Order o " +
          "JOIN o.user u " +
          "JOIN o.products p " +
          "GROUP BY u.userId, u.userName " +
          "ORDER BY COUNT(p) DESC LIMIT 3")
  List<UserOrderSummaryDTO> findTopUsersByOrderedProducts();

  @Query("SELECT new codes.aliahmad.orders.model.ProductSummaryDTO(p.productId, p.productName, COUNT(o)) " +
          "FROM Order o " +
          "JOIN o.products p " +
          "GROUP BY p.productId, p.productName " +
          "ORDER BY COUNT(o) DESC LIMIT 3")
  List<ProductSummaryDTO> findTopThreeMostOrderedProducts();

  @Query("SELECT NEW codes.aliahmad.orders.model.ReorderSummaryDTO(p.productId, p.productName, SUM(CASE WHEN ROW_NUMBER() OVER (PARTITION BY o.user, p.productId ORDER BY o.orderDate) > 1 THEN o.quantity ELSE 0 END)) " +
          "FROM Order o " +
          "JOIN o.products p " +
          "GROUP BY p.productId, p.productName " +
          "ORDER BY SUM(CASE WHEN ROW_NUMBER() OVER (PARTITION BY o.user, p.productId ORDER BY o.orderDate) > 1 THEN o.quantity ELSE 0 END) DESC LIMIT 3")
  List<ReorderSummaryDTO> findTopThreeReorderedProducts();
}
