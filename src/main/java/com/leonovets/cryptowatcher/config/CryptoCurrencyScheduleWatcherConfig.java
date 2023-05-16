package com.leonovets.cryptowatcher.config;

import com.leonovets.cryptowatcher.service.business.CryptoCurrencyUpdaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author Mikhail.Leonovets
 * @since 05/16/2023 - 11:29
 */
@RequiredArgsConstructor
@EnableScheduling
@Configuration
public class CryptoCurrencyScheduleWatcherConfig implements SchedulingConfigurer {
    private final CryptoCurrencyUpdaterService cryptoCurrencyUpdaterService;

    @Bean
    public Executor taskExecutor() {
        return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void configureTasks(final ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
        taskRegistrar.addTriggerTask(
                cryptoCurrencyUpdaterService::cryptoCurrencyUpdate,
                new CronTrigger("*/1 * * * * ?")
        );
    }
}
