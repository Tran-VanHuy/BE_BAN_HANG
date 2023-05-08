package banhang.example.banhang.repository;

import banhang.example.banhang.model.BrandsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandsRepository extends JpaRepository<BrandsModel, Long> {
}
