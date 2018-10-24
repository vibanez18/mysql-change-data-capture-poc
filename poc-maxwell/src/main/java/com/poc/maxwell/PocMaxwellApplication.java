package com.poc.maxwell;

import com.zendesk.maxwell.Maxwell;
import com.zendesk.maxwell.MaxwellConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PocMaxwellApplication {

    @Value("#{'${poc-maxwell.maxwell.props}'.split(',')}")
    private String[] myProps;

    public static void main(String[] args) {
        SpringApplication.run(PocMaxwellApplication.class, args);

    }

    @Bean
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    @Bean
    public CommandLineRunner schedulingRunner(TaskExecutor executor) {
        return args -> {
            MaxwellConfig config = new MaxwellConfig(myProps);
            executor.execute(new Maxwell(config));
        };
    }
}
