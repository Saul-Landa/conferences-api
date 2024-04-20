package mx.metaphorce.services;

import mx.metaphorce.entity.Gender;

import java.util.List;

public interface IGenderService {
    Gender findByName(String name);
    List<Gender> findAll();
    Gender save(Gender gender);
}
