package banhang.example.banhang.repository;

import banhang.example.banhang.model.AdvertisementModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<AdvertisementModel, Long> {
}
