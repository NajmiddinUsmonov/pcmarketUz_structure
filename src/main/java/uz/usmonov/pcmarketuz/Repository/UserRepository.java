package uz.usmonov.pcmarketuz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.usmonov.pcmarketuz.entity.User;


@RepositoryRestResource(path = "user",collectionResourceRel = "User",excerptProjection = CustomUser.class)
public interface UserRepository extends JpaRepository<User,Integer> {

}
