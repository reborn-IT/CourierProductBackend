package RebornIT.CourierProduct.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String website;
    private String hotline;
    private String description;
    private String nearestBranch;
    @ManyToMany(cascade = CascadeType.ALL )
    @JoinTable(name = "provider_service", joinColumns = {@JoinColumn(name = "provider_id")}, inverseJoinColumns = {@JoinColumn(name = "service_id")})
    private List<CourierService> services;

    public ServiceProvider(String name, String address, String website, String hotline, String description, String nearestBranch, List<CourierService> services) {
        this.name = name;
        this.address = address;
        this.website = website;
        this.hotline = hotline;
        this.description = description;
        this.nearestBranch = nearestBranch;
        this.services = services;
    }
}
