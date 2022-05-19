package RebornIT.CourierProduct.repository;

import RebornIT.CourierProduct.entity.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider,Long> {

//    Optional<ServiceProvider> findById(Long serviceId);

    @Query(value = "select * from service_provider", nativeQuery = true)
    List<ServiceProvider> getAllServiceProvider();
}
