package uz.usmonov.pcmarketuz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.usmonov.pcmarketuz.entity.Order;

@RepositoryRestResource(path = "order",collectionResourceRel = "Order",excerptProjection = CustomOrder.class)
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
