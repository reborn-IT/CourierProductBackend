package RebornIT.CourierProduct.repository;

import RebornIT.CourierProduct.entity.CourierService;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourierServiceRepository extends JpaRepository<CourierService, Long> {
//    Optional<CourierService> findById(Long serviceId);
}
