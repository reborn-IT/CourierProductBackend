package RebornIT.CourierProduct.dto;

import RebornIT.CourierProduct.enums.SecurityRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {
    private SecurityRole role;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String postalAddress;
    private String password;

}
