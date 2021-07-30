package uz.usmonov.pcmarketuz.Repository;


import org.springframework.data.rest.core.config.Projection;
import uz.usmonov.pcmarketuz.entity.ConfigInfo;

@Projection(types = ConfigInfo.class)
public interface CustomConfigInfo {

     Integer getId();

     String getName();

     boolean getMainCategory();
}
