package com.pet_project.my_data_library.service;

import com.pet_project.my_data_library.persistence.entity.Film;
import com.pet_project.my_data_library.persistence.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Film addFilm(Film film) {
        return filmRepository.save(film);
    }

    public void deleteFilm(UUID id) {
        filmRepository.deleteById(id);
    }

}
