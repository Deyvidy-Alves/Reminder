package org.example.reminder.dto;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull; // Importante para datas
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record ReminderRequestDTO (

    @NotBlank(message = "O título é obrigatório")
    String title,

    @Size(max = 255)
    String description,

    @NotNull(message = "A data é obrigatória")
    @Future(message = "A data deve ser no futuro")
    LocalDateTime dueDate

) {}
