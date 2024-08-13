package ru.albert.springliquibase.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.CronScheduleBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import ru.albert.springliquibase.service.DataCleanupJob;

@Configuration
public class QuartzConfig {

  @Bean
  public JobDetail dataCleanupJobDetail() {
    return JobBuilder.newJob(DataCleanupJob.class)
      .withIdentity("dataCleanupJob", "dataCleanupGroup")
      .storeDurably()
      .build();
  }

  @Bean
  public Trigger dataCleanupTrigger() {
    return TriggerBuilder.newTrigger()
      .forJob(dataCleanupJobDetail())
      .withIdentity("dataCleanupTrigger", "dataCleanupGroup")
      .withSchedule(CronScheduleBuilder.cronSchedule("*/3 * * * * ?")) // каждые 3 секунды
      .build();
  }

  @Bean
  public AutowiringSpringBeanJobFactory springBeanJobFactory(ApplicationContext applicationContext) {
    AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
    jobFactory.setApplicationContext(applicationContext);
    return jobFactory;
  }

  @Bean
  public SchedulerFactoryBean schedulerFactoryBean(AutowiringSpringBeanJobFactory springBeanJobFactory, Trigger dataCleanupTrigger, JobDetail dataCleanupJobDetail) {
    SchedulerFactoryBean factory = new SchedulerFactoryBean();
    factory.setJobFactory(springBeanJobFactory);
    factory.setJobDetails(dataCleanupJobDetail);
    factory.setTriggers(dataCleanupTrigger);
    return factory;
  }

  @Bean
  public Scheduler scheduler(SchedulerFactoryBean factory) throws SchedulerException {
    Scheduler scheduler = factory.getScheduler();
    scheduler.start();
    return scheduler;
  }
}

