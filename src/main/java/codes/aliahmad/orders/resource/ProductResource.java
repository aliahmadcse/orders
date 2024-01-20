package codes.aliahmad.orders.resource;


import codes.aliahmad.orders.model.ProductSummaryDTO;
import codes.aliahmad.orders.model.ReorderSummaryDTO;
import codes.aliahmad.orders.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductResource
{

  private final ProductService productService;

  @GetMapping("/top")
  public ResponseEntity<List<ProductSummaryDTO>> getTop3MostOrderedProducts()
  {
    List<ProductSummaryDTO> topProducts = productService.getTopThreeOrderedProducts();
    return new ResponseEntity<>(topProducts, HttpStatus.OK);
  }

  @GetMapping("/top/reordered")
  public ResponseEntity<List<ReorderSummaryDTO>> getTop3MostReorderedProducts() {
    List<ReorderSummaryDTO> topReorderedProducts = productService.getTopThreeReorderedProducts();
    return new ResponseEntity<>(topReorderedProducts, HttpStatus.OK);
  }
}
