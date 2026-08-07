package victor.policarpo.shoppingcart.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import victor.policarpo.shoppingcart.dto.request.CreateProduct;
import victor.policarpo.shoppingcart.dto.request.UpdateProduct;
import victor.policarpo.shoppingcart.dto.response.ProductResponse;
import victor.policarpo.shoppingcart.entity.Product;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    Product toEntity(CreateProduct createProduct);
    ProductResponse toProductResponse(Product entity);
    List<ProductResponse> toListResponseDto(List<Product> entity);
    void updateProduct(@MappingTarget Product entity, UpdateProduct dto);
}
