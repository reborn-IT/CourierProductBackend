package RebornIT.CourierProduct.service;

import RebornIT.CourierProduct.dto.*;

import java.util.List;

public interface UserService {

    void save(UserRegistrationDto registrationDto);
    void favourite(FavouriteDto favouriteDto);
    Long login(LoginDto loginDto);
    List<ServiceProviderDto> getServiceProviderList();
    List<ServiceDto> getServiceList();
}
