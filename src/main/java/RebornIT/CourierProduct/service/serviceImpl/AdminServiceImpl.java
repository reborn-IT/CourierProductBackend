package RebornIT.CourierProduct.service.serviceImpl;

import RebornIT.CourierProduct.dto.ServiceProviderAddingDto;
import RebornIT.CourierProduct.entity.CourierService;
import RebornIT.CourierProduct.entity.ServiceProvider;
import RebornIT.CourierProduct.exception.CustomServiceException;
import RebornIT.CourierProduct.repository.ServiceProviderRepository;
import RebornIT.CourierProduct.repository.CourierServiceRepository;
import RebornIT.CourierProduct.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminServiceImpl implements AdminService {

    private final CourierServiceRepository courierServiceRepository;
    private final ServiceProviderRepository serviceProviderRepository;


    @Override
    public void addServiceProvider(ServiceProviderAddingDto serviceProviderAddingDto) {

        List<CourierService> serviceList = new ArrayList<>();
        for (Long serviceId : serviceProviderAddingDto.getServiceIdList()) {
            CourierService courierService = courierServiceRepository.findById(serviceId).orElseThrow(() -> new CustomServiceException("Courier service not found!"));
            serviceList.add(courierService);
        }
        if (serviceList.size() == 0) throw new CustomServiceException("Please add providing services");
        ServiceProvider serviceProvider = new ServiceProvider(serviceProviderAddingDto.getName(), serviceProviderAddingDto.getAddress(),
                serviceProviderAddingDto.getWebsite(), serviceProviderAddingDto.getHotline(), serviceProviderAddingDto.getDescription(),
                serviceProviderAddingDto.getNearestBranch(), serviceList);
        serviceProviderRepository.save(serviceProvider);


    }
}
