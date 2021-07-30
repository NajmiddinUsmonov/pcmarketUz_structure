package uz.usmonov.pcmarketuz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.usmonov.pcmarketuz.entity.Brand;


@RepositoryRestResource(path="brand",collectionResourceRel = "Brand",excerptProjection = CustomBrand.class)
public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
