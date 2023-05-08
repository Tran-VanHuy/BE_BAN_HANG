package banhang.example.banhang.repository;

import banhang.example.banhang.model.ProductsSoldModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsSoldRepository extends JpaRepository<ProductsSoldModel, Long> {
}
