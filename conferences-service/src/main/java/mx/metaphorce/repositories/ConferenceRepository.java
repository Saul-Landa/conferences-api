package mx.metaphorce.repositories;

import mx.metaphorce.models.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    List<Conference> findAllByUserId(Long userId);
}
