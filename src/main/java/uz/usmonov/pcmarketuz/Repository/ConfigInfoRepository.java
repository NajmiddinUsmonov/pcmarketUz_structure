package uz.usmonov.pcmarketuz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.usmonov.pcmarketuz.entity.ConfigInfo;


@RepositoryRestResource(path = "configInfo",collectionResourceRel = "ConfigInfo",excerptProjection =CustomConfigInfo.class)
public interface ConfigInfoRepository extends JpaRepository<ConfigInfo,Integer> {

}
