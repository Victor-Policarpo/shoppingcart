package victor.policarpo.shoppingcart.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import victor.policarpo.shoppingcart.dto.request.CreateProduct;
import victor.policarpo.shoppingcart.dto.request.UpdateProduct;
import victor.policarpo.shoppingcart.dto.response.ProductResponse;
import victor.policarpo.shoppingcart.entity.Product;
import victor.policarpo.shoppingcart.exception.ResourceAlreadyExistsException;
import victor.policarpo.shoppingcart.exception.ResourceNotFoundException;
import victor.policarpo.shoppingcart.mapper.ProductMapper;
import victor.policarpo.shoppingcart.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional
    public ProductResponse createProduct(CreateProduct dto) {
        if (productRepository.existsByName(dto.name())){
            throw new ResourceAlreadyExistsException("The product with this name already exists.");
        }
        Product product = productRepository.save(productMapper.toEntity(dto));
        return productMapper.toProductResponse(product);
    }

    public List<ProductResponse> listAllProducts() {
        return productMapper.toListResponseDto(productRepository.findAll());
    }

    public Product findProductById(UUID id){
        return productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found or not exists")
        );
    }

    public ProductResponse findProduct(UUID id) {
        return productMapper.toProductResponse(findProductById(id));
    }

    @Transactional
    public ProductResponse updateProductById(UUID id, UpdateProduct dto) {
        Product product = findProductById(id);
        productMapper.updateProduct(product, dto);
        return productMapper.toProductResponse(product);
    }

    @Transactional
    public void deleteProductById(UUID id) {
        Product product = findProductById(id);
        productRepository.delete(product);
    }
}
