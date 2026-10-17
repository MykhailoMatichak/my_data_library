package com.pet_project.my_data_library.service;

import com.pet_project.my_data_library.persistence.entity.Manga;
import com.pet_project.my_data_library.persistence.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MangaService {
    @Autowired
    private MangaRepository mangaRepository;

    public List<Manga> getAllMangas() {
        return mangaRepository.findAll();
    }

    public Manga addManga(Manga manga) {
        return mangaRepository.save(manga);
    }

    public void deleteManga(UUID id) {
        mangaRepository.deleteById(id);
    }
}
