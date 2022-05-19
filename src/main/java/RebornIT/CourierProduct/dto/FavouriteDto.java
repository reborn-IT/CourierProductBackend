package RebornIT.CourierProduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavouriteDto {
    private Long userId;
    private Long serviceProviderId;
    private Integer favourite;

}
