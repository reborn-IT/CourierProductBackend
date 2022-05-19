package RebornIT.CourierProduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProviderAddingDto {

    private Long id;
    private String name;
    private String address;
    private String website;
    private String hotline;
    private String description;
    private String nearestBranch;
    private List<Long> serviceIdList;




}
