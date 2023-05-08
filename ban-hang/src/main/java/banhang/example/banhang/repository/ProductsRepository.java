package banhang.example.banhang.repository;

import banhang.example.banhang.model.ProductsModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<ProductsModel, Long> {

    Page<ProductsModel> findByCategoryProductsIdNameContaining (String category, Pageable pageable);

    Optional<ProductsModel> findOneBySlug (String slug);

//    List<ProductsModel> findByCategoryProductsId (Long id);
}
