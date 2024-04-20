package mx.metaphorce.services;

import mx.metaphorce.models.Conference;

import java.util.List;

public interface IConferenceService {

    List<Conference> findAll();
    List<Conference> findAllByUser(Long userId);
    Conference findById(Long id);
    Conference save(Conference conference);
    Conference update(Conference conference) throws Exception;
    void deleteById(Long id);
}
