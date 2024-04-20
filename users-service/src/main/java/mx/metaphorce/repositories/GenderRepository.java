package mx.metaphorce.repositories;

import mx.metaphorce.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
    Gender findByName(String name);
}
