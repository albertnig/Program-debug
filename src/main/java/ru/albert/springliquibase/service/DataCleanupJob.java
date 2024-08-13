package ru.albert.springliquibase.service;

import org.quartz.JobExecutionContext;
import org.quartz.PersistJobDataAfterExecution;
import org.quartz.DisallowConcurrentExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class DataCleanupJob extends QuartzJobBean {

  private DataCleanupService dataCleanupService;

  @Autowired
  public void setDataCleanupService(DataCleanupService dataCleanupService) {
    this.dataCleanupService = dataCleanupService;
  }

  @Override
  protected void executeInternal(JobExecutionContext context) {
    System.out.println("Job triggered"); // логирование
    dataCleanupService.cleanUp();
  }
}

