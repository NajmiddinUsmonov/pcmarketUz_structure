package uz.usmonov.pcmarketuz.Repository;

import org.springframework.data.rest.core.config.Projection;
import uz.usmonov.pcmarketuz.entity.Category;

import javax.persistence.ManyToOne;

@Projection(types = Category.class)
public interface CustomCategory {
      Integer getId();

      String getName();

      Category getParentCategory();
}
