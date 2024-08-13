package ru.albert.springliquibase.service;

import org.springframework.stereotype.Service;
import ru.albert.springliquibase.entity.Organizer;
import ru.albert.springliquibase.repository.OrganizerRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DataCleanupService {

  private final OrganizerRepository organizerRepository;

  public DataCleanupService(OrganizerRepository organizerRepository) {
    this.organizerRepository = organizerRepository;
  }

  public void cleanUp() {
    // Логика для удаления данных из БД
    System.out.println("Performing data cleanup...");

    // Найдем записи, созданные более 30 секунд назад
    LocalDateTime thirtySecondsAgo = LocalDateTime.now().minusSeconds(30);
    List<Organizer> oldOrganizers = organizerRepository.findByDateCreateBefore(thirtySecondsAgo);

    System.out.println("Found " + oldOrganizers.size() + " organizers to delete."); //логирование

    // Удаляем найденные записи
    if (!oldOrganizers.isEmpty()) {
      organizerRepository.deleteAll(oldOrganizers);
      System.out.println("Deleted " + oldOrganizers.size() + " organizers.");
    } else {
      System.out.println("No old organizers found.");
    }
  }
}
