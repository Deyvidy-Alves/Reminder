package org.example.reminder.controller;

import jakarta.validation.Valid;
import org.example.reminder.dto.ReminderRequestDTO;
import org.example.reminder.entity.Reminder;
import org.example.reminder.service.ReminderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reminders")
public class ReminderController {

    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @PostMapping
    public Reminder createPost(@RequestBody @Valid ReminderRequestDTO dados) {
        return reminderService.create(dados);
    }

    @GetMapping
    public List<Reminder> listAll() {
        return reminderService.getAll();
    }


}
