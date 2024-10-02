package ru.albert.springliquibase.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "organizers")
public class Organizer {

  @Id
  private UUID id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "delete")
  private boolean delete;

  @Column(name = "date_create", nullable = false)
  private LocalDateTime dateCreate;

  @Column(name = "date_delete")
  private LocalDateTime dateDelete;

  public Organizer() {
  }

  public Organizer(UUID id, String name, boolean delete, LocalDateTime dateCreate, LocalDateTime dateDelete) {
    this.id = id;
    this.name = name;
    this.delete = delete;
    this.dateCreate = dateCreate;
    this.dateDelete = dateDelete;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isDelete() {
    return delete;
  }

  public void setDelete(boolean delete) {
    this.delete = delete;
  }

  public LocalDateTime getDateCreate() {
    return dateCreate;
  }

  public void setDateCreate(LocalDateTime dateCreate) {
    this.dateCreate = dateCreate;
  }

  public LocalDateTime getDateDelete() {
    return dateDelete;
  }

  public void setDateDelete(LocalDateTime dateDelete) {
    this.dateDelete = dateDelete;
  }
}
