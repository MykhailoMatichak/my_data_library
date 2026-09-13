package com.pet_project.my_data_library.persistence.repository;

import com.pet_project.my_data_library.persistence.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LibraryRepository extends JpaRepository<Book, UUID> {

}
