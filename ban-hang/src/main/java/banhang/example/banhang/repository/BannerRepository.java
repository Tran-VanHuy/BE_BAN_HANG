package banhang.example.banhang.repository;

import banhang.example.banhang.model.BannerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface BannerRepository extends JpaRepository<BannerModel, Long> {
}
