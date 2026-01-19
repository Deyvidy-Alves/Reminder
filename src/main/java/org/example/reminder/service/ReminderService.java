package org.example.reminder.service;
import org.example.reminder.dto.ReminderRequestDTO;
import org.example.reminder.entity.Reminder;
import org.example.reminder.repository.ReminderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService {

    private final ReminderRepository reminderRepository;

    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    public Reminder create(ReminderRequestDTO dto) {

        Reminder entity = new Reminder();

        entity.setTitle( dto.title() );
        entity.setDescription( dto.description() );
        entity.setDueDate( dto.dueDate() );

        return reminderRepository.save(entity);
    }

    public List<Reminder> getAll() {
        return reminderRepository.findAll();
    }

    public void delete(Long id) {
        reminderRepository.deleteById(id);
    }

}