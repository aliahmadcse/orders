package codes.aliahmad.orders.service.impl;


import codes.aliahmad.orders.entity.Product;
import codes.aliahmad.orders.model.ProductSummaryDTO;
import codes.aliahmad.orders.model.ReorderSummaryDTO;
import codes.aliahmad.orders.repository.OrderRepository;
import codes.aliahmad.orders.repository.ProductRepository;
import codes.aliahmad.orders.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService
{
  private final ProductRepository productRepository;
  private final OrderRepository orderRepository;


  @Override
  public Product findProductById(int id)
  {
    return productRepository.findById(id).orElseThrow(() -> {
      log.error("Product with id {} not found ", id);
      return new RuntimeException("No product found with id: " + id);
    });
  }

  @Override
  public List<ProductSummaryDTO> getTopThreeOrderedProducts()
  {
    return orderRepository.findTopThreeMostOrderedProducts();
  }

  @Override
  public List<ReorderSummaryDTO> getTopThreeReorderedProducts()
  {
    return orderRepository.findTopThreeReorderedProducts();
  }


}
