package cn.edu.bupt.gpuworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GpuworkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GpuworkerApplication.class, args);
    }
}
