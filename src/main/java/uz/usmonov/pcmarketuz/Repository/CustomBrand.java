package uz.usmonov.pcmarketuz.Repository;


import org.springframework.data.rest.core.config.Projection;
import uz.usmonov.pcmarketuz.entity.Brand;
import uz.usmonov.pcmarketuz.entity.Category;

import javax.persistence.ManyToOne;

@Projection(types = Brand.class)
public interface CustomBrand {

     Integer getId();

     String getName();

     Category getCategory();
}
