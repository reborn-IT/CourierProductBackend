package RebornIT.CourierProduct.repository;

import RebornIT.CourierProduct.entity.CourierService;
import RebornIT.CourierProduct.entity.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CourierServiceRepository extends JpaRepository<CourierService, Long> {
//    Optional<CourierService> findById(Long serviceId);
@Query(value = "select service_id from provider_service where provider_id=?", nativeQuery = true)
List<Long> getCourierServicesByProviderId(Long provider_id);

@Query(value = "select * from courier_service where id=?", nativeQuery = true)
CourierService getCourierServicesById(Long id);

}
