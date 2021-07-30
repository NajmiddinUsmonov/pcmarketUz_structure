package uz.usmonov.pcmarketuz.Repository;

import org.springframework.data.rest.core.config.Projection;
import uz.usmonov.pcmarketuz.entity.Brand;
import uz.usmonov.pcmarketuz.entity.Model;

import java.util.Set;

@Projection(types = Model.class)
public interface CustomModel {

     Integer getId();

     String getName();

     Set<Brand> getBrand();
}
