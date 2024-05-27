package ru.gb.sem6_HW6_Notes_API.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.sem6_HW6_Notes_API.model.Note;
import ru.gb.sem6_HW6_Notes_API.repository.NoteRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class NoteService {

        /*
    1. Добавление заметки. (Подсказка @PostMapping )
    2. Просмотр всех заметок.(Подсказка @GetMapping )
    3. Получение заметки по id. (Подсказка @GetMapping("/{id}") )
    4. Редактирование заметки.(Подсказка @PutMapping("/{id}") )
    5. Удаление заметки.(Подсказка @DeleteMapping("/{id}") )
     */

    private final NoteRepository repository;

    public List<Note> getAll() {
        return repository.findAll();
    }

    public Note getById(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    public Note addNote(Note note) {
        return repository.save(note);
    }

    public Note changeNote(Note note) {
        Note noteById = getById(note.getId());
        noteById.setTitle(note.getTitle());
        noteById.setDescription(note.getDescription());
        noteById.setLocalDateTime(LocalDateTime.now());
        return repository.save(noteById);
    }

    public void deleteNote(Long id) {
        Note noteById = getById(id);
        repository.delete(noteById);
    }

}
