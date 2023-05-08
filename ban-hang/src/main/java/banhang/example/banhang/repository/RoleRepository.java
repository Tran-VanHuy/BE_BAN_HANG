package banhang.example.banhang.repository;

import banhang.example.banhang.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<RoleModel, Long> {
}
