package com.pet_project.my_data_library.persistence.repository;

import com.pet_project.my_data_library.persistence.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FilmRepository extends JpaRepository<Film, UUID> {

}
