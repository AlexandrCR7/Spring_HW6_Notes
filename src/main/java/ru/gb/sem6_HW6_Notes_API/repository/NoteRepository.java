package ru.gb.sem6_HW6_Notes_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.sem6_HW6_Notes_API.model.Note;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {

    /*
    Репозиторий наследует JpaRepository<Note, Long>.
    В репозитории добавляем метод Optional<Note> findById(Long id);
     */
    Optional<Note> findById(Long id);

}
