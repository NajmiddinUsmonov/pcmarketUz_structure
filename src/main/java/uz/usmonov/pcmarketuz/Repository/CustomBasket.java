package uz.usmonov.pcmarketuz.Repository;

import org.springframework.data.rest.core.config.Projection;
import uz.usmonov.pcmarketuz.entity.Basket;
import uz.usmonov.pcmarketuz.entity.Product;

import javax.persistence.OneToMany;
import java.util.Set;

@Projection(types = Basket.class)
public interface CustomBasket {

     Integer getId();


     Set<Product> getProduct();

     Integer howMany();
}
