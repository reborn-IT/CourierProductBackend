package RebornIT.CourierProduct.service.serviceImpl;

import RebornIT.CourierProduct.dto.*;
import RebornIT.CourierProduct.entity.CourierService;
import RebornIT.CourierProduct.entity.ServiceProvider;
import RebornIT.CourierProduct.entity.User;
import RebornIT.CourierProduct.entity.UserFavourite;
import RebornIT.CourierProduct.exception.CustomServiceException;
import RebornIT.CourierProduct.repository.CourierServiceRepository;
import RebornIT.CourierProduct.repository.ServiceProviderRepository;
import RebornIT.CourierProduct.repository.UserFavouriteRepository;
import RebornIT.CourierProduct.repository.UserRepository;
import RebornIT.CourierProduct.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ServiceProviderRepository serviceProviderRepository;
    private final UserFavouriteRepository userFavouriteRepository;
    private final CourierServiceRepository courierServiceRepository;

    @Override
    public void save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getRole(), registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getMobileNumber(), registrationDto.getEmail(),
                registrationDto.getPostalAddress(), registrationDto.getPassword(), 1);
        userRepository.save(user);
    }

    @Override
    public void favourite(FavouriteDto favouriteDto) {
        ServiceProvider serviceProvider = serviceProviderRepository.findById(favouriteDto.getServiceProviderId()).orElseThrow(() -> new CustomServiceException("Service provider not found!"));
        System.out.println(favouriteDto.getUserId());
        User user = userRepository.findById(favouriteDto.getUserId()).orElseThrow(() -> new CustomServiceException("User not found!"));
        UserFavourite userFavourite = new UserFavourite(favouriteDto.getFavourite(), serviceProvider, user);
        userFavouriteRepository.save(userFavourite);

    }

    @Override
    public Long login(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(() -> new CustomServiceException("User not found!"));
        ;
        return user.getId();
    }

    @Override
    public List<ServiceProviderDto> getServiceProviderList() {
        List<ServiceProvider> serviceProviderList = serviceProviderRepository.findAll();
        List<ServiceProviderDto> serviceProviderDtoList = new ArrayList<>();
        for (ServiceProvider serviceProvider : serviceProviderList) {
            serviceProviderDtoList.add(new ServiceProviderDto(serviceProvider.getId(), serviceProvider.getName(), serviceProvider.getAddress(),
                    serviceProvider.getWebsite(), serviceProvider.getHotline(), serviceProvider.getDescription(), serviceProvider.getNearestBranch(),
                    serviceProvider.getServices()));
        }
        return serviceProviderDtoList;
    }

    @Override
    public List<ServiceDto> getServiceList() {
        List<CourierService> courierServices = courierServiceRepository.findAll();
        List<ServiceDto> serviceDtoList = new ArrayList<>();
        for (CourierService courierService : courierServices) {
            serviceDtoList.add(new ServiceDto(courierService.getId(), courierService.getService()));
        }
        return serviceDtoList;
    }
}

