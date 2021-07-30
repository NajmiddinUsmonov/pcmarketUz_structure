package uz.usmonov.pcmarketuz.Repository;

import org.springframework.data.rest.core.config.Projection;
import uz.usmonov.pcmarketuz.entity.Basket;
import uz.usmonov.pcmarketuz.entity.Order;
import uz.usmonov.pcmarketuz.entity.Status;
import uz.usmonov.pcmarketuz.entity.User;

import java.sql.Timestamp;

@Projection(types = Order.class)
public interface CustomOrder {

     Integer getId();


     Timestamp getDate();


     User getUser();


     Basket getBasket();


     Status getStatus();
}
