package victor.policarpo.shoppingcart.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import victor.policarpo.shoppingcart.dto.request.CreateProduct;
import victor.policarpo.shoppingcart.dto.request.UpdateProduct;
import victor.policarpo.shoppingcart.dto.response.ProductResponse;
import victor.policarpo.shoppingcart.service.ProductService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProduct dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> listAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.listAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable  UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProduct(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable UUID id, @RequestBody UpdateProduct dto){
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProductById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id){
        productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
