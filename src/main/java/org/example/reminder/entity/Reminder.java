package org.example.reminder.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Entity

public class Reminder{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false) //Garante que o banco não aceita nulo
    private String title;

    private String description;

    @Column(nullable = false) //Garante que o banco não aceita nulo
    private LocalDateTime dueDate;

    @Column(nullable = false) //Garante que o banco não aceita nulo
    private Boolean completed = false;

    @CreationTimestamp //Atualiza a data sempre que alguém criar
    @Column(updatable = false) //Não deixa mudarem a data depois de criar
    private LocalDateTime createdAt;

    @UpdateTimestamp //Atualiza a data sempre que alguém editar
    private LocalDateTime updatedAt;

    public Long getId() {
	    return id;
    }
    public void setId(Long id) {
	    this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


}
