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

    // Найти и удалить все записи, где delete = true
    List<Organizer> organizersToDelete = organizerRepository.findByDeleteTrue();

    // Удаляем найденные записи
    if (!organizersToDelete.isEmpty()) {
      organizerRepository.deleteAll(organizersToDelete);
      System.out.println("Deleted " + organizersToDelete.size() + " organizers marked for deletion.");
    } else {
      System.out.println("No organizers marked for deletion found.");
    }

    /*// Найдем записи, созданные более 30 дней назад
    LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
    List<Organizer> oldOrganizers = organizerRepository.findByDateCreateBefore(thirtyDaysAgo);

    System.out.println("Found " + oldOrganizers.size() + " organizers to delete."); //логирование

    // Удаляем найденные записи
    if (!oldOrganizers.isEmpty()) {
      organizerRepository.deleteAll(oldOrganizers);
      System.out.println("Deleted " + oldOrganizers.size() + " organizers.");
    } else {
      System.out.println("No old organizers found.");
    }*/
  }
}
