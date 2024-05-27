package ru.gb.sem6_HW6_Notes_API.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "noteBooks")
public class Note {

    /*
    - ID (автоинкрементное)(тип - Long)
    - Заголовок (не может быть пустым)(тип - String)
    - Содержимое (не может быть пустым)(тип - String)
    - Дата создания (автоматически устанавливается при создании заметки)(тип - LocalDateTime)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDateTime localDateTime;

}
