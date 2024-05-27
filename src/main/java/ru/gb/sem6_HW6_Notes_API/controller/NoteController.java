package ru.gb.sem6_HW6_Notes_API.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.sem6_HW6_Notes_API.model.Note;
import ru.gb.sem6_HW6_Notes_API.repository.NoteRepository;
import ru.gb.sem6_HW6_Notes_API.service.NoteService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Notes")
public class NoteController {
    /*
    1. Добавление заметки. (Подсказка @PostMapping ) +
    2. Просмотр всех заметок.(Подсказка @GetMapping ) +
    3. Получение заметки по id. (Подсказка @GetMapping("/{id}") ) +
    4. Редактирование заметки.(Подсказка @PutMapping("/{id}") )
    5. Удаление заметки.(Подсказка @DeleteMapping("/{id}") )
     */

    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<List<Note>> getAll(){
        return new ResponseEntity<>(noteService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.addNote(note), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Note> findById(@PathVariable("id") Long id){
        Note note;
        try {
            noteService.getById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(noteService.getById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.changeNote(note), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
