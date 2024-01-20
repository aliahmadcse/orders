package codes.aliahmad.orders.repository;

import codes.aliahmad.orders.entity.Order;
import codes.aliahmad.orders.entity.User;
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
}
