package by.bntu.fitr.workload.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"by.bntu.fitr.workload.*"})
@EntityScan(basePackages = {"by.bntu.fitr.workload.repository.entity"})
@EnableJpaRepositories(basePackages = {"by.bntu.fitr.workload.repository.dataaccess"})
public class WebConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

}
