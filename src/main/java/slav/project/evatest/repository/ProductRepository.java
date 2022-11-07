package slav.project.evatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slav.project.evatest.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
