package uz.usmonov.pcmarketuz.Repository;


import org.springframework.data.rest.core.config.Projection;
import uz.usmonov.pcmarketuz.entity.User;

@Projection(types = User.class)
public interface CustomUser {

     Integer getId();

     String getFullName();

     String getPhoneNumber();

     String getAddress();
}
