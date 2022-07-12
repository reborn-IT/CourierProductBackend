package RebornIT.CourierProduct.dto;

import RebornIT.CourierProduct.entity.CourierService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProviderDto {
    private Long id;
    private String name;
    private String address;
    private String website;
    private String hotline;
    private String description;
    private String nearestBranch;
    private List<ServiceDto> serviceDto;
//    private List<CourierService> services;
//
//    public ServiceProviderDto(Long id, String name, String address, String website, String hotline, String description, String nearestBranch) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.website = website;
//        this.hotline = hotline;
//        this.description = description;
//        this.nearestBranch = nearestBranch;
//    }
}
