package codes.aliahmad.orders.service.impl;


import codes.aliahmad.orders.entity.Product;
import codes.aliahmad.orders.repository.ProductRepository;
import codes.aliahmad.orders.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService
{
  private final ProductRepository productRepository;


  @Override
  public Product findProductById(int id)
  {
    return productRepository.findById(id).orElseThrow(() -> {
      log.error("Product with id {} not found ", id);
      return new RuntimeException("No product found with id: " + id);
    });
  }
}
