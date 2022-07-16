package RebornIT.CourierProduct.controller;

import RebornIT.CourierProduct.dto.*;
import RebornIT.CourierProduct.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api/v1/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/registration", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<Long>> registerUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        Long id = userService.save(userRegistrationDto);
        return ResponseEntity.ok(new CommonResponse<>(true, id));
    }

    @PostMapping(value = "/favourite/serviceProvider", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<String>> favourite(@RequestBody FavouriteDto favouriteDto) {
        userService.favourite(favouriteDto);
        return ResponseEntity.ok(new CommonResponse<>(true, "favourited"));
    }

    @PostMapping(value = "/login", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<Long>> login(@RequestBody LoginDto loginDto) {
       Long id = userService.login(loginDto);
        return ResponseEntity.ok(new CommonResponse<>(true, id));
    }

    @GetMapping(value = "/view/serviceProvider", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<ServiceProviderDto>>> viewServiceProviders() {
        List<ServiceProviderDto> serviceProviderDtoList = userService.getServiceProviderList();
        return ResponseEntity.ok(new CommonResponse<>(true, serviceProviderDtoList));
    }

    @GetMapping(value = "/view/services", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<ServiceDto>>> viewServices() {
        List<ServiceDto> serviceDtoList = userService.getServiceList();
        return ResponseEntity.ok(new CommonResponse<>(true, serviceDtoList));
    }

}
