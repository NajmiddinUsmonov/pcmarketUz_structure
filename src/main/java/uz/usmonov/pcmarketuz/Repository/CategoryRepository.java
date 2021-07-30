package uz.usmonov.pcmarketuz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.usmonov.pcmarketuz.entity.Category;

@RepositoryRestResource(path = "category",collectionResourceRel = "Category",excerptProjection = CustomCategory.class)
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
