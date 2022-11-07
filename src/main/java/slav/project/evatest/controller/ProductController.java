package slav.project.evatest.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import slav.project.evatest.dto.ProductResponseDto;
import slav.project.evatest.dto.mapper.ProductMapper;
import slav.project.evatest.service.ProductService;

@RestController
@RequestMapping("/shop/product")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService,
                             ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public List<ProductResponseDto> getAllByFilter(@RequestParam String nameFilter) {
        return productService.findAll()
                .stream()
                .parallel()
                .filter(product -> !product.getName().matches(nameFilter))
                .map(productMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
