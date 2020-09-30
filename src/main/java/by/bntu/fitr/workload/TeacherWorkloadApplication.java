package by.bntu.fitr.workload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class TeacherWorkloadApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeacherWorkloadApplication.class, args);
    }

}
