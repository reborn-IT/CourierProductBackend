package RebornIT.CourierProduct.entity;

import RebornIT.CourierProduct.enums.SecurityRole;
import lombok.*;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private SecurityRole role;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    @Column(unique = true, nullable = false)
    private String email;
    private String postalAddress;
    //activate=1 Deactivate=0
//    @Column(unique = true, nullable = false)
    private String password;
    private Integer status;


//    @ManyToMany(cascade = CascadeType.ALL )
//    @JoinTable(name = "user_fav", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "service_provider_id")})
//    private List<ServiceProvider> serviceProviders;


    public User(SecurityRole role, String firstName, String lastName, String mobileNumber, String email, String postalAddress, String password, Integer status) {
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.postalAddress = postalAddress;
        this.password = password;
        this.status = status;
    }
}


