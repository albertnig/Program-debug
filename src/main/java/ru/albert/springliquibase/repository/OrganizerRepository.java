package ru.albert.springliquibase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.albert.springliquibase.entity.Organizer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, UUID> {
  /*// Метод для поиска записей старше определенной даты
  List<Organizer> findByDateCreateBefore(LocalDateTime date);*/

  // Метод для поиска записей с delete = true
  List<Organizer> findByDeleteTrue();
}


