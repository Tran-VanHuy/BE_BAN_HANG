package banhang.example.banhang.repository;

import banhang.example.banhang.model.CategoryProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProductsRepository extends JpaRepository<CategoryProductsModel, Long> {

}
