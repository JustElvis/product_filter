package slav.project.evatest.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import slav.project.evatest.model.Product;
import slav.project.evatest.repository.ProductRepository;
import slav.project.evatest.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
