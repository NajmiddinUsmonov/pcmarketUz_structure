package uz.usmonov.pcmarketuz.Repository;


import org.springframework.data.rest.core.config.Projection;
import uz.usmonov.pcmarketuz.entity.Status;

import java.sql.Timestamp;

@Projection(types = Status.class)
public interface CustomStatus {

     Integer getId();

     boolean getConfirmOrder();

     boolean getDelayedOrder();

     boolean getCalceledOrder();

     boolean getReceivedOrder();

     Timestamp getDate();


}
