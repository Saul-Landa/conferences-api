package mx.metaphorce.controllers;

import mx.metaphorce.models.Conference;
import mx.metaphorce.services.IConferenceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConferenceController {

    private final IConferenceService conferenceService;

    public ConferenceController(IConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping("/")
    public List<Conference> findAll() {
        return conferenceService.findAll();
    }

    @GetMapping("/{id}")
    public Conference findById(@PathVariable Long id) {
        return conferenceService.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Conference save(@RequestBody Conference conference) {
        return conferenceService.save(conference);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Conference update(@RequestBody Conference conference) throws Exception {
        return conferenceService.update(conference);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        conferenceService.deleteById(id);
    }

    @GetMapping("/user/{id}")
    public List<Conference> findAllByUser(@PathVariable Long id) {
        return conferenceService.findAllByUser(id);
    }
}
