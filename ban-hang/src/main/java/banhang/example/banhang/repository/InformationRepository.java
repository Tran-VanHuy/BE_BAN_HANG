package banhang.example.banhang.repository;

import banhang.example.banhang.model.InformationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<InformationModel, Long> {
}
