package codes.aliahmad.orders.service;

import codes.aliahmad.orders.entity.Product;
import codes.aliahmad.orders.model.ProductSummaryDTO;
import codes.aliahmad.orders.model.ReorderSummaryDTO;

import java.util.List;

public interface ProductService
{
  Product findProductById(int id);

  List<ProductSummaryDTO> getTopThreeOrderedProducts();


  List<ReorderSummaryDTO> getTopThreeReorderedProducts();
}
