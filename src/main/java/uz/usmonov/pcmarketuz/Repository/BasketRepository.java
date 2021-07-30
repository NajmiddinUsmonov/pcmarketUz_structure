package uz.usmonov.pcmarketuz.Repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "basket",collectionResourceRel = "Basket",excerptProjection = CustomBasket.class)
public interface BasketRepository {
}
