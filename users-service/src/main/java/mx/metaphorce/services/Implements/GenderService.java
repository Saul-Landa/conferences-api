package mx.metaphorce.services.Implements;

import mx.metaphorce.entity.Gender;
import mx.metaphorce.repositories.GenderRepository;
import mx.metaphorce.services.IGenderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenderService implements IGenderService {

    private final GenderRepository genderRepository;

    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Gender findByName(String name) {
        return genderRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Gender> findAll() {
        return genderRepository.findAll();
    }

    @Override
    @Transactional
    public Gender save(Gender gender) {
        return genderRepository.save(gender);
    }
}
