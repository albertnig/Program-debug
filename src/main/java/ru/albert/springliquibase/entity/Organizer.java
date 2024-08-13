package ru.albert.springliquibase.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "organizers")
public class Organizer {

  @Id
  private UUID id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "date_create", nullable = false)
  private LocalDateTime dateCreate;

  public Organizer() {
  }

  public Organizer(UUID id, String name, LocalDateTime dateCreate) {
    this.id = id;
    this.name = name;
    this.dateCreate = dateCreate;
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

  public LocalDateTime getDateCreate() {
    return dateCreate;
  }

  public void setDateCreate(LocalDateTime dateCreate) {
    this.dateCreate = dateCreate;
  }
}
