package banhang.example.banhang.repository;

import banhang.example.banhang.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    boolean existsByGmail(String gmail);

    Optional<UserModel> findOneByGmail(String gmail);
}
