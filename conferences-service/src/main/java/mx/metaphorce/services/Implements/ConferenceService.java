package mx.metaphorce.services.Implements;

import mx.metaphorce.models.Conference;
import mx.metaphorce.repositories.ConferenceRepository;
import mx.metaphorce.services.IConferenceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConferenceService implements IConferenceService {

    private final ConferenceRepository conferenceRepository;

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Conference> findAll() {
        return conferenceRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Conference> findAllByUser(Long userId) {
        return conferenceRepository.findAllByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public Conference findById(Long id) {
        return conferenceRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Conference save(Conference conference) {
        return conferenceRepository.save(conference);
    }

    @Override
    public Conference update(Conference conference) throws Exception {
        Conference conferenceDB = conferenceRepository.findById(conference.getId()).orElse(null);

        if (conferenceDB == null) throw new Exception("Conference doesn't exists");

        conferenceDB.setDescription(conference.getDescription());
        conferenceDB.setTitle(conference.getTitle());
        conferenceDB.setStartDate(conference.getStartDate());
        conferenceDB.setEndDate(conference.getEndDate());

        return conferenceRepository.save(conferenceDB);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        conferenceRepository.deleteById(id);
    }
}
