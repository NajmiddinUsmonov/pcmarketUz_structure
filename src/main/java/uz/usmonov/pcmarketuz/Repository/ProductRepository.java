package uz.usmonov.pcmarketuz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.usmonov.pcmarketuz.entity.Product;


@RepositoryRestResource(path = "product",collectionResourceRel = "Product",excerptProjection = CustomProduct.class)
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
