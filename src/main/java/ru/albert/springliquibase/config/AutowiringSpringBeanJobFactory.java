package ru.albert.springliquibase.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.stereotype.Component;

@Component
public class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {

  private ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @Override
  protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
    Object job = super.createJobInstance(bundle);
    applicationContext.getAutowireCapableBeanFactory().autowireBean(job);
    return job;
  }
}

