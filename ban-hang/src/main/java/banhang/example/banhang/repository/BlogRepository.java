package banhang.example.banhang.repository;

import banhang.example.banhang.model.BlogModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogRepository extends JpaRepository<BlogModel, Long> {

    Optional<BlogModel> findBySlug(String slug);
}
