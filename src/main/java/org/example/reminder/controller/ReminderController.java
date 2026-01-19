package org.example.reminder.controller;

import jakarta.validation.Valid;
import org.example.reminder.dto.ReminderRequestDTO;
import org.example.reminder.entity.Reminder;
import org.example.reminder.service.ReminderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    private final ReminderService service;

    public ReminderController(ReminderService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reminder create(@RequestBody @Valid ReminderRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<Reminder> findAll() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public Reminder update(@PathVariable Long id, @RequestBody @Valid ReminderRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}