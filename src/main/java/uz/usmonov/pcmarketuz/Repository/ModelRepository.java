package uz.usmonov.pcmarketuz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.usmonov.pcmarketuz.entity.Model;


@RepositoryRestResource(path = "model",collectionResourceRel = "Model",excerptProjection = CustomModel.class)
public interface ModelRepository extends JpaRepository<Model,Integer> {
}
