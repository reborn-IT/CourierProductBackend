package RebornIT.CourierProduct.repository;

import RebornIT.CourierProduct.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from user where id=?", nativeQuery = true)
    Optional<User> findById(Long user_id);

    @Query(value = "select * from user where email=?", nativeQuery = true)
    Optional<User> findByEmail(String email);

}