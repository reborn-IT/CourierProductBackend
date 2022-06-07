package RebornIT.CourierProduct.controller;

import RebornIT.CourierProduct.dto.CommonResponse;
import RebornIT.CourierProduct.dto.ServiceProviderAddingDto;
import RebornIT.CourierProduct.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/api/v1/admin")
@CrossOrigin
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    // This end point is to get all service provider details
    @PostMapping(value = "/serviceProvider", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<String>> addServiceProvider(@RequestBody ServiceProviderAddingDto serviceProviderAddingDto) {
        adminService.addServiceProvider(serviceProviderAddingDto);
        return ResponseEntity.ok(new CommonResponse<>(true, "Service Provider is added successfully"));
    }

}
