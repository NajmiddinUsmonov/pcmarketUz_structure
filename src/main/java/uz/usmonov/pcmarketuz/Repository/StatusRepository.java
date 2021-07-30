package uz.usmonov.pcmarketuz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.usmonov.pcmarketuz.entity.Status;


@RepositoryRestResource(path = "status",collectionResourceRel = "Status",excerptProjection = CustomStatus.class)
public interface StatusRepository extends JpaRepository<Status,Integer> {
}
