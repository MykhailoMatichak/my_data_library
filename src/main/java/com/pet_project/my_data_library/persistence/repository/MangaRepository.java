package com.pet_project.my_data_library.persistence.repository;

import com.pet_project.my_data_library.persistence.entity.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface MangaRepository extends JpaRepository<Manga, UUID> {
}
