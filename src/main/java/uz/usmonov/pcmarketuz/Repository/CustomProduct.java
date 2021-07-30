package uz.usmonov.pcmarketuz.Repository;


import org.springframework.data.rest.core.config.Projection;
import uz.usmonov.pcmarketuz.entity.*;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Projection(types = Product.class)
public interface CustomProduct {

     Integer getId();

     String getType();

     String getPrice();


     Brand getBrand();


     Model getmodel();


     Set<ConfigInfo> getConfigInfo();


     Attachment getPhoto();
}
