package slav.project.evatest.dto.mapper;

import org.springframework.stereotype.Component;
import slav.project.evatest.dto.ProductResponseDto;
import slav.project.evatest.model.Product;

@Component
public class ProductMapper {
    public ProductResponseDto mapToDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        return dto;
    }
}
