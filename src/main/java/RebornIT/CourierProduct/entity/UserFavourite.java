package RebornIT.CourierProduct.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserFavourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //favourite=1, notFavorite=0
    private Integer favourite;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_provider_id")
    private ServiceProvider serviceProvider;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public UserFavourite(Integer favourite, ServiceProvider serviceProvider, User user) {
        this.favourite = favourite;
        this.serviceProvider = serviceProvider;
        this.user = user;
    }
}
