package org.example.reminder.service;

import org.example.reminder.dto.ReminderRequestDTO;
import org.example.reminder.entity.Reminder;
import org.example.reminder.exception.ResourceNotFoundException;
import org.example.reminder.repository.ReminderRepository;
import org.springframework.data.domain.Sort;
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

    public List<Reminder> findAll() {
        return reminderRepository.findAll(Sort.by("dueDate").ascending());
    }

    public void delete(Long id) {
        if (!reminderRepository.existsById(id)) {
            throw new ResourceNotFoundException("Lembrete não encontrado com id: " + id);
        }
        reminderRepository.deleteById(id);
    }

    public Reminder update(Long id, ReminderRequestDTO dto) {
        Reminder entity = reminderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lembrete não encontrado com id: " + id));
        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setDueDate(dto.dueDate());

        if (dto.completed() != null) {
            entity.setCompleted(dto.completed());
        }

        return reminderRepository.save(entity);
    }

}